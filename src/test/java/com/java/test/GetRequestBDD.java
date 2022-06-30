package com.java.test;



import io.restassured.config.LogConfig;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class GetRequestBDD {
    RequestSpecification requestSpecification;
    @BeforeClass
    public void beforeClass()
    {
      requestSpecification =
                given().baseUri("https://bookstore.toolsqa.com/").
                        header("Authorization", "Basic dGVzdDk4NzpUZXN0QDk4Nw==").
                        header("Content-Type","application/json").
                        config(config.logConfig(LogConfig.logConfig().enableLoggingOfRequestAndResponseIfValidationFails()));
    }


    @Test
    public void validateResponseBody()
    {
        Response response = given(requestSpecification).when().get("BookStore/v1/Books").then().log().all().extract().response();
//                            given().
//                                    baseUri("https://bookstore.toolsqa.com/").
//                                    header("Authorization", "Basic dGVzdDk4NzpUZXN0QDk4Nw==").
//                                    header("Content-Type","application/json").
//                                    config(config.logConfig(LogConfig.logConfig().enableLoggingOfRequestAndResponseIfValidationFails())).
//                            when().
//                                    get("BookStore/v1/Books").
//                            then().
//
//                                    body("books.title", is(hasItems("Git Pocket Guide",
//
//                                            "Designing Evolvable Web APIs with ASP.NET",
//                                            "Speaking JavaScript",
//                                            "You Don't Know JS",
//                                            "Programming JavaScript Applications",
//                                            "Eloquent JavaScript, Second Edition",
//                                            "Understanding ECMAScript 6")),
//                                            "books.subTitle", hasSize(8));



//        System.out.println("Response Body is="+ response.asString());
//        JsonPath jsonPath = response.jsonPath();
//        System.out.println(jsonPath.getString("books[0].title"));




    }
}
