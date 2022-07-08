package com.java.test;


import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.internal.ResponseSpecificationImpl;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.expect;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class createWorkspace {

    String reqPayload;
    Response response;



    @BeforeClass
    public void spec(){

//        RequestSpecification requestSpecification = given().
//                                                    baseUri("https://api.getpostman.com").
//                                                    header("x-api-key","x-api-key-value").
//                                                    header("Content-Type","application/json");
//
//        ResponseSpecification responseSpecification = expect().
//                statusCode(200).
//                header("Content-Type","application/json; charset=utf-8");


        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder().
                setBaseUri("https://api.getpostman.com").
                addHeader("x-api-key", "x-api-key-value").
                addHeader("Content-Type","application/json").
                log(LogDetail.ALL);
        RestAssured.requestSpecification = requestSpecBuilder.build();


        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder().
                expectStatusCode(200).
                expectHeader("Content-Type","application/json; charset=utf-8").
                log(LogDetail.ALL);
        RestAssured.responseSpecification =responseSpecBuilder.build();

    }

    @Test
    public void createNewWorkspace()
    {

        reqPayload ="   {\n" +
                "    \"workspace\": {\n" +
                "        \"name\": \"My Workspace3\",\n" +
                "        \"type\": \"personal\",\n" +
                "        \"description\": \"Some description\"\n" +
                "   \n" +
                "}\n" +
                "}";





                given().
                        body(reqPayload).
                when().
                        post("/workspaces/").
                then().
                        assertThat().
                        body("workspace.name",equalTo("My Workspace3"),
                                "workspace.id", Matchers.matchesPattern("^[a-z0-9-]{36}$"));




    }
}
