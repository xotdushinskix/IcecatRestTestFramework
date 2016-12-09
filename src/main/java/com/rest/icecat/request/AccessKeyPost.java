package com.rest.icecat.request;

import com.rest.icecat.helpers.JSONworker;
import com.rest.icecat.helpers.TextWorker;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.simple.JSONObject;

import java.io.IOException;

/**
 * Created by nikita on 07.12.16.
 */
public class AccessKeyPost {

    private final String ACCESS_KEY_URL = "https://bo.icecat.biz/user/login";
    private final String APP_KEY = "application_key";


    public void getAccessKey(String requiredKey) {
        String accessKey = null;

        JSONObject json = new JSONObject();
        json.put(APP_KEY, requiredKey);

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();


        int responseStatus = 0;
        try {

            HttpPost request = new HttpPost(ACCESS_KEY_URL);
            StringEntity params = new StringEntity(json.toString());
            request.setEntity(params);

            HttpResponse httpResponse = httpClient.execute(request);
            HttpEntity entity = httpResponse.getEntity();

            JSONworker jsoNworker = new JSONworker();
            accessKey = jsoNworker.getJsonObject(entity, "access_key");
            TextWorker textWorker = new TextWorker();
            textWorker.textWriter(accessKey);
            responseStatus = httpResponse.getStatusLine().getStatusCode();



        } catch (Exception ex) {
            System.out.println("Cannot make accessKey post request");
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                System.out.println("Cannot close httpClient");
            }
        }


        assert (responseStatus == 200);
        assert (accessKey.length() != 0);

    }

}
