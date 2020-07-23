package com.rest.igtest.pojo;

public class ApiTest {
	private int status;
	private EmployeeData[] employeeData;
	private String message;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public EmployeeData[] getEmployeeData() {
		return employeeData;
	}

	public void setEmployeeData(EmployeeData[] employeeData) {
		this.employeeData = employeeData;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
