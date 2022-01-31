package com.fiveand.qna.vo;

public class CommentVO {
	private int cNo;
	private String id;
	private String comContent;
	private String comDate;
	private int bNo;
	
	
	public CommentVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CommentVO(int cNo, String id, String comContent, String comDate, int bNo) {
		super();
		this.cNo = cNo;
		this.id = id;
		this.comContent = comContent;
		this.comDate = comDate;
		this.bNo = bNo;
	}
	
	
	public CommentVO(String id, String comContent, String comDate, int bNo) {
		super();
		this.id = id;
		this.comContent = comContent;
		this.comDate = comDate;
		this.bNo = bNo;
	}

	public int getcNo() {
		return cNo;
	}
	public void setcNo(int cNo) {
		this.cNo = cNo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getComContent() {
		return comContent;
	}
	public void setComContent(String comContent) {
		this.comContent = comContent;
	}
	public String getComDate() {
		return comDate;
	}
	public void setComDate(String comDate) {
		this.comDate = comDate;
	}
	public int getbNo() {
		return bNo;
	}
	public void setbNo(int bNo) {
		this.bNo = bNo;
	}
	@Override
	public String toString() {
		return "CommentVO [cNo=" + cNo + ", id=" + id + ", comContent=" + comContent + ", comDate=" + comDate + ", bNo="
				+ bNo + "]";
	}
	
}
