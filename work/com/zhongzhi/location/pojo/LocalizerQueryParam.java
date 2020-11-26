package com.zhongzhi.location.pojo;

public class LocalizerQueryParam extends Localizer{
	int pageSize;
	int pageStart;
	int pageNum;
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
		return "LocalizerQueryParam [pageSize=" + pageSize + ", pageStart=" + pageStart + ", pageNum=" + pageNum + "]";
	}

	
}
