package com.fiveand.auction.heart.vo;

public class HeartVO {
	private String id;
	private int pdNo;
	
	// 생성자
	public HeartVO() {
		super();
	}

	public HeartVO(String id, int pdNo) {
		super();
		this.id = id;
		this.pdNo = pdNo;
	}

	// getter, setter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getPdNo() {
		return pdNo;
	}

	public void setPdNo(int pdNo) {
		this.pdNo = pdNo;
	}

	// toString
	@Override
	public String toString() {
		return "HeartVO [id=" + id + ", pdNo=" + pdNo + "]";
	}
	
}
