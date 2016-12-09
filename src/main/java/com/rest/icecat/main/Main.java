package com.rest.icecat.main;

import com.rest.icecat.helpers.TextWorker;
import com.rest.icecat.request.AccessKeyPost;
import com.rest.icecat.super_user.SuperUserData;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;

/**
 * Created by nikita on 07.12.16.
 */
public class Main {

    public static void main(String[] args) {
        AccessKeyPost accessKeyPost = new AccessKeyPost();
        accessKeyPost.getAccessKey("ASfW9179vRL6U_G_EKPCBc9vBj2C2c1m");

        SuperUserData superUserData = null;
        superUserData = new SuperUserData();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject) parser.parse(superUserData.FULL_PROD_DESC);
            System.out.println(json.get("productId"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        TextWorker textWorker = new TextWorker();
        try {
            System.out.println(textWorker.accessKeyReader());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
