package com.micro.general.beans;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.micro.general.constant.ApiResponse;

@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({"code", "message", "message_en", "data"})
public class Response<T>{
	
	@JsonProperty(value = "code")
	private String status;
	
	@JsonProperty(value = "message")
	private String message;
	
	@JsonProperty(value = "message_en")
	private String messageEn;
	
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
	
	public String getMessageEn() {
		return messageEn;
	}
	public void setMessageEn(String messageEn) {
		this.messageEn = messageEn;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	public void setStatusResponse(ApiResponse rs) {
		this.status = rs.getCode();
		this.messageEn = rs.getEn();
		this.message = rs.getId();
	}
	
	
	
}
