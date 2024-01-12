package com.micro.general.beans;

public class BaseReponse<T>{
	private String status;
	private String message;
	private String message_en;
	private T data;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMessage_en() {
		return message_en;
	}
	public void setMessage_en(String message_en) {
		this.message_en = message_en;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}

	
	
	
}
