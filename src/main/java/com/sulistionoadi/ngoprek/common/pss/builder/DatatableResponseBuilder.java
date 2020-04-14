package com.sulistionoadi.ngoprek.common.pss.builder;

import com.sulistionoadi.ngoprek.common.pss.dto.DatatableResponse;

public class DatatableResponseBuilder {

	private String code;
	private String message;
	private Integer draw;
	private Long recordsTotal;
	private Long recordsFiltered;
	private String search;
	private Object data;

	public static DatatableResponseBuilder builder() {
		return new DatatableResponseBuilder();
	}

	public DatatableResponseBuilder setCode(String code) {
		this.code = code;
		return this;
	}

	public DatatableResponseBuilder setMessage(String message) {
		this.message = message;
		return this;
	}

	public DatatableResponseBuilder setDraw(Integer draw) {
		this.draw = draw;
		return this;
	}

	public DatatableResponseBuilder setRecordsTotal(Long recordsTotal) {
		this.recordsTotal = recordsTotal;
		return this;
	}

	public DatatableResponseBuilder setRecordsFiltered(Long recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
		return this;
	}

	public DatatableResponseBuilder setSearch(String search) {
		this.search = search;
		return this;
	}

	public DatatableResponseBuilder setData(Object data) {
		this.data = data;
		return this;
	}

	public DatatableResponse build() {
		return new DatatableResponse(this.code, this.message, this.draw, this.recordsTotal, this.recordsFiltered,
				this.search, this.data);
	}

}
