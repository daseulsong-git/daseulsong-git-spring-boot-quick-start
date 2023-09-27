package com.multicampus.web.sale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multicampus.biz.common.SearchVO;
import com.multicampus.biz.sale.CategoryService;
import com.multicampus.biz.sale.CategoryVO;

import jakarta.servlet.http.HttpSession;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	// 카테고리 등록 화면으로 이동
	@RequestMapping("/addCategoryView.do")
	public String addCategoryView()	throws Exception {
		return "/sale/addCategory.jsp";
	}
	
	// 카테고리 등록
	@RequestMapping("/addCategory.do")
	public String addCategory(CategoryVO categoryVO, HttpSession session, Model model) throws Exception {
		categoryService.addCategory(categoryVO);
		return "getCategoryList.do";
	}
	
	// 카테고리 수정
	@RequestMapping("/updateCategory.do")
	public String updateCategory(CategoryVO categoryVO, Model model) throws Exception {
		categoryService.updateCategory(categoryVO);
		return "redirect:/getCategoryList.do";
	}
	
	// 카테고리 상세 조회
	@RequestMapping("/getCategory.do")
	public String getCategory(CategoryVO categoryVO, Model model) throws Exception {
		model.addAttribute("categoryVO", categoryService.getCategory(categoryVO));		
		return "/sale/getCategory.jsp";
	}

	// 카테고리 목록 검색
	@RequestMapping("/getCategoryList.do")
	public String getCategoryList(SearchVO searchVO, CategoryVO categoryVO, Model model) throws Exception {
		model.addAttribute("searchVO", searchVO);
		model.addAttribute("categoryList", categoryService.getCategoryList(searchVO));		
		return "/sale/getCategoryList.jsp";
	}

}
