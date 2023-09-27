package com.multicampus.biz.sale;

import java.util.List;

import com.multicampus.biz.common.SearchVO;

public interface CategoryService {
	
	public String addCategory(CategoryVO categoryVO) throws Exception;	
	
	public void updateCategory(CategoryVO categoryVO) throws Exception;
	
	public List<CategoryVO> getCategoryList(SearchVO searchVO) throws Exception;	

	public CategoryVO getCategory(CategoryVO categoryVO) throws Exception;	
}
