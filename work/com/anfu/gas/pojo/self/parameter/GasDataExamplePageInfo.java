package com.anfu.gas.pojo.self.parameter;

import com.anfu.gas.pojo.GasDataExample;

public class GasDataExamplePageInfo extends GasDataExample{
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
