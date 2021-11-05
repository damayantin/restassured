package APITesting.com.org.api;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class WheatherGetRequest {
	

	// simple get request for getting wheather request by city name
	 @Test
	public void Test_01() {

		Response resp = when()
				.get("http://api.openweathermap.org/data/2.5/weather?q=London&appid=29519b0be1fec36be8509ee6b070a576");
		
		
		System.out.println(resp.getStatusCode());
		Assert.assertEquals(resp.getStatusCode(), 200);
	}

	 @Test
	public void Test_02() {

		Response resp = when()
				.get("http://api.openweathermap.org/data/2.5/weather?q=London&appid=29519b0be1fec36be8509ee6b070a5761");
		System.out.println(resp.getStatusCode());
		Assert.assertEquals(resp.getStatusCode(), 401);
	}

	 @Test
	public void Test_03() {

		Response resp = when()
				.get("http://api.openweathermap.org/data/2.5/weather?q=London&appid=29519b0be1fec36be8509ee6b070a576");
		System.out.println(resp.getStatusCode());
		Assert.assertEquals(resp.getStatusCode(), 200);
	}

	// How to use parameters with test assured
	 @Test
	public void Test_04() {

		Response resp = given().param("q", "London").param("appid", "29519b0be1fec36be8509ee6b070a576").when()
				.get("http://api.openweathermap.org/data/2.5/weather");

		System.out.println(resp.getStatusCode());
		Assert.assertEquals(resp.getStatusCode(), 200);
	}

	@Test
	public void Test_05() {

		Response resp = given().param("q", "London").param("appid", "29519b0be1fec36be8509ee6b070a576").when()
				.get("http://api.openweathermap.org/data/2.5/weather");
		System.out.println(resp.getStatusCode());

		if (resp.getStatusCode() == 200) {
			System.out.println("API is working fine");
		} else {
			System.out.println("API is not working fine");
		}
		Assert.assertEquals(resp.getStatusCode(), 200);

	} 

	@Test
	public void Test_06() {

		Response resp = given().param("q", "London").param("appid", "29519b0be1fec36be8509ee6b070a576").when()
				.get("http://api.openweathermap.org/data/2.5/weather");
		
		
		System.out.println(resp.getStatusCode());

		if (resp.getStatusCode() == 200) {
			System.out.println("API is working fine");
		} else {
			System.out.println("API is not working fine");
		}
		Assert.assertEquals(resp.getStatusCode(), 200);

	} 
    
	
	//Asset our testcase in reset assured api
	 @Test

	public void Test_07() {
		given().param("q", "London").param("appid", "29519b0be1fec36be8509ee6b070a576").when()
				.get("http://api.openweathermap.org/data/2.5/weather").then().assertThat().statusCode(200);

	}
	@Test

		public void Test_08() {
			Response resp = given().
		
		param("q", "London").
		param("appid", "29519b0be1fec36be8509ee6b070a576").
		when().get("http://api.openweathermap.org/data/2.5/weather");
		
			Assert.assertEquals(resp.getStatusCode(), 200);
						
									System.out.println("This is my testing:"+resp.asString());
		}	
	
	
	@Test

	public void Test_09() {
		
		String weatherReport = given().
				param("id", "2172797").
	param("appid", "29519b0be1fec36be8509ee6b070a576").
	when().
	get("http://api.openweathermap.org/data/2.5/weather").
	
	then().
	contentType(ContentType.JSON).	
	extract().
	path ("weather[0].description");
		
	System.out.println("wheather report :"+ weatherReport);
}

	
	@Test

	public void Test_010() {
		
	Response resp = given().
			param("id", "2172797").
		param("appid", "29519b0be1fec36be8509ee6b070a576").
		when().
		get("http://api.openweathermap.org/data/2.5/weather");
	
	String actualweatherreport = resp.
			then().
			contentType(ContentType.JSON).	
			extract().path ("weather[0].description");
	
	System.out.println(actualweatherreport);
	
	String expectedweatherReport = "overcast clouds";
	
	if(expectedweatherReport.equalsIgnoreCase(actualweatherreport)){
					
		System.out.println("testcase pass");
	}	
	else
		System.out.println("testcase fail");
	//System.out.println("wheather report :"+ weatherReport);
  }
}// end of class

