package com.demo.domain;

public class ProductVO {
	
	private Long pro_code;
	private String pro_name;
	private String pro_desc;
	
	public Long getPro_code() {
		return pro_code;
	}
	public void setPro_code(Long pro_code) {
		this.pro_code = pro_code;
	}
	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	public String getPro_desc() {
		return pro_desc;
	}
	public void setPro_desc(String pro_desc) {
		this.pro_desc = pro_desc;
	}
	
	@Override
	public String toString() {
		return "ProductVO [pro_code=" + pro_code + ", pro_name=" + pro_name + ", pro_desc=" + pro_desc + "]";
	}

}
