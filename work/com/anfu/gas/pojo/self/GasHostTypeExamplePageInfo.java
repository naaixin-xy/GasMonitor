package com.anfu.gas.pojo.self;

import com.anfu.gas.pojo.GasHostTypeExample;

public class GasHostTypeExamplePageInfo extends  GasHostTypeExample{
	int pageStart;
	int pageSize;
	public int getPageStart() {
		return pageStart;
	}
	public void setPageStart(int pageStart) {
		this.pageStart = pageStart;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}
