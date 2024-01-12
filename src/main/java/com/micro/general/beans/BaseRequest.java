package com.micro.general.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BaseRequest {
	
	@JsonProperty(value = "page")
	private Integer page;
	
	@JsonProperty(value = "size")
	private Integer size;

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}
	
	
	
}
