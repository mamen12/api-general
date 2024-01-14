package com.micro.general.constant;

public enum ApiResponse {

	// custom API response 
	
	SUCCESS("0000", "Sukses", "Success"),
	FAILED("0101", "Gagal", "Failed"),
	DATA_NOT_FOUND("0104", "Data Tidak Ditemukan", "Data Not Found");
	
	private String code;
	private String id;
	private String en;
	
	private ApiResponse(String code, String id, String en) {
		this.code = code;
		this.id = id;
		this.en = en;
	}

	public String getCode() {
		return code;
	}

	public String getId() {
		return id;
	}

	public String getEn() {
		return en;
	}
	
	
	
	
}
