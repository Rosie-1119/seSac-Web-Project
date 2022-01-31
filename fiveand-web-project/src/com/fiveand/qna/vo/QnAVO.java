package com.fiveand.qna.vo;

public class QnAVO {

	private int bNo;
	private String id;
	private int pdNo;
	private String title;
	private String content;
	private String regDate;
	private int groupId; 
	private int pos; 
	private int hit; 	
	private int depth; 

	public QnAVO() {

	}

	
	public QnAVO(int bNo, String id, int pdNo, String title, String content, String regDate, int groupId, int pos,
			int hit, int depth) {
		super();
		this.bNo = bNo;
		this.id = id;
		this.pdNo = pdNo;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.groupId = groupId;
		this.pos = pos;
		this.hit = hit;
		this.depth = depth;
	}

	
	//전체 리스트 조회 생성자
	public QnAVO(int bNo, String title, String id, String regDate, int depth) {
		super();
		this.bNo = bNo;
		this.title = title;
		this.id = id;
		this.regDate = regDate;
		this.depth = depth;
	}


	

	//디테일 조회 생성자
	public QnAVO(int bNo, int pdNo, String title, String id, String regDate, String content, int groupId, int depth, int pos) {
		super();
		this.bNo = bNo;
		this.id = id;
		this.pdNo = pdNo;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.groupId = groupId;
		this.pos = pos;
		this.depth = depth;
	}


	public int getbNo() {
		return bNo;
	}


	public void setbNo(int bNo) {
		this.bNo = bNo;
	}


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


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getRegDate() {
		return regDate;
	}


	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}


	public int getGroupId() {
		return groupId;
	}


	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}


	public int getPos() {
		return pos;
	}


	public void setPos(int pos) {
		this.pos = pos;
	}


	public int getHit() {
		return hit;
	}


	public void setHit(int hit) {
		this.hit = hit;
	}


	public int getDepth() {
		return depth;
	}


	public void setDepth(int depth) {
		this.depth = depth;
	}


	
	@Override
	public String toString() {
		return "QnAVO [bNo=" + bNo + ", title=" + title + ", id=" + id + ", regDate=" + regDate + "]";
	}



}
