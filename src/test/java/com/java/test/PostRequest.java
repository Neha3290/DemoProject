package com.java.test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.http.HttpRequest;

public class PostRequest {

    @Test
    public void postRequest(){


        //Define Base URI
        RestAssured.baseURI="https://reqres.in/";


        //Creating Request Body

        JSONObject json=new JSONObject();
        json.put("name","test");
        json.put("job","QA");

        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.body(json.toJSONString());



        Response response= httpRequest.request("POST","api/users");


        System.out.println("Response is ="+response.asString());

        Assert.assertEquals(response.statusCode(),201);

        System.out.println("Status Line is ="+response.getStatusLine());
        //Assert.assertEquals(response.statusLine(),201);
        Boolean b=response.getStatusLine().contains("Created");

        Assert.assertEquals(b,true);


    }
}
