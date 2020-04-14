package com.sulistionoadi.ngoprek.common.pss.dto;

import java.util.HashMap;
import java.util.List;

public class PssFilter {
	
	private Integer draw;
	private List<HashMap<String, String>> columns;
    private List<HashMap<String, String>> order;
    private Integer start;
    private Integer length;
    private HashMap<String, String> search;
    
	public Integer getDraw() {
		return draw;
	}
	public void setDraw(Integer draw) {
		this.draw = draw;
	}
	
	public List<HashMap<String, String>> getColumns() {
		return columns;
	}
	public void setColumns(List<HashMap<String, String>> columns) {
		this.columns = columns;
	}
	
	public List<HashMap<String, String>> getOrder() {
		return order;
	}
	public void setOrder(List<HashMap<String, String>> order) {
		this.order = order;
	}
	
	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	
	public Integer getLength() {
		return length;
	}
	public void setLength(Integer length) {
		this.length = length;
	}
	
	public HashMap<String, String> getSearch() {
		return search;
	}
	public void setSearch(HashMap<String, String> search) {
		this.search = search;
	}
	@Override
	public String toString() {
		return "PssFilter [draw=" + draw + ", columns=" + columns + ", order=" + order + ", start=" + start
				+ ", length=" + length + ", search=" + search + "]";
	}

}
