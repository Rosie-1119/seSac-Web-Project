package com.fiveand.qna.vo;

public class QnAVO {

	private int no;
	private String id;
	private int pdNo;
	private String title;
	private String content;
	private String regDate;
	private int groupNo;
	private int groupStep;
	private int indent;

	public QnAVO() {

	}

	public QnAVO(int no, String id, int pdNo, String title, String content, String regDate, int groupNo, int groupStep,
			int indent) {
		super();
		this.no = no;
		this.id = id;
		this.pdNo = pdNo;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.groupNo = groupNo;
		this.groupStep = groupStep;
		this.indent = indent;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
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

	public int getGroupNo() {
		return groupNo;
	}

	public void setGroupNo(int groupNo) {
		this.groupNo = groupNo;
	}

	public int getGroupStep() {
		return groupStep;
	}

	public void setGroupStep(int groupStep) {
		this.groupStep = groupStep;
	}

	public int getIndent() {
		return indent;
	}

	public void setIndent(int indent) {
		this.indent = indent;
	}

	@Override
	public String toString() {
		return "QnAVO [no=" + no + ", id=" + id + ", pdNo=" + pdNo + ", title=" + title + ", content=" + content
				+ ", regDate=" + regDate + ", groupNo=" + groupNo + ", groupStep=" + groupStep + ", indent=" + indent
				+ "]";
	}

}
