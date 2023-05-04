package com.javalab.dto;

public class BoardModel {

	private int no = 0;
	private String subject = null;
	private String writer = null;
	private String contents = null;
	private int hit = 0;
	private String regdate; // 날짜

	// 페이징 field
	private String pageNum = "1"; // 페이지 번호
	private Integer listCount = 10; // 1 페이지당 보여줄 게시물 수
	private Integer pagePerBlock = 10; // 한 번에 보여질 페이지 번호 갯수

	public BoardModel() {
		super();
	}

	public BoardModel(int no, String subject, String writer, String contents, int hit, String regdate, String pageNum,
			Integer listCount, Integer pagePerBlock) {
		super();
		this.no = no;
		this.subject = subject;
		this.writer = writer;
		this.contents = contents;
		this.hit = hit;
		this.regdate = regdate;
		this.pageNum = pageNum;
		this.listCount = listCount;
		this.pagePerBlock = pagePerBlock;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getPageNum() {
		return pageNum;
	}

	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getListCount() {
		return listCount;
	}

	public void setListCount(Integer listCount) {
		this.listCount = listCount;
	}

	public Integer getPagePerBlock() {
		return pagePerBlock;
	}

	public void setPagePerBlock(Integer pagePerBlock) {
		this.pagePerBlock = pagePerBlock;
	}

}
