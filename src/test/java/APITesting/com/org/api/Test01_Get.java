/**
 * thsi added comment
 */
package APITesting.com.org.api;


import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

/**
 * @author nelakurti.1
 *
 */
public class Test01_Get {

	@Test
	public void test() {

		Response response = RestAssured.get("https://reqres.in/api/users?page=1");
		System.out.println(response.statusCode());
		System.out.println(response.asString());
		System.out.println(response.getBody().asString());
		System.out.println(response.statusLine());

		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);

	}

	@Test
	public void test1() {

		given().get("https://reqres.in/api/users?page=1").then().statusCode(200).body("data.email[0]", equalTo("george.bluth@reqres.in"));

	}
	
	@Test
	public void test2() {

		given().get("https://reqres.in/api/users?page=30").then().
		statusCode(200).
		body("page",equalTo(30)).
		//body("data.id[1]", equalTo(8)).
		//body("data.first_name", hasItems("Michael","Lindsay")).
		log().all();
	}

}
