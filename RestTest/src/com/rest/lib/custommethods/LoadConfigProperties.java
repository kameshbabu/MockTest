package com.rest.lib.custommethods;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

/**
 * LoadConfigProperties extends config interface where it belong ownerAPI
 * library. Class responsible reading config.properties in mentioned sources
 * path.
 * 
 * "@Key" should match with config.properties key name to read properly.
 * 
 * @author kamesh babu
 */

@Sources({ "file:resource/propertyfiles/config.properties" })
public interface LoadConfigProperties extends Config {

	@Key("baseURI")
	public String getBaseURI();

	@Key("deviceUser")
	public String getDeviceUser();

	@Key("devicePassword")
	public String getDevicePassword();

	@Key("proxy")
	public String getProxy();

	@Key("version")
	public String getVersion();
}