package com.sunxu.utils;

public class ApiResult {

	private int code;

	private String message;

	private Object data;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public ApiResult(int code, String message, Object data) {
		super();
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public ApiResult(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public ApiResult(int code, Object object) {
		super();
		this.code = code;
		this.message = "操作成功";
		this.data = object;
	}

	public static ApiResult success(String message, Object object) {
		ApiResult apiResult = new ApiResult(200, message, object);
		return apiResult;
	}

	public static ApiResult success() {
		ApiResult apiResult = new ApiResult(200, "操作成功");
		return apiResult;
	}

	public static ApiResult success(Object object) {
		ApiResult apiResult = new ApiResult(200, object);
		return apiResult;
	}

	public static ApiResult fail(String message) {
		ApiResult apiResult = new ApiResult(500, message);
		return apiResult;
	}

	public static ApiResult fail() {
		ApiResult apiResult = new ApiResult(500, "操作失败");
		return apiResult;
	}
}
