package API_Testing.Day04;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C3_Put_SoftAssertIleExpectedDataTesti {
    /*
            C14_Put_SoftAssertIleExpectedDataTesti
        http://dummy.restapiexample.com/api/v1/update/21 url’ine asagidaki body’ye sahip bir PUT request gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.
        Request Body
        {
        “status”: “success”,
        “data”: {
        “name”: “Ahmet”,
        “salary”: “1230”,
        “age”: “44”,
        “id”: 40
        }
        }
        Response Body
        {
        “status”: “success”,
        “data”: {
        “status”: “success”,
        “data”: {
        “name”: “Ahmet”,
        “salary”: “1230",
        “age”: “44",
        “id”: 40 }
        },
        “message”: “Successfully! Record has been updated.«
        }
     */

    @Test
    public void test01(){

        // 1- Endpoint kaydetme ve reqBody
        String url = "http://dummy.restapiexample.com/api/v1/update/21";

        JSONObject data = new JSONObject();
        data.put("name","Ahmet");
        data.put("salary","1230");
        data.put("age","44");
        data.put("id",40);

        JSONObject reqBody = new JSONObject();
        reqBody.put("status","success");
        reqBody.put("data",data);

        // 2- Exceptence Data olusturma
        JSONObject innerData1 = new JSONObject();
        innerData1.put("name","Ahmet");
        innerData1.put("salary","1230");
        innerData1.put("age","44");
        innerData1.put("id",40);

        JSONObject innerData2 = new JSONObject();
        innerData2.put("status","success");
        innerData2.put("data",innerData1);

        JSONObject expData =new JSONObject();
        expData.put("status","success");
        expData.put("data",innerData2);
        expData.put("message","Successfully! Record has been updated.");


        // 3- Respond kaydetme
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .body(reqBody.toString())
                .put(url);

        // 4- Assert
        SoftAssert softAssert = new SoftAssert();
        JsonPath jsonPath = response.jsonPath();
        softAssert.assertEquals(jsonPath.get("status"),expData.get("status"));





    }
}
