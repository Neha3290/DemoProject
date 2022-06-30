package com.java.test;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class PostHeader {

    @Test
    public void postHeader()
    {
    //Base URI
        RestAssured.baseURI="https://bookstore.toolsqa.com/";

        //Prepare Request Body
        JSONObject isbnJson = new JSONObject();
        isbnJson.put("isbn", "9781449325862");

        JSONArray collectionOfIsbnsArray = new JSONArray();
        collectionOfIsbnsArray.add(isbnJson);


        JSONObject main = new JSONObject();
        main.put("userId","92482797-d20d-45ac-88a4-9209b75feddf");
        main.put("collectionOfIsbns",collectionOfIsbnsArray);

        //Create Request Body
        RequestSpecification httpRequest =RestAssured.given();
        httpRequest.body(main.toJSONString());
        httpRequest.header("Authorization","Basic dGVzdDk4NzpUZXN0QDk4Nw==");
        httpRequest.header("Content-Type","application/json");

        //Execute Request
        Response response =httpRequest.request("POST","BookStore/v1/Books");

        System.out.println("Response is ="+response.asString());


    }
}
