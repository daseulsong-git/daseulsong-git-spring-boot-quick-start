package com.multicampus.biz.purchase;

import java.util.List;

import com.multicampus.biz.common.SearchVO;

public interface PurchaseService {
	
	public int countPurchaseListByDeliveryCompany(String dlvyCompNo) throws Exception;
	
	public String addPurchase(PurchaseVO purchaseVO) throws Exception;	
	
	public void updatePurchase(PurchaseVO purchaseVO) throws Exception;

	public PurchaseVO getPurchase(String tranNo) throws Exception;		
	
	public List<PurchaseVO> getPurchaseList(SearchVO searchVO) throws Exception;
	
}
