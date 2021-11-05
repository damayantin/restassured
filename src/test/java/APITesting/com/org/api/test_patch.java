/**
 * 
 */
package APITesting.com.org.api;

/**
 * @author nelakurti.1
 *
 */
import static io.restassured.RestAssured.given;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class test_patch{

	@Test
	public void test2() {

		JSONObject request = new JSONObject();
		request.put("name", "chaya");
		request.put("job", "BAA");

		System.out.println(request);
		System.out.println(request.toString());

		given().
		body(request.toJSONString()).
		when().
		patch("https://reqres.in/api/users").
		then().statusCode(200);

	}

}