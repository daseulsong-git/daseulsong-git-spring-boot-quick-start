package com.multicampus.biz.sale;

import java.util.List;

import com.multicampus.biz.common.SearchVO;

public interface SaleService {
	
	public void updateTranStatusCode(SaleVO saleVO) throws Exception;
	
	public List<SaleVO> getSaleList(SearchVO searchVO) throws Exception;	
	
	public SaleVO getSale(String prodNo) throws Exception;	
}
