package com.rest.lib.custommethods;

/**
 * StatusCodes class contains static final variables of all http statuc codes.
 * 
 * @version 1.0.1-Beta*
 * 
 * @author kamesh babu
 */
public class StatusCodes {
	/* Success status code */
	public static final int OK_200 = 200;
	public static final int ACCEPTED_202 = 202;
	public static final int CREATED_201 = 201;
	public static final int NO_CONTENT_204 = 204;

	/* Redirection 300 */
	public static final int NOT_MODIFIED_304 = 304;

	/* Redirection 400 */
	public static final int BAD_REQUEST_400 = 400;
	public static final int UNAUTHORISED_401 = 401;
	public static final int NOT_FOUND_404 = 404;
	public static final int CONFLICT_409 = 409;
	public static final int UNSUPPORTED_MEDIA_TYPE_415 = 415;

	/* Server Error */
	public static final int INTERNAL_SERVER_ERROR_500 = 500;

	public static boolean checkResponseStatusCode(int statusCode, int responseStatusCode) {
		return (statusCode == responseStatusCode);
	}
}
