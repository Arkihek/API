package API_Testing.Day06;

import baseUrlPackage.BaseUrl_Dummy;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testdatas.DummyData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class C2_Get_DeSerialization extends BaseUrl_Dummy {
/*
    http://dummy.restapiexample.com/api/v1/employee/3 url'ine bir GET
    request gonderdigimizde donen response'un status code'unun 200,
    content Type'inin application/json ve body'sinin asagidaki gibi
    oldugunu test edin.

    Response Body
    {
    "status":"success",
    "data":{
            "id":3,
            "employee_name":"Ashton Cox",
            "employee_salary":86000,
            "employee_age":66,
            "profile_image":""
            },
    "message":"Successfully! Record has been fetched."
    }
 */
    @Test
    public void get01(){
        // 1- Url hazirlama
        specDummy.pathParams("pp1","api","pp2","v1","pp3","employee","pp4",3);

        // 2- ExpData hazirlama
        DummyData dummyData = new DummyData();
        HashMap<String,Object> expData = dummyData.expDataBodyOlusturmaMap();

        // 3- Response olusturma
        Response response = given().spec(specDummy).when().get("/{pp1}/{pp2}/{pp3}/{pp4}");
        HashMap<String,Object> resMap = response.as(HashMap.class);

        // 4- Assertion
        Assert.assertEquals(dummyData.statusCode,response.getStatusCode());
        Assert.assertEquals(dummyData.contentType,response.getContentType());

        Assert.assertEquals(expData.get("status"),resMap.get("status"));
        Assert.assertEquals(expData.get("message"),resMap.get("message"));

        Assert.assertEquals(((Map)(expData.get("data"))).get("id"),resMap.get("data.id"));
        Assert.assertEquals(((Map)(expData.get("data"))).get("employee_name"),resMap.get("data.employee_name"));
        Assert.assertEquals(((Map)(expData.get("data"))).get("employee_salary"),resMap.get("data.employee_salary"));
        Assert.assertEquals(((Map)(expData.get("data"))).get("employee_age"),resMap.get("data.employee_age"));
        Assert.assertEquals(((Map)(expData.get("data"))).get("profile_image"),resMap.get("data.profile_image"));




    }

}
