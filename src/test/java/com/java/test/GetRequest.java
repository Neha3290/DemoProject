package com.java.test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.http.HttpRequest;

public class GetRequest {

        @Test
        public void ListOfUsers()
        {
                //Define Base URI
                RestAssured.baseURI="https://reqres.in/api/";

                //Specify the Request
                RequestSpecification httpRequest = RestAssured.given();

                //Fetching the Response
                Response response = httpRequest.request("GET", "users?page=2");

                System.out.println("Response is="+response.asString());

                System.out.println("Response Code is ="+response.statusCode());


                Assert.assertEquals(response.statusCode(),200);

                JsonPath jsonPathEvaluator = response.jsonPath();

                System.out.println("Total Pages are ="+jsonPathEvaluator.get("total"));

                Assert.assertEquals(jsonPathEvaluator.get("total").toString(),"12");

                System.out.println("Status Line is ="+response.statusLine());


        }

}
