package com.rest.base;

import java.io.FileNotFoundException;

import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeSuite;

import com.rest.lib.custommethods.LoadConfigProperties;
import com.rest.lib.logger.LogSetup;

import io.restassured.RestAssured;

/**
 * 
 * @version 1.0.1-Beta
 * 
 * @author kamesh babu
 * 
 */
public class BaseSetup {
	private static final Logger log = LogManager.getLogger(BaseSetup.class);
	public static LoadConfigProperties prop;

	public void baseSetupInit() {
		LogSetup.init();
		prop = getPropertiesObject();
		restPreconditions();
	}

	/**
	 * Initializes log4j, creates LoadConfigProperties object and deviceDetails POJO
	 * object, executes restPreconditions() and setDeviceDetails(prop,
	 * firmwareVersion);
	 * 
	 */
	@BeforeSuite
	public void setup() throws FileNotFoundException {
		log.info("Root logger Intialization");
		baseSetupInit();
	}

	public static LoadConfigProperties getPropertiesObject() {
		return ConfigFactory.create(LoadConfigProperties.class);
	}

	/**
	 * restPreconditions() initializes rest assured with endpoint of where web
	 * service resides, turns off SSL validations *
	 */
	public void restPreconditions() {
		RestAssured.baseURI = prop.getBaseURI();
		RestAssured.useRelaxedHTTPSValidation();
		RestAssured.config().getSSLConfig().with().keyStore("classpath:keystore.p12", "password");
	}
}