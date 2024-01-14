package com.micro.general.beans;


public class Request<T> {
	
	private String isAdmin;
	
	private RequsetHeader rqHeader;
	
	private T rqPayload;

	public String getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}

	public RequsetHeader getRqHeader() {
		return rqHeader;
	}

	public void setRqHeader(RequsetHeader rqHeader) {
		this.rqHeader = rqHeader;
	}

	public T getRqPayload() {
		return rqPayload;
	}

	public void setRqPayload(T rqPayload) {
		this.rqPayload = rqPayload;
	}
}
