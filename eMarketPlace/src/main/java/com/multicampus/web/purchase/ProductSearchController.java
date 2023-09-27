package com.multicampus.web.purchase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multicampus.biz.common.SearchVO;
import com.multicampus.biz.sale.ProductService;
import com.multicampus.biz.sale.ProductVO;

@Controller
public class ProductSearchController {
	@Autowired
	private ProductService productService;
	
	// 상품 상세 조회
	@RequestMapping("/getProductSearch.do")
	public String getProductSearch(ProductVO productVO, Model model) throws Exception {
		model.addAttribute("productVO", productService.getProduct(productVO));	
		return "/purchase/getProductSearch.jsp";
	}
	
	// 상품 목록 검색
	@RequestMapping("/getProductSearchList.do")
	public String getProductList(ProductVO productVO, SearchVO searchVO, Model model) throws Exception {
		model.addAttribute("searchVO", searchVO);
		model.addAttribute("productList", productService.getProductList(searchVO));		
		return "/purchase/getProductList.jsp";
	}
}
