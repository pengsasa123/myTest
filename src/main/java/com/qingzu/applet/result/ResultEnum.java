package com.qingzu.applet.result;

public enum ResultEnum {


	SUCCESS(200,"OK"),
	FAIL(404,"fail"),
	EMPTY(501,"fail"),
	ILLEGALITY(502,"fail"),
	;
	private Integer code;
	private String status;
	
	ResultEnum(Integer code,String status) {
		this.code = code;
		this.status=status;
	}

	public Integer getCode() {
		return code;
	}

	public String getStatus() {
		return status;
	}
}
