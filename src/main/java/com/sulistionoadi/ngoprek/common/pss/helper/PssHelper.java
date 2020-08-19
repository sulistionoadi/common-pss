package com.sulistionoadi.ngoprek.common.pss.helper;

import java.util.Arrays;
import java.util.HashMap;

import com.sulistionoadi.ngoprek.common.pss.constant.PssConstant;
import com.sulistionoadi.ngoprek.common.pss.dto.PssFilter;

public class PssHelper {

	public static PssFilter buildDefaultFilter() {
		PssFilter filter = new PssFilter();
		filter.setLength(10);
		filter.setStart(0);
		
		HashMap<String, String> order = new HashMap<>();
		order.put(PssConstant.PSS_ORDER_COLUMN, "0");
		order.put(PssConstant.PSS_ORDER_DIRECTION, "asc");
		filter.setOrder(Arrays.asList(order));
		
		HashMap<String, String> search = new HashMap<>();
		search.put(PssConstant.PSS_SEARCH_VAL, null);
		search.put(PssConstant.PSS_SEARCH_REG, "false");
		filter.setSearch(search);
		return filter;
	}
	
	public static PssFilter buildSelect2Filter(String q, Integer page, Integer sortIdx, String sortDir) {
		PssFilter filter = new PssFilter();
		filter.setLength(10);
		filter.setStart(filter.getLength() * (page - 1));
		
		HashMap<String, String> order = new HashMap<>();
		order.put(PssConstant.PSS_ORDER_COLUMN, sortIdx.toString());
		order.put(PssConstant.PSS_ORDER_DIRECTION, sortDir);
		filter.setOrder(Arrays.asList(order));
		
		HashMap<String, String> search = new HashMap<>();
		search.put(PssConstant.PSS_SEARCH_VAL, q);
		search.put(PssConstant.PSS_SEARCH_REG, "false");
		filter.setSearch(search);
		return filter;
	}
	
}
