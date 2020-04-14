package com.sulistionoadi.ngoprek.common.pss.helper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sulistionoadi.ngoprek.common.pss.constant.PssConstant;
import com.sulistionoadi.ngoprek.common.pss.dto.PssFilter;

public class PssHelper {

	public static Map<String, Object> generateCountPssParameter(PssFilter filter) {
		validateFilterObject(filter);
		
		Map<String, Object> param = new HashMap<String, Object>();
		if(hasFilterSearchValue(filter)) {
			param.put("filter", "%" + filter.getSearch().get(PssConstant.PSS_SEARCH_VAL) + "%");			
		}
		
		return param;
	}
	
	public static Map<String, Object> generatePssParameter(PssFilter filter){
		validateFilterObject(filter);
		validateFilterStart(filter);
		validateFilterLength(filter);
		
		Map<String, Object> param = new HashMap<String, Object>();
		if(hasFilterSearchValue(filter)) {
			param.put("filter", "%" + filter.getSearch().get(PssConstant.PSS_SEARCH_VAL) + "%");			
		}

		param.put("start_row", filter.getStart() + 1);
		param.put("end_row", filter.getStart() + filter.getLength());
		
		return param;
	}
	
	public static String getOrderBy(PssFilter filter, String defaultOrderBy, String...dataColumns) {
		validateFilterObject(filter);
		
		if(defaultOrderBy == null || defaultOrderBy.replaceAll("\\s+","").length() < 1) {
			throw new IllegalArgumentException("Required parameter default order-by");
		}
		
		String orderBy = defaultOrderBy;
		if(dataColumns.length > 0) {
			validateFilterOrder(filter.getOrder());
			
			String colidx = filter.getOrder().get(0).get(PssConstant.PSS_ORDER_COLUMN);
			String dir = filter.getOrder().get(0).get(PssConstant.PSS_ORDER_DIRECTION);

			try {
				orderBy = dataColumns[Integer.parseInt(colidx)];
				orderBy = orderBy.concat(dir);				
			} catch(ArrayIndexOutOfBoundsException ex) {
				throw new IllegalArgumentException("Invalid providing data columns, cannot get data columns at index " + colidx);
			}
		}
		
		return orderBy.toUpperCase();
	}
	
	private static void validateFilterObject(PssFilter filter) {
		if(filter==null) {
			throw new IllegalArgumentException("Parameter filter is null");
		}
	}
	
	private static void validateFilterStart(PssFilter filter) {
		if(filter.getStart()==null) {
			filter.setStart(0);
		}
	}
	
	private static void validateFilterLength(PssFilter filter) {
		if(filter.getLength()==null || filter.getLength() < 1) {
			throw new IllegalArgumentException("Minimum value of filter.length is 1");
		}
	}
	
	private static void validateFilterOrder(List<HashMap<String, String>> listOrder) {
		int orderAt = 0;
		for (HashMap<String, String> order : listOrder) {
			//Validate Order Column Index of Datatables
			if(!order.containsKey(PssConstant.PSS_ORDER_COLUMN)) {
				throw new IllegalArgumentException("filter.order["+String.valueOf(orderAt)+"] don't have property column");
			}
			
			String colidx = order.get(PssConstant.PSS_ORDER_COLUMN);
			if(colidx == null || colidx.replaceAll("\\s+","").length() < 1) {
				throw new IllegalArgumentException("filter.order["+String.valueOf(orderAt)+"].column is null");
			}
			
			try {
				Integer.parseInt(colidx);
			} catch(Exception ex) {
				throw new IllegalArgumentException("Value filter.order["+String.valueOf(orderAt)+"].column must be number");
			}
			
			//Validate Order Direction
			if(!order.containsKey(PssConstant.PSS_ORDER_DIRECTION)) {
				throw new IllegalArgumentException("filter.order["+String.valueOf(orderAt)+"] don't have property dir");
			}
			String dir = order.get(PssConstant.PSS_ORDER_DIRECTION);
			if(dir == null || dir.replaceAll("\\s+","").length() < 1) {
				throw new IllegalArgumentException("filter.order["+String.valueOf(orderAt)+"].dir is null");
			}
			
			if(!Arrays.asList("ASC", "DESC").contains(dir.toUpperCase())) {
				throw new IllegalArgumentException("Allowable value for filter.order["+String.valueOf(orderAt)+"].dir is ASC or DESC");
			}
			orderAt++;
		}
	}
	
	private static boolean hasFilterSearchValue(PssFilter filter) {
		HashMap<String, String> search = filter.getSearch();
		
		if(search == null) return false;
		if(!search.containsKey(PssConstant.PSS_SEARCH_VAL)) return false;
		
		String searchVal = search.get(PssConstant.PSS_SEARCH_VAL);
		int length = searchVal.replaceAll("\\s+","").length();
		return length > 0;
	}
}
