package com.multicampus.biz.sale;

import java.util.List;

import com.multicampus.biz.common.SearchVO;

public interface ProductService {
	
	public int countProductListByCategory(ProductVO productVO) throws Exception;
	
	public String addProduct(ProductVO productVO) throws Exception;	
	
	public void updateProduct(ProductVO productVO) throws Exception;
	
	public ProductVO getProduct(ProductVO productVO) throws Exception;	
	
	public List<ProductVO> getProductList(SearchVO searchVO) throws Exception;	
}
