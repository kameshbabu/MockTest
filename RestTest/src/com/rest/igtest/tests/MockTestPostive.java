package com.rest.igtest.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertNotNull;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.rest.base.BaseSetup;
import com.rest.igtest.pojo.ApiTest;
import com.rest.igtest.pojo.EmployeeData;
import com.rest.lib.custommethods.RestMethods;
import com.rest.lib.custommethods.StatusCodes;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class MockTestPostive extends BaseSetup {
	private static final Logger log = LogManager.getLogger(MockTestPostive.class);

	@Test
	public void TestMock_Response_Status200() {
		Response response = RestMethods.getMockTest();
		log.info("Mock response: " + response);

		assertThat("Status code is success", response.getStatusCode(), equalTo(StatusCodes.NO_CONTENT_204));
	}

	@Test
	public void TestMock_ResponseHeader_IsJson() {
		Response response = RestMethods.getMockTest();
		log.info("Mock Response: " + response);

		assertThat("contenttype : ", response.getContentType().toString().contains(ContentType.JSON.toString()),
				is(true));
	}

	@Test
	public void TestMock_ResponseBody_IsAgeCorrect() {
		ApiTest response = RestMethods.getMockTest().as(ApiTest.class);
		log.info("Mock Response: " + response);
		EmployeeData[] EmployeeData = response.getEmployeeData();
		assertNotNull(EmployeeData);

		assertThat("check age: ", EmployeeData[0].getAge(), is(equalTo(25)));
	}

	@Test
	public void TestMock_ResponseBody_IsRoleCorrect() {
		ApiTest response = RestMethods.getMockTest().as(ApiTest.class);
		log.info("Mock Response: " + response);
		EmployeeData[] EmployeeData = response.getEmployeeData();
		assertNotNull(EmployeeData);

		assertThat("check role: ", EmployeeData[0].getRole(), is(equalTo("QA Automation Developer")));
	}

	@Test
	public void TestMock_ResponseBody_IsCompanyCorrect() {
		ApiTest response = RestMethods.getMockTest().as(ApiTest.class);
		log.info("Mock Response: " + response);
		EmployeeData[] EmployeeData = response.getEmployeeData();
		assertNotNull(EmployeeData);

		assertThat("check role: ", EmployeeData[0].getRole(), is(equalTo("QA Automation Developer")));
	}
}