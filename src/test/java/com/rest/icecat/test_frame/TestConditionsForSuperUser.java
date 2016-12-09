package com.rest.icecat.test_frame;

import com.rest.icecat.helpers.TextWorker;
import com.rest.icecat.request.AccessKeyPost;
import com.rest.icecat.request.DeleteRequest;
import com.rest.icecat.super_user.SuperUserData;
import org.junit.After;
import org.junit.BeforeClass;

import java.io.IOException;

/**
 * Created by nikita on 07.12.16.
 */
public class TestConditionsForSuperUser {

    private static DeleteRequest deleteRequest;
    private static SuperUserData superUserData;
    private static TextWorker textWorker;


    @BeforeClass
    public static void testAccessKey() throws IOException {
        AccessKeyPost accessKeyPost = new AccessKeyPost();
        accessKeyPost.getAccessKey("secr_info");

        deleteRequest = new DeleteRequest();
        superUserData = new SuperUserData();
        textWorker = new TextWorker();

        deleteRequest.deleteRequest(superUserData.fullProdDesc, textWorker.accessKeyReader(),
                "https://bo.icecat.biz/restful/v2/descriptionblock/");
    }




    @After
    public void deleteProdDescrip() throws IOException {
        deleteRequest.deleteRequest(superUserData.fullProdDesc, textWorker.accessKeyReader(),
                "https://bo.icecat.biz/restful/v2/descriptionblock/");
    }

}
