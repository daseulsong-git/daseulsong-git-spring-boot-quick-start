package com.multicampus.biz.common;

import lombok.Data;

@Data
public class SearchVO {	
	private String searchCondition="";	
	private String searchKeyword="";
	private int pageIndex = 1;
	private String searchUseYn;
	private String searchTranStatusCode;
	private String searchSellerId;
	private String searchAsYn;
	private String searchBuyerId;	
}
