package com.zhongzhi.location.pojo;

public class MemberQueryParam extends Member{
	int pageSize;
	int pageStart;
	int pageNum;
	//int ooo;
	//Member member;
	//Member member;
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageStart() {
		return pageStart;
	}
	public void setPageStart(int pageStart) {
		this.pageStart = pageStart;
	}
	@Override
	public String toString() {
		return "MemberQueryParam [pageSize=" + pageSize + ", pageNum=" + pageNum + "]";
	}
	
}
