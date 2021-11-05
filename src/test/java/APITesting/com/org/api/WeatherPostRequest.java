package APITesting.com.org.api;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class WeatherPostRequest {

    @Test
	public void Test_01() {

		Response resp = given().
				get("http://api.openweathermap.org/data/2.5/weather?id=2172797&appid=29519b0be1fec36be8509ee6b070a576");
		System.out.println("resp: "+resp);
		String reportbyID= resp.
				then().
				contentType(ContentType.JSON).
				extract().
				path("weather[0].description");
		System.out.println("weather[0].description by id: "+reportbyID);
		String lon=String.valueOf(resp.
				then().
				contentType(ContentType.JSON).
				extract().
				path("coord.lon"));
		System.out.println("lon is: "+lon);
		String lat=String.valueOf(resp.
				then().
				contentType(ContentType.JSON).
				extract().
				path("coord.lat"));
		System.out.println("latitude is: "+lat);
		System.out.println("get URL: "+"http://api.openweathermap.org/data/2.5/weather?lat="+lat+"&lon="+lon+"&appid=29519b0be1fec36be8509ee6b070a576");
		
	String reportbycoordinates= given().
				get("http://api.openweathermap.org/data/2.5/weather?lat="+lat+"&lon="+lon+"&appid=29519b0be1fec36be8509ee6b070a576").
				
		        then().
		        contentType(ContentType.JSON).
		    	extract(). 
		    	path("weather[0].description");
		    	
		System.out.println("reportbycoordinates: "+reportbycoordinates);


		}

		
  
    }

