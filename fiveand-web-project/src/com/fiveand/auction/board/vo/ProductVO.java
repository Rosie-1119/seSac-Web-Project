package com.fiveand.auction.board.vo;

public class ProductVO {
	
	private int pdNo; // 제품 번호
	private String id; // 등록자 아이디
	private String pdName; // 제품 이름
	private int hopePrice; // 희망가
	private int startPrice; // 시작가
	private String regDate; // 등록일
	private String dueDate; // 종료일
	private String pdSimpleInfo; // 간단 제품 정보
	private String pdInfo; // 제품 정보
	private int cNo; // 카테고리 넘버
	private String cName; // 카테고리 이름
	private int viewCnt; // 조회수
	private int likeCnt; // 좋아요수
	private int sugCnt; // 제시받은 수
	

	// 생성자
	public ProductVO() {

	}
	
	public ProductVO(int pdNo, String pdName, int startPrice, String dueDate, int cNo) {
		super();
		this.pdName = pdName;
		this.startPrice = startPrice;
		this.dueDate = dueDate;
		this.cNo = cNo;
	}
	
	public ProductVO(int pdNo, String id, String pdName, int hopePrice, int startPrice, String regDate, String dueDate,
			String pdSimpleInfo, String pdInfo, int cNo, String cName, int viewCnt, int likeCnt, int sugCnt) {
		super();
		this.pdNo = pdNo;
		this.id = id;
		this.pdName = pdName;
		this.hopePrice = hopePrice;
		this.startPrice = startPrice;
		this.regDate = regDate;
		this.dueDate = dueDate;
		this.pdSimpleInfo = pdSimpleInfo;
		this.pdInfo = pdInfo;
		this.cNo = cNo;
		this.cName = cName;
		this.viewCnt = viewCnt;
		this.likeCnt = likeCnt;
		this.sugCnt = sugCnt;
	}

	// getter, setter
	public int getPdNo() {
		return pdNo;
	}


	public void setPdNo(int pdNo) {
		this.pdNo = pdNo;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPdName() {
		return pdName;
	}


	public void setPdName(String pdName) {
		this.pdName = pdName;
	}


	public int getHopePrice() {
		return hopePrice;
	}


	public void setHopePrice(int hopePrice) {
		this.hopePrice = hopePrice;
	}


	public int getStartPrice() {
		return startPrice;
	}


	public void setStartPrice(int startPrice) {
		this.startPrice = startPrice;
	}


	public String getRegDate() {
		return regDate;
	}


	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}


	public String getDueDate() {
		return dueDate;
	}


	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}


	public String getPdSimpleInfo() {
		return pdSimpleInfo;
	}


	public void setPdSimpleInfo(String pdSimpleInfo) {
		this.pdSimpleInfo = pdSimpleInfo;
	}


	public String getPdInfo() {
		return pdInfo;
	}


	public void setPdInfo(String pdInfo) {
		this.pdInfo = pdInfo;
	}


	public int getcNo() {
		return cNo;
	}

	public void setcNo(int cNo) {
		this.cNo = cNo;
	}


	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public int getViewCnt() {
		return viewCnt;
	}


	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}


	public int getLikeCnt() {
		return likeCnt;
	}


	public void setLikeCnt(int likeCnt) {
		this.likeCnt = likeCnt;
	}


	public int getSugCnt() {
		return sugCnt;
	}


	public void setSugCnt(int sugCnt) {
		this.sugCnt = sugCnt;
	}

	
	// toString
	@Override
	public String toString() {
		return "ProductVO [pdNo=" + pdNo + ", id=" + id + ", pdName=" + pdName + ", hopePrice=" + hopePrice
				+ ", startPrice=" + startPrice + ", regDate=" + regDate + ", dueDate=" + dueDate + ", pdSimpleInfo="
				+ pdSimpleInfo + ", pdInfo=" + pdInfo + ", cNo=" + cNo + ", cName=" + cName + ", viewCnt=" + viewCnt
				+ ", likeCnt=" + likeCnt + ", sugCnt=" + sugCnt + "]";
	}
	
}
