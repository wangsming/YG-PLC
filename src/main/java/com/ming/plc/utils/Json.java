package com.ming.plc.utils;


/**
 * @author 王思明
 * @param <>
 * @version 1.0
 * 
 * Description:JSON模型,用户后台向前台返回的JSON对象
 * Create by:wangsimign
 */
public class Json implements java.io.Serializable {


	private static final long serialVersionUID = -1589008548679433356L;

	private boolean success = false;

	private String msg = "";

	private Object obj = null;

	
	
	public Json() {
		super();
	}
	
	

	public Json(boolean success, String msg) {
		super();
		this.success = success;
		this.msg = msg;
	}



	public Json(boolean success, String msg, Object obj) {
		super();
		this.success = success;
		this.msg = msg;
		this.obj = obj;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

}
