package com.rest.icecat.super_user;

import com.rest.icecat.helpers.JSONworker;
import com.rest.icecat.helpers.TextWorker;
import com.rest.icecat.request.DeleteRequest;
import com.rest.icecat.request.PostRequest;
import com.rest.icecat.test_frame.TestConditionsForSuperUser;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by nikita on 07.12.16.
 */
public class TestSuperUserForSuperUser extends TestConditionsForSuperUser {

    private static PostRequest postRequest;
    private static TextWorker textWorker;
    private static SuperUserData superUserData;
    private static JSONworker jsonWorker;
    private static DeleteRequest deleteRequest;


    @BeforeClass
    public static void setUp() {
        postRequest = new PostRequest();
        textWorker = new TextWorker();
        superUserData = new SuperUserData();
        jsonWorker = new JSONworker();
        deleteRequest = new DeleteRequest();
    }



    @Test
    public void testPostWithFullInfo() throws IOException {
        JSONObject postResponse = postRequest.postRequest(superUserData.fullProdDesc, textWorker.accessKeyReader(),
                "https://bo.icecat.biz/restful/v2/descriptionblock/");

        String data = superUserData.fullProdDesc;

        Assert.assertEquals(String.valueOf(postResponse.get("product_id")), jsonWorker.getDataFromJson(data, "productId"));
        Assert.assertEquals(postResponse.get("message"), "Created");
        Assert.assertNotNull(String.valueOf(postResponse.get("product_description_id")));
        Assert.assertEquals(String.valueOf(postResponse.get("langid")), jsonWorker.getDataFromJson(data, "langId"));
        Assert.assertEquals(String.valueOf(postResponse.get("responseStatus")), "201");

    }




    @Test
    public void testDelete() throws IOException {
        postRequest.postRequest(superUserData.fullProdDesc, textWorker.accessKeyReader(),
                "https://bo.icecat.biz/restful/v2/descriptionblock/");

        JSONObject deleteResponse = deleteRequest.deleteRequest(superUserData.fullProdDesc, textWorker.accessKeyReader(),
                "https://bo.icecat.biz/restful/v2/descriptionblock/");

        String data = superUserData.fullProdDesc;

        Assert.assertEquals(deleteResponse.get("message"), "Deleted");
        Assert.assertEquals(String.valueOf(deleteResponse.get("product_id")), jsonWorker.getDataFromJson(data, "productId"));
        Assert.assertEquals(String.valueOf(deleteResponse.get("langid")), jsonWorker.getDataFromJson(data, "langId"));
        Assert.assertEquals(String.valueOf(deleteResponse.get("responseStatus")), "200");

    }

}
