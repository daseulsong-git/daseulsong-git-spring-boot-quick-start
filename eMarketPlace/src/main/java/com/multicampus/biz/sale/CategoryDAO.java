package com.multicampus.biz.sale;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.multicampus.biz.common.SearchVO;

@Repository
public class CategoryDAO {
	
	@Autowired
	private SqlSessionTemplate myBatis;
	
	public void addCategory(CategoryVO categoryVO) throws Exception {
		myBatis.insert("Category.addCategory", categoryVO);
	}

	public void updateCategory(CategoryVO categoryVO) throws Exception {
		myBatis.update("Category.updateCategory", categoryVO);
	}
	
	public CategoryVO getCategory(CategoryVO categoryVO) throws Exception {
		return (CategoryVO) myBatis.selectOne("Category.getCategory", categoryVO);
	}

	public List<CategoryVO> getCategoryList(SearchVO searchVO) throws Exception {
		if(searchVO.getSearchCondition() == null) searchVO.setSearchCondition("0");
		if(searchVO.getSearchKeyword() == null) searchVO.setSearchKeyword("");
		CategoryVO categoryVO = new CategoryVO();
		
		if(searchVO.getSearchCondition().equals("") || searchVO.getSearchCondition().equals("0")) 
			categoryVO.setCategoryNo(searchVO.getSearchKeyword());
		else
			categoryVO.setCategoryName(searchVO.getSearchKeyword());
		
		if(searchVO.getSearchUseYn()!= null && !"A".equals(searchVO.getSearchUseYn()))
			categoryVO.setUseYn(searchVO.getSearchUseYn());
		return myBatis.selectList("Category.getCategoryList", categoryVO);
	}
}
