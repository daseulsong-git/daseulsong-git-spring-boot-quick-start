package com.multicampus.biz.sale;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.multicampus.biz.common.SearchVO;

@Repository
public class SaleDAO {
	
	@Autowired
	private SqlSessionTemplate myBatis;

	public void updateTranStatusCode(SaleVO saleVO) throws Exception {
		myBatis.update("Sale.updateProductTranStatusCode", saleVO);		
		myBatis.update("Sale.updateTransactionTranStatusCode", saleVO);
	}
	
	public SaleVO getSale(String prodNo) throws Exception {
		return (SaleVO) myBatis.selectOne("Sale.getSale", prodNo);
	}

	public List<SaleVO> getSaleList(SearchVO searchVO) throws Exception {
		if(searchVO.getSearchCondition() == null) searchVO.setSearchCondition("0");
		if(searchVO.getSearchKeyword() == null) searchVO.setSearchKeyword("");
		
		SaleVO saleVO = new SaleVO();
		if(searchVO.getSearchCondition().equals("") || searchVO.getSearchCondition().equals("0")) 
			saleVO.setProdNo(searchVO.getSearchKeyword());
		else 
			saleVO.setProdName(searchVO.getSearchKeyword());

		if(searchVO.getSearchTranStatusCode() != null && !searchVO.getSearchTranStatusCode().equals("A")) 
			saleVO.setTranStatusCode(searchVO.getSearchTranStatusCode());
		if(searchVO.getSearchSellerId() != null && !searchVO.getSearchSellerId().equals("")) 
			saleVO.setSellerId(searchVO.getSearchSellerId());

		return myBatis.selectList("Sale.getSaleList", saleVO);
	}
}










