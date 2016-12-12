package com.rest.icecat.request;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.IOException;

/**
 * Created by nikita on 08.12.16.
 */
public class PostRequest {

    public JSONObject postRequest(String postData, String accessKey, String url) {

        JSONObject productInfo = new JSONObject();
        JSONParser parser = new JSONParser();

        JSONObject responseBody = null;

        try {
            productInfo = (JSONObject) parser.parse(postData);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        int responseStatus = 0;
        try {

            String fullURL = url + productInfo.get("productId") + "?" + "access_key=" + accessKey + "&langid="
                    + productInfo.get("langId") + "&short_desc=" + productInfo.get("shortDescrip") + "&session_type=" + "rest";

            HttpPost request = new HttpPost(fullURL);

            StringEntity params = new StringEntity(productInfo.get("fullInfo").toString());
            request.setEntity(params);


            HttpResponse httpResponse = httpClient.execute(request);
            HttpEntity entity = httpResponse.getEntity();
            responseBody = (JSONObject) parser.parse(EntityUtils.toString(entity, "UTF-8"));


            responseStatus = httpResponse.getStatusLine().getStatusCode();
            responseBody.put("responseStatus", responseStatus);


        } catch (Exception ex) {
            System.out.println("Cannot make accessKey post request");
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                System.out.println("Cannot close httpClient");
            }
        }

        return responseBody;

    }

}
