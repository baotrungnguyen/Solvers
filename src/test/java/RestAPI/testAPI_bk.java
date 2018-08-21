package RestAPI;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

//user define
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class testAPI_bk {
	public static final Logger logger = LogManager.getLogger("Test API");
	@Test
	public void test_api() throws Exception {
		RestAssured.baseURI ="http://restcountries.eu/rest/v1/name";
		RequestSpecification request = RestAssured.given();
	 
/*		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", "Virender"); // Cast
		requestParams.put("LastName", "Singh");
		requestParams.put("UserName", "sdimpleuser2dd2011");
		requestParams.put("Password", "password1");
	 
		requestParams.put("Email",  "sample2ee26d9@gmail.com");
		request.body(requestParams.toString());
		System.out.println("REQUEST: ---");
		System.out.println(request.toString());*/
		//Response response = request.post("/register");
		Response response = request.get("/LAO");
		int statusCode = response.getStatusCode();
		
		System.out.println("STATUS CODE: --- " + statusCode);
	}

}
