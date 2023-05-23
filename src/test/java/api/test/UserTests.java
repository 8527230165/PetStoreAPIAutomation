package api.test;

import java.util.Hashtable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

@Listeners(api.utilities.ExtentReportManager.class)
public class UserTests {

	Faker faker;
	User userPayload;
	public Logger logger;

	@BeforeClass
	public void setUpData() {
		/*
		 * faker = new Faker(); userPayload = new User();
		 * 
		 * userPayload.setId(faker.idNumber().hashCode());
		 * userPayload.setUsername(faker.name().username());
		 * userPayload.setFirstName(faker.name().firstName());
		 * userPayload.setLastName(faker.name().lastName());
		 * userPayload.setEmail(faker.internet().safeEmailAddress());
		 * userPayload.setPassword(faker.internet().password(8, 10));
		 * userPayload.setPhone(faker.phoneNumber().cellPhone());
		 */
		logger=LogManager.getLogger(this.getClass());
	}

	@Test(priority = 1, testName = "Create User", dataProvider = "all-test-data", dataProviderClass = DataProviders.class)
	public void testPostUser(Hashtable<String, String> data) {
		logger.info("Data is Intitliasing");
		userPayload = new User();
		userPayload.setId(Integer.parseInt(data.get("UserId")));
		userPayload.setUsername(data.get("UserName"));
		userPayload.setFirstName(data.get("FirstName"));
		userPayload.setLastName(data.get("LastName"));
		userPayload.setEmail(data.get("Email"));
		userPayload.setPassword(data.get("Password"));
		userPayload.setPhone(data.get("PhoneNumber"));
		Response response = UserEndPoints.createUser(userPayload);
		response.then().log().all();
		AssertJUnit.assertEquals(response.getStatusCode(), 200);
		logger.info(" ************  User is Created **********");
	}

	@Test(priority = 2, testName = "Get User by Name", dataProvider = "all-username-data", dataProviderClass = DataProviders.class)
	public void testGetUserByName(Hashtable<String, String> data) {
		logger.info("User is reading");
		Response response = UserEndPoints.readUser(data.get("UserName"));
		response.then().log().all();

		AssertJUnit.assertEquals(response.getStatusCode(), 200);
		logger.info(" ************  User Info is Displayed **********");

	}

	@Test(priority = 3, enabled = false)
	public void testUpdateUserByName() {
		userPayload.setPassword(faker.internet().password(8, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		Response response = UserEndPoints.updateUser(this.userPayload.getUsername(), userPayload);
		response.then().log().body().statusCode(200);
		response.then().log().all();

		Response responseAfterUpdate = UserEndPoints.readUser(this.userPayload.getUsername());
		responseAfterUpdate.then().log().all();

	}

	@Test(priority = 4, enabled = false)
	public void testDeleteUserByName() {

		Response response = UserEndPoints.deleteUser(this.userPayload.getUsername());
		response.then().log().body().statusCode(200);
		response.then().log().all();
	}
}
