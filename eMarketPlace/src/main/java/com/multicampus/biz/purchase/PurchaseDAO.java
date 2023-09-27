package com.multicampus.biz.purchase;
 
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.multicampus.biz.common.SearchVO;

@Repository
public class PurchaseDAO {
	
	@Autowired
	private SqlSessionTemplate myBatis;
	
	public int countPurchaseListByDeliveryCompany(String dlvyCompNo) throws Exception {
		Integer cnt = (Integer) myBatis.selectOne("Purchase.getPurchaseListByDeliveryCompany", dlvyCompNo);
		return cnt.intValue();
	}
	
	public PurchaseVO getPurchase(String tranNo) throws Exception {
		return (PurchaseVO) myBatis.selectOne("Purchase.getPurchase", tranNo);
	}

	public void addPurchase(PurchaseVO purchaseVO) throws Exception {
		String tranStatusCode = "002";  
		purchaseVO.setTranStatusCode(tranStatusCode);

		myBatis.insert("Purchase.addPurchase", purchaseVO);		
		myBatis.update("Purchase.updateProdTranStatusCode", purchaseVO);
	}
		
	public void updatePurchase(PurchaseVO purchaseVO) throws Exception {
		myBatis.update("Purchase.updatePurchase", purchaseVO);
	}

	public List<PurchaseVO> getPurchaseList(SearchVO searchVO) throws Exception {
		if(searchVO.getSearchCondition() == null) searchVO.setSearchCondition("0");
		if(searchVO.getSearchKeyword() == null) searchVO.setSearchKeyword("");
		
		PurchaseVO purchaseVO = new PurchaseVO();
		if(searchVO.getSearchCondition().equals("") || searchVO.getSearchCondition().equals("0")) 
			purchaseVO.setTranNo(searchVO.getSearchKeyword());
		else 
			purchaseVO.setProdName(searchVO.getSearchKeyword());
		
		if(searchVO.getSearchTranStatusCode() != null && !searchVO.getSearchTranStatusCode().equals("A")) 
			purchaseVO.setTranStatusCode(searchVO.getSearchTranStatusCode());
		
		purchaseVO.setBuyerId(searchVO.getSearchBuyerId());
		
		return myBatis.selectList("Purchase.getPurchaseList", purchaseVO);
	}
}
