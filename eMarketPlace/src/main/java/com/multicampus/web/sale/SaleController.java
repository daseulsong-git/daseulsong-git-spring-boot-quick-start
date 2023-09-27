package com.multicampus.web.sale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multicampus.biz.code.CodeService;
import com.multicampus.biz.common.SearchVO;
import com.multicampus.biz.sale.SaleService;
import com.multicampus.biz.sale.SaleVO;

import jakarta.servlet.http.HttpSession;

@Controller
public class SaleController {
	
	@Autowired
	private CodeService codeService;
	
	@Autowired
	private SaleService saleService;
	
	@RequestMapping("/updateTranStatusCode.do")
	public String updateTranStatusCode() throws Exception {
		// 거래 상태 코드를 수정하는 로직은 아직 구현 안됨
		return "";
	}
	
	// 판매 상세 조회
	@RequestMapping("/getSale.do")
	public String getSale(SaleVO saleVO, Model model)throws Exception {
		model.addAttribute("saleVO", saleService.getSale(saleVO.getProdNo()));
		return "/sale/getSale.jsp";
	}
	
	// 판매 목록 검색
	@RequestMapping("/getSaleList.do")
	public String getSaleList(SearchVO searchVO, HttpSession session, Model model) throws Exception {
		model.addAttribute("tranStatusCodeList", codeService.getCodeList("A03"));
		
		String userId = (String) session.getAttribute("userId");
		searchVO.setSearchSellerId(userId);
		model.addAttribute("saleList", saleService.getSaleList(searchVO));
		model.addAttribute("searchVO", searchVO);
		return "/sale/getSaleList.jsp";
	}
}
