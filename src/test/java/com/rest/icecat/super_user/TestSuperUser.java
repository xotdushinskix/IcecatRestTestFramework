package com.rest.icecat.super_user;

import com.rest.icecat.helpers.JSONworker;
import com.rest.icecat.helpers.TextWorker;
import com.rest.icecat.request.DeleteRequest;
import com.rest.icecat.request.GetRequest;
import com.rest.icecat.request.PostRequest;
import com.rest.icecat.test_frame.TestConditionsForSuperUser;
import com.rest.icecat.users.super_user.SuperUserData;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by nikita on 07.12.16.
 */
public class TestSuperUser extends TestConditionsForSuperUser {

    private static PostRequest postRequest;
    private static TextWorker textWorker;
    private static SuperUserData superUserData;
    private static JSONworker jsonWorker;
    private static DeleteRequest deleteRequest;
    private static GetRequest getRequest;


    @BeforeClass
    public static void setUp() {
        postRequest = new PostRequest();
        textWorker = new TextWorker();
        superUserData = new SuperUserData();
        jsonWorker = new JSONworker();
        deleteRequest = new DeleteRequest();
        getRequest = new GetRequest();
    }




    @Test
    public void testPostWithFullInfo() throws IOException {
        JSONObject postResponse = postRequest.postRequest(superUserData.FULL_PROD_DESC, textWorker.accessKeyReader(),
                "https://bo.icecat.biz/restful/v2/descriptionblock/");

        String data = superUserData.FULL_PROD_DESC;

        Assert.assertEquals(String.valueOf(postResponse.get("product_id")), jsonWorker.getDataFromJson(data, "productId"));
        Assert.assertEquals(postResponse.get("message"), "Created");
        Assert.assertNotNull(String.valueOf(postResponse.get("product_description_id")));
        Assert.assertEquals(String.valueOf(postResponse.get("langid")), jsonWorker.getDataFromJson(data, "langId"));
        Assert.assertEquals(String.valueOf(postResponse.get("responseStatus")), "201");

    }




    @Test
    public void testDelete() throws IOException {
        postRequest.postRequest(superUserData.FULL_PROD_DESC, textWorker.accessKeyReader(),
                "https://bo.icecat.biz/restful/v2/descriptionblock/");

        JSONObject deleteResponse = deleteRequest.deleteRequest(superUserData.FULL_PROD_DESC, textWorker.accessKeyReader(),
                "https://bo.icecat.biz/restful/v2/descriptionblock/");

        String data = superUserData.FULL_PROD_DESC;

        Assert.assertEquals(deleteResponse.get("message"), "Deleted");
        Assert.assertEquals(String.valueOf(deleteResponse.get("product_id")), jsonWorker.getDataFromJson(data, "productId"));
        Assert.assertEquals(String.valueOf(deleteResponse.get("langid")), jsonWorker.getDataFromJson(data, "langId"));
        Assert.assertEquals(String.valueOf(deleteResponse.get("responseStatus")), "200");

    }




    @Test
    public void testGet() throws IOException {
        postRequest.postRequest(superUserData.FULL_PROD_DESC_GET, textWorker.accessKeyReader(),
                "https://bo.icecat.biz/restful/v2/descriptionblock/");

        JSONObject getResponse = getRequest.getRequest(superUserData.FULL_PROD_DESC_GET, textWorker.accessKeyReader(),
                "https://bo.icecat.biz/restful/v2/descriptionblock/");

        String data = superUserData.FULL_PROD_DESC_GET;

        Assert.assertEquals(getResponse.get("responseStatus"), 200);

        JSONObject dataSectionResp = (JSONObject) getResponse.get("data");
        JSONObject dataKey = jsonWorker.fromStrToJSON(data);
        JSONObject fullInfo = (JSONObject) dataKey.get("fullInfo");

        Assert.assertEquals(String.valueOf(dataSectionResp.get("langid")), jsonWorker.getDataFromJson(data, "langId"));
        Assert.assertEquals(String.valueOf(dataSectionResp.get("short_desc")), jsonWorker.getDataFromJson(data, "shortDescrip"));
        Assert.assertNotNull(String.valueOf(dataSectionResp.get("product_description_id")));
        Assert.assertEquals(String.valueOf(dataSectionResp.get("long_desc")), fullInfo.get("long_desc"));
        Assert.assertEquals(String.valueOf(dataSectionResp.get("official_url")), fullInfo.get("official_url"));
        Assert.assertEquals(String.valueOf(dataSectionResp.get("warranty_info")), fullInfo.get("warranty_info"));
        Assert.assertEquals(String.valueOf(dataSectionResp.get("seo_title")), fullInfo.get("seo_title"));
        Assert.assertEquals(String.valueOf(dataSectionResp.get("seo_description")), fullInfo.get("seo_description"));
        Assert.assertEquals(String.valueOf(dataSectionResp.get("seo_keywords")), fullInfo.get("seo_keywords"));
        Assert.assertEquals(String.valueOf(dataSectionResp.get("disclaimer")), fullInfo.get("disclaimer"));
        Assert.assertEquals(String.valueOf(dataSectionResp.get("middle_desc")), fullInfo.get("middle_desc"));

        deleteRequest.deleteRequest(superUserData.FULL_PROD_DESC_GET, textWorker.accessKeyReader(), superUserData.URL);

    }




}
