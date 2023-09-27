package com.multicampus.biz.purchase;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.multicampus.biz.common.SearchVO;

@Repository
public class DeliveryCompanyDAO {
	
	@Autowired
	private SqlSessionTemplate myBatis;
	
	public void addDeliveryCompany(DeliveryCompanyVO deliveryCompanyVO) throws Exception {
		myBatis.insert("DeliveryCompany.addDeliveryCompany", deliveryCompanyVO);
	}

	public void updateDeliveryCompany(DeliveryCompanyVO deliveryCompanyVO) throws Exception {
		myBatis.update("DeliveryCompany.updateDeliveryCompany", deliveryCompanyVO);
	}
	
	public DeliveryCompanyVO getDeliveryCompany(DeliveryCompanyVO deliveryCompanyVO) throws Exception {
		return (DeliveryCompanyVO) myBatis.selectOne("DeliveryCompany.getDeliveryCompany", deliveryCompanyVO);
	}

	public List<DeliveryCompanyVO> getDeliveryCompanyList(SearchVO searchVO) throws Exception {
		DeliveryCompanyVO deliveryCompanyVO = new DeliveryCompanyVO();
		if(searchVO.getSearchCondition() == null) searchVO.setSearchCondition("0");
		if(searchVO.getSearchKeyword() == null) searchVO.setSearchKeyword("");

		if(searchVO.getSearchCondition().equals("") || searchVO.getSearchCondition().equals("0")) 
			deliveryCompanyVO.setDlvyCompNo(searchVO.getSearchKeyword());
		else 
			deliveryCompanyVO.setDlvyCompName(searchVO.getSearchKeyword());	
			
		if(searchVO.getSearchUseYn()!= null && !"A".equals(searchVO.getSearchUseYn()))
			deliveryCompanyVO.setUseYn(searchVO.getSearchUseYn());		
		
		return myBatis.selectList("DeliveryCompany.getDeliveryCompanyList", deliveryCompanyVO);
	}
}
