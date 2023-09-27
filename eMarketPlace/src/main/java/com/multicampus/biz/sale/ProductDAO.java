package com.multicampus.biz.sale;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.multicampus.biz.common.SearchVO;

@Repository
public class ProductDAO {
	
	@Autowired
	private SqlSessionTemplate myBatis;
	
	public int countProductListByCategory(ProductVO productVO) throws Exception {
		Integer cnt = (Integer) myBatis.selectOne("Product.countProductListByCategory", productVO);
		return cnt.intValue();
	}

	public void addProduct(ProductVO productVO) throws Exception {
		myBatis.insert("Product.addProduct", productVO);
	}

	public void updateProduct(ProductVO productVO) throws Exception {	
		myBatis.update("Product.updateProduct", productVO);
	}
	
	public ProductVO getProduct(ProductVO productVO) throws Exception {
		ProductVO product = (ProductVO) myBatis.selectOne("Product.getProduct", productVO);
		return product;
	}

	public List<ProductVO> getProductList(SearchVO searchVO) throws Exception {
		if(searchVO.getSearchCondition() == null) searchVO.setSearchCondition("0");
		if(searchVO.getSearchKeyword() == null) searchVO.setSearchKeyword("");
		
		ProductVO productVO = new ProductVO();
		if(searchVO.getSearchCondition().equals("") || searchVO.getSearchCondition().equals("0")) 
			productVO.setProdNo(searchVO.getSearchKeyword());
		else 
			productVO.setProdName(searchVO.getSearchKeyword());

		if(searchVO.getSearchAsYn() != null && !searchVO.getSearchAsYn().equals("A")) 
			productVO.setAsYn(searchVO.getSearchAsYn());		

		return myBatis.selectList("Product.getProductList", productVO);
		
	}
}
