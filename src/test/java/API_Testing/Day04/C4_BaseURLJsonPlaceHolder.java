package API_Testing.Day04;

import baseUrlPackage.baseUrl_JSONHolder;
import io.restassured.response.Response;

import org.hamcrest.Matcher;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C4_BaseURLJsonPlaceHolder extends baseUrl_JSONHolder {
 /*
   Class icinde 3 Test metodu olusturun ve asagidaki testleri yapin
   1- https://jsonplaceholder.typicode.com/posts endpointine bir GET request
      gonderdigimizde donen response'un status code'unun 200 oldugunu ve
      Response'ta 100 kayit oldugunu test edin

   2-https://jsonplaceholder.typicode.com/posts/44 endpointine bir GET request
     gonderdigimizde donen response'un status code'unun 200 oldugunu ve "title"  degerinin
     "optio dolor molestias sit" oldugunu test edin

   3-https://jsonplaceholder.typicode.com/posts/50 endpointine bir DELETE request
     gonderdigimizde donen response'un status code'unun 200 oldugunu ve response
     body'sinin null oldugunu test edin
    */

    @Test
    public void get01() {
        /*
   1- https://jsonplaceholder.typicode.com/posts endpointine bir GET request
      gonderdigimizde donen response'un status code'unun 200 oldugunu ve
      Response'ta 100 kayit oldugunu test edin
         */

        // 1- endpoint hazirlama
        specJSONHolder.pathParam("pp1", "posts");

        // 2- Expected Data hazirlama

        // 3- Response kaydetme
        Response response = given()
                .spec(specJSONHolder)
                .when()
                .get("/{pp1}");

        // 4- Assertion

        response.then().assertThat()
                .statusCode(200)
                .body("body", hasSize(100));
    }

    @Test
    public void get02() {
        /*
        2-  https://jsonplaceholder.typicode.com/posts/44 endpointine bir GET request
            gonderdigimizde donen response'un status code'unun 200 oldugunu ve "title"  degerinin
            "optio dolor molestias sit" oldugunu test edin
         */

        // 1- Endpoint tanimlama
        specJSONHolder.pathParams("pp1", "posts", "pp2", 44);

        // 2- Expected Data hazirlama

        // 3-Response kaydetme
        Response response = given()
                .spec(specJSONHolder)
                .when()
                .get("/{pp1}/{pp2}");

        // 4- Assertion
        response.then().assertThat()
                .statusCode(200)
                .body("title", equalTo("optio dolor molestias sit"));

    }

    @Test
    public void get03() {
        /*
            3-https://jsonplaceholder.typicode.com/posts/50 endpointine bir DELETE request
            gonderdigimizde donen response'un status code'unun 200 oldugunu ve response
            body'sinin null oldugunu test edin
         */

        // 1- EndPoint tanimlama
        specJSONHolder.pathParams("pp1", "posts", "pp2", 50);

        // 2- Expected Data hazirlama

        // 3-Response kaydetme
        Response response = given().spec(specJSONHolder).when().delete("/{pp1}/{pp2}");

        // 4- Assert islemi
        response.then().assertThat()
                .statusCode(200)
                .body("title", nullValue());


    }
}
