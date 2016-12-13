package com.rest.icecat.users.super_user;


/**
 * Created by nikita on 08.12.16.
 */
public class SuperUserData {

    public final String URL = "https://bo.icecat.biz/restful/v2/descriptionblock/";
    public final String LOGIN_URL = "https://bo.icecat.biz/user/login";
    public final String REQUIRED_KEY = "";
    public final String TEXT_FILE_HOME = "/home/nikita/HomeJava/IcecatRestTestFramework/access_key.txt";
    public final String TEXT_FILE_NAME = "access_key.txt";


    public final String FULL_PROD_DESC = "{\"productId\":\"22655827\", \"langId\":\"1\", \"shortDescrip\":\"test_short_description_superUser\"," +
            "\"fullInfo\":{\"long_desc\": \"Marketing text: <b>Text may contain html tags</b>\"," +
            "\"official_url\":\"http://www.tomtom.com/da_dk/drive/car/products/go-60-europe/\"," +
            "\"warranty_info\":\"warranty_info test\"," +
            "\"seo_title\":\"seo_title test\"," +
            "\"seo_description\":\"seo_description test\"," +
            "\"seo_keywords\":\"seo_keywords test\"," +
            "\"disclaimer\":\"disclaimer test\"," +
            "\"middle_desc\":\"middle_desc test\"}}";



    public final String FULL_PROD_DESC_GET = "{\"productId\":\"22655827\", \"langId\":\"1\", \"shortDescrip\":\"test_short_description_superUser_get\"," +
            "\"fullInfo\":{\"long_desc\": \"Marketing text: <b>Text may contain html tags_get!!!</b>\"," +
            "\"official_url\":\"http://www.get.com/da_dk/drive/car/products/go-60-europe/\"," +
            "\"warranty_info\":\"warranty_info test_get\"," +
            "\"seo_title\":\"seo_title test_get\"," +
            "\"seo_description\":\"seo_description test get\"," +
            "\"seo_keywords\":\"seo_keywords test get\"," +
            "\"disclaimer\":\"disclaimer test get\"," +
            "\"middle_desc\":\"middle_desc test get\"}}";



    public final String FULL_PROD_DESC_PATCH = "{\"productId\":\"22655827\", \"langId\":\"1\", \"shortDescrip\":\"test_short_description_superUser_patch\"," +
            "\"fullInfo\":{\"long_desc\": \"Marketing text: <b>Text may contain html tags_patch!!!</b>\"," +
            "\"official_url\":\"http://www.get.com/da_dk/drive/car/products/go-60-europe-patch/\"," +
            "\"warranty_info\":\"warranty_info test_patch\"," +
            "\"seo_title\":\"seo_title test_patch\"," +
            "\"seo_description\":\"seo_description test patch\"," +
            "\"seo_keywords\":\"seo_keywords test patch\"," +
            "\"disclaimer\":\"disclaimer test patch\"," +
            "\"middle_desc\":\"middle_desc test patch\"}}";



    public final String FULL_PROD_DESC_PUT = "{\"productId\":\"22655827\", \"langId\":\"1\", \"shortDescrip\":\"test_short_description_superUser_put\"," +
            "\"fullInfo\":{\"long_desc\": \"Marketing text: <b>Text may contain html tags_put!!!</b>\"," +
            "\"official_url\":\"http://www.get.com/da_dk/drive/car/products/go-60-europe-put/\"," +
            "\"warranty_info\":\"warranty_info test_put\"," +
            "\"seo_title\":\"seo_title test_put\"," +
            "\"seo_description\":\"seo_description test put\"," +
            "\"seo_keywords\":\"seo_keywords test put\"," +
            "\"disclaimer\":\"disclaimer test put\"," +
            "\"middle_desc\":\"middle_desc test put\"}}";



}
