package com.qingzu.applet.result;

public class ResultUtil {

	public static Result success(Object object){
		Result result = new Result();
		result.setCode(ResultEnum.SUCCESS.getCode());
		result.setStatus(ResultEnum.SUCCESS.getStatus());
		result.setData(object);
		return result;
	}

	public static Result success(){
		return success(null);
	}

	public static Result error(Object object){
		Result result = new Result();
		result.setCode(ResultEnum.FAIL.getCode());
		result.setStatus(ResultEnum.FAIL.getStatus());
		result.setData(object);
		return result;
	}

	public static Result empty(Object object){
		Result result = new Result();
		result.setCode(ResultEnum.EMPTY.getCode());
		result.setStatus(ResultEnum.FAIL.getStatus());
		result.setData(object);
		return result;
	}

	public static Result illegality(Object object){
		Result result = new Result();
		result.setCode(ResultEnum.ILLEGALITY.getCode());
		result.setStatus(ResultEnum.FAIL.getStatus());
		result.setData(object);
		return result;
	}
}
