package com.ilcarro.qa11.test;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RestAssured {

    @Test
    public void postRequestTest() {
        RequestSpecification httpRequest = io.restassured.RestAssured.given();

        Response response = httpRequest.given()
                .header("Content-Type", "application/json")// или .contentType(ContentType.JSON)
                .given().header("Authorization", "UnVzYWxkb0BnbWFpbC5jb206UXdlcnR5MTIzNDU2")
                .body("{\n" +
                        "  \"first_name\": \"Rusaldo\",\n" +
                        "  \"second_name\": \"Russ\"\n" +
                        "}").when()
                .post("https://java-3-ilcarro-team-b.herokuapp.com/registration");

        String responseBody = response.getBody().asString();
        System.out.println("Response body is " + responseBody);

        int statusCode = response.getStatusCode();
        System.out.println("Actual status code is " + statusCode);
        Assert.assertEquals(statusCode, 200, "BUG: status code is different");
    }

    @Test
    public void getLoginTest() {
        RequestSpecification httpRequest = io.restassured.RestAssured.given();

        Response response = httpRequest.given().contentType(ContentType.JSON)
                .given().header("Authorization", "UnVzYWxkb0BnbWFpbC5jb206UXdlcnR5MTIzNDU2")
                .request().get("https://java-3-ilcarro-team-b.herokuapp.com/user/login");

        String responseBody = response.getBody().asString();
        System.out.println("Response body is " + responseBody);

        int statusCode = response.getStatusCode();
        System.out.println("Actual status code is " + statusCode);
        Assert.assertEquals(statusCode, 200, "BUG: status code is different");
        JsonElement parsed = new JsonParser().parse(responseBody);
        String first_name = parsed.getAsJsonObject().get("first_name").toString();
        //String own_cars = parsed.getAsJsonObject().get("own_cars").toString();
        System.out.println(first_name);
        Assert.assertEquals(first_name, "\"Rusaldo\"", "BUG: the name is displayed doesn't equal expected name");
    }

    @Test
    public void putUpdateUser() {
        RequestSpecification httpRequest = io.restassured.RestAssured.given();
        Response response = httpRequest.given().contentType(ContentType.JSON)
                .given().header("Authorization", "UnVzYWxkb0BnbWFpbC5jb206UXdlcnR5MTIzNDU2")
                .body("{\n" +
                        "  \"first_name\": \"Rusal\",\n" +
                        "  \"photo\": \"string\",\n" +
                        "  \"second_name\": \"Ross\"\n" +
                        "}").when().
                        put("https://java-3-ilcarro-team-b.herokuapp.com/user");
        String responseBody = response.getBody().asString();
        System.out.println("Updated user is " + responseBody);

        int statusCode = response.getStatusCode();
        System.out.println("Actual status code is " + statusCode);
        Assert.assertEquals(statusCode, 200, "BUG: user isn't updated");
    }

    @Test
    public void deleteUserTest() {
        RequestSpecification httpRequest = io.restassured.RestAssured.given();

        Response response = httpRequest.given()
                .header("Authorization", "UnVzYWxkb0BnbWFpbC5jb206UXdlcnR5MTIzNDU2")
                .delete("https://java-3-ilcarro-team-b.herokuapp.com/user");

        int statusCode = response.getStatusCode();
        System.out.println("Actual status code is " + statusCode);
        Assert.assertEquals(statusCode, 200, "BUG: user isn't deleted");


    }
}
