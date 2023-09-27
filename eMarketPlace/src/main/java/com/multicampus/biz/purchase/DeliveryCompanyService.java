package com.multicampus.biz.purchase;

import java.util.List;

import com.multicampus.biz.common.SearchVO;

public interface DeliveryCompanyService {
	
	public String addDeliveryCompany(DeliveryCompanyVO deliveryCompVO) throws Exception;	
	
	public void updateDeliveryCompany(DeliveryCompanyVO deliveryCompVO) throws Exception;
	
	public List<DeliveryCompanyVO> getDeliveryCompanyList(SearchVO searchVO) throws Exception;	
	
	public DeliveryCompanyVO getDeliveryCompany(DeliveryCompanyVO deliveryCompVO) throws Exception;
}
