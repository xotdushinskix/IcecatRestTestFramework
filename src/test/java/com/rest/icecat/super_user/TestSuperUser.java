package com.rest.icecat.super_user;

import com.rest.icecat.helpers.JSONworker;
import com.rest.icecat.helpers.TextWorker;
import com.rest.icecat.request.*;
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

    private static PostRequest post;
    private static TextWorker textWorker;
    private static SuperUserData superUserData;
    private static JSONworker jsonWorker;
    private static DeleteRequest delete;
    private static GetRequest get;
    private static PatchRequest patch;
    private static PutRequest put;


    @BeforeClass
    public static void setUp() {
        post = new PostRequest();
        textWorker = new TextWorker();
        superUserData = new SuperUserData();
        jsonWorker = new JSONworker();
        delete = new DeleteRequest();
        get = new GetRequest();
        patch = new PatchRequest();
        put = new PutRequest();
    }




    @Test
    public void testPostWithFullInfo() throws IOException {
        JSONObject postResponse = post.postRequest(superUserData.FULL_PROD_DESC, textWorker.accessKeyReader(),
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
        post.postRequest(superUserData.FULL_PROD_DESC, textWorker.accessKeyReader(),
                "https://bo.icecat.biz/restful/v2/descriptionblock/");

        JSONObject deleteResponse = delete.deleteRequest(superUserData.FULL_PROD_DESC, textWorker.accessKeyReader(),
                "https://bo.icecat.biz/restful/v2/descriptionblock/");

        String data = superUserData.FULL_PROD_DESC;

        Assert.assertEquals(deleteResponse.get("message"), "Deleted");
        Assert.assertEquals(String.valueOf(deleteResponse.get("product_id")), jsonWorker.getDataFromJson(data, "productId"));
        Assert.assertEquals(String.valueOf(deleteResponse.get("langid")), jsonWorker.getDataFromJson(data, "langId"));
        Assert.assertEquals(String.valueOf(deleteResponse.get("responseStatus")), "200");

    }




    @Test
    public void testGet() throws IOException {
        post.postRequest(superUserData.FULL_PROD_DESC_GET, textWorker.accessKeyReader(),
                "https://bo.icecat.biz/restful/v2/descriptionblock/");

        JSONObject getResponse = get.getRequest(superUserData.FULL_PROD_DESC_GET, textWorker.accessKeyReader(),
                "https://bo.icecat.biz/restful/v2/descriptionblock/");

        String data = superUserData.FULL_PROD_DESC_GET;

        Assert.assertEquals(getResponse.get("responseStatus"), 200);

        JSONObject dataSectionResp = (JSONObject) getResponse.get("data");
        JSONObject dataKey = jsonWorker.fromStrToJSON(data);
        JSONObject fullInfo = (JSONObject) dataKey.get("fullInfo");

        Assert.assertEquals(dataSectionResp.get("langid"), jsonWorker.getDataFromJson(data, "langId"));
        Assert.assertEquals(dataSectionResp.get("short_desc"), jsonWorker.getDataFromJson(data, "shortDescrip"));
        Assert.assertNotNull(dataSectionResp.get("product_description_id"));
        Assert.assertEquals(dataSectionResp.get("long_desc"), fullInfo.get("long_desc"));
        Assert.assertEquals(dataSectionResp.get("official_url"), fullInfo.get("official_url"));
        Assert.assertEquals(dataSectionResp.get("warranty_info"), fullInfo.get("warranty_info"));
        Assert.assertEquals(dataSectionResp.get("seo_title"), fullInfo.get("seo_title"));
        Assert.assertEquals(dataSectionResp.get("seo_description"), fullInfo.get("seo_description"));
        Assert.assertEquals(dataSectionResp.get("seo_keywords"), fullInfo.get("seo_keywords"));
        Assert.assertEquals(dataSectionResp.get("disclaimer"), fullInfo.get("disclaimer"));
        Assert.assertEquals(dataSectionResp.get("middle_desc"), fullInfo.get("middle_desc"));
    }




    @Test
    public void testPatch() throws IOException {
        post.postRequest(superUserData.FULL_PROD_DESC, textWorker.accessKeyReader(),
                "https://bo.icecat.biz/restful/v2/descriptionblock/");

        JSONObject patchResponse = patch.patchRequest(superUserData.FULL_PROD_DESC_PATCH, textWorker.accessKeyReader(),
                "https://bo.icecat.biz/restful/v2/descriptionblock/");

        String data = superUserData.FULL_PROD_DESC_PATCH;

        Assert.assertEquals(patchResponse.get("responseStatus"), 200);
        Assert.assertEquals(String.valueOf(patchResponse.get("product_id")), jsonWorker.getDataFromJson(data, "productId"));
        Assert.assertNotNull(String.valueOf(patchResponse.get("product_description_id")));
        Assert.assertEquals(String.valueOf(patchResponse.get("message")), "Updated");
        Assert.assertEquals(String.valueOf(patchResponse.get("langid")), jsonWorker.getDataFromJson(data, "langId"));

        JSONObject getResponse = get.getRequest(superUserData.FULL_PROD_DESC_PATCH, textWorker.accessKeyReader(),
                "https://bo.icecat.biz/restful/v2/descriptionblock/");

        JSONObject dataSectionResp = (JSONObject) getResponse.get("data");
        JSONObject dataKey = jsonWorker.fromStrToJSON(data);
        JSONObject fullInfo = (JSONObject) dataKey.get("fullInfo");

        Assert.assertEquals(dataSectionResp.get("seo_description"), fullInfo.get("seo_description"));
        Assert.assertNotNull(dataSectionResp.get("seo_description"));
        Assert.assertEquals(dataSectionResp.get("official_url"), fullInfo.get("official_url"));
        Assert.assertEquals(dataSectionResp.get("short_desc"), jsonWorker.getDataFromJson(data, "shortDescrip"));
        Assert.assertEquals(dataSectionResp.get("langid"), jsonWorker.getDataFromJson(data, "langId"));
        Assert.assertEquals(dataSectionResp.get("warranty_info"), fullInfo.get("warranty_info"));
        Assert.assertEquals(dataSectionResp.get("seo_title"), fullInfo.get("seo_title"));
        Assert.assertEquals(dataSectionResp.get("disclaimer"), fullInfo.get("disclaimer"));
        Assert.assertEquals(dataSectionResp.get("long_desc"), fullInfo.get("long_desc"));
        Assert.assertEquals(dataSectionResp.get("seo_keywords"), fullInfo.get("seo_keywords"));
        Assert.assertEquals(dataSectionResp.get("middle_desc"), fullInfo.get("middle_desc"));
    }




    @Test
    public void testPutLikePost() throws IOException {
        JSONObject putResponse = put.putRequest(superUserData.FULL_PROD_DESC_PUT, textWorker.accessKeyReader(),
                "https://bo.icecat.biz/restful/v2/descriptionblock/");

        String data = superUserData.FULL_PROD_DESC_PUT;

        Assert.assertEquals(putResponse.get("responseStatus"), 200);
        Assert.assertEquals(String.valueOf(putResponse.get("product_id")), jsonWorker.getDataFromJson(data, "productId"));
        Assert.assertNotNull(putResponse.get("product_description_id"));
        Assert.assertEquals(putResponse.get("message"), "Upserted");
        Assert.assertEquals(String.valueOf(putResponse.get("langid")), jsonWorker.getDataFromJson(data, "langId"));

        JSONObject getResponse = get.getRequest(superUserData.FULL_PROD_DESC_PUT, textWorker.accessKeyReader(),
                "https://bo.icecat.biz/restful/v2/descriptionblock/");

        JSONObject dataSectionResp = (JSONObject) getResponse.get("data");
        JSONObject dataKey = jsonWorker.fromStrToJSON(data);
        JSONObject fullInfo = (JSONObject) dataKey.get("fullInfo");

        Assert.assertEquals(dataSectionResp.get("seo_description"), fullInfo.get("seo_description"));
        Assert.assertNotNull(dataSectionResp.get("seo_description"));
        Assert.assertEquals(dataSectionResp.get("official_url"), fullInfo.get("official_url"));
        Assert.assertEquals(dataSectionResp.get("short_desc"), jsonWorker.getDataFromJson(data, "shortDescrip"));
        Assert.assertEquals(dataSectionResp.get("langid"), jsonWorker.getDataFromJson(data, "langId"));
        Assert.assertEquals(dataSectionResp.get("warranty_info"), fullInfo.get("warranty_info"));
        Assert.assertEquals(dataSectionResp.get("seo_title"), fullInfo.get("seo_title"));
        Assert.assertEquals(dataSectionResp.get("disclaimer"), fullInfo.get("disclaimer"));
        Assert.assertEquals(dataSectionResp.get("long_desc"), fullInfo.get("long_desc"));
        Assert.assertEquals(dataSectionResp.get("seo_keywords"), fullInfo.get("seo_keywords"));
        Assert.assertEquals(dataSectionResp.get("middle_desc"), fullInfo.get("middle_desc"));
    }




    @Test
    public void testPutLikePatch() throws IOException {
        post.postRequest(superUserData.FULL_PROD_DESC_PUT, textWorker.accessKeyReader(),
                "https://bo.icecat.biz/restful/v2/descriptionblock/");

        JSONObject putResponse = put.putRequest(superUserData.FULL_PROD_DESC_PUT, textWorker.accessKeyReader(),
                "https://bo.icecat.biz/restful/v2/descriptionblock/");

        String data = superUserData.FULL_PROD_DESC_PUT;

        Assert.assertEquals(putResponse.get("responseStatus"), 200);
        Assert.assertEquals(String.valueOf(putResponse.get("product_id")), jsonWorker.getDataFromJson(data, "productId"));
        Assert.assertNotNull(putResponse.get("product_description_id"));
        Assert.assertEquals(putResponse.get("message"), "Upserted");
        Assert.assertEquals(String.valueOf(putResponse.get("langid")), jsonWorker.getDataFromJson(data, "langId"));

        JSONObject getResponse = get.getRequest(superUserData.FULL_PROD_DESC_PUT, textWorker.accessKeyReader(),
                "https://bo.icecat.biz/restful/v2/descriptionblock/");

        JSONObject dataSectionResp = (JSONObject) getResponse.get("data");
        JSONObject dataKey = jsonWorker.fromStrToJSON(data);
        JSONObject fullInfo = (JSONObject) dataKey.get("fullInfo");

        Assert.assertEquals(dataSectionResp.get("seo_description"), fullInfo.get("seo_description"));
        Assert.assertNotNull(dataSectionResp.get("seo_description"));
        Assert.assertEquals(dataSectionResp.get("official_url"), fullInfo.get("official_url"));
        Assert.assertEquals(dataSectionResp.get("short_desc"), jsonWorker.getDataFromJson(data, "shortDescrip"));
        Assert.assertEquals(dataSectionResp.get("langid"), jsonWorker.getDataFromJson(data, "langId"));
        Assert.assertEquals(dataSectionResp.get("warranty_info"), fullInfo.get("warranty_info"));
        Assert.assertEquals(dataSectionResp.get("seo_title"), fullInfo.get("seo_title"));
        Assert.assertEquals(dataSectionResp.get("disclaimer"), fullInfo.get("disclaimer"));
        Assert.assertEquals(dataSectionResp.get("long_desc"), fullInfo.get("long_desc"));
        Assert.assertEquals(dataSectionResp.get("seo_keywords"), fullInfo.get("seo_keywords"));
        Assert.assertEquals(dataSectionResp.get("middle_desc"), fullInfo.get("middle_desc"));

    }




}
