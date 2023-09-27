package com.multicampus.web.purchase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multicampus.biz.code.CodeService;
import com.multicampus.biz.common.SearchVO;
import com.multicampus.biz.purchase.DeliveryCompanyService;
import com.multicampus.biz.purchase.PurchaseService;
import com.multicampus.biz.purchase.PurchaseVO;
import com.multicampus.biz.sale.ProductService;
import com.multicampus.biz.sale.ProductVO;

import jakarta.servlet.http.HttpSession;

@Controller
public class PurchaseController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private DeliveryCompanyService deliveryCompanyService;
	
	@Autowired
	private CodeService codeService;
	
	@Autowired
	private PurchaseService purchaseService;
	
	// 구매 화면으로 이동
	@RequestMapping("/addPurchaseView.do")
	public String getProductSearch(ProductVO productVO, SearchVO searchVO, Model model) throws Exception {
		model.addAttribute("productVO", productService.getProduct(productVO));
		model.addAttribute("paymentOptionList", codeService.getCodeList("A04"));
		model.addAttribute("deliveryCompanyList", deliveryCompanyService.getDeliveryCompanyList(searchVO));
		return "/purchase/addPurchase.jsp";
	}

	@RequestMapping("/addPurchase.do")
	public String addPurchase(PurchaseVO purchaseVO, HttpSession session) throws Exception {
		String userId = (String)session.getAttribute("userId");		
		purchaseVO.setBuyerId(userId);		
		purchaseService.addPurchase(purchaseVO);
		return "redirect:/getPurchaseList.do";
	}
	
	// 구매 수정 화면으로 이동
	@RequestMapping("/updatePurchaseView.do")
	public String updatePurchaseView(PurchaseVO purchaseVO, SearchVO searchVO, Model model) throws Exception {
		model.addAttribute("purchaseVO", purchaseService.getPurchase(purchaseVO.getTranNo()));
		model.addAttribute("paymentOptionList", codeService.getCodeList("A04"));
		model.addAttribute("deliveryCompanyList", deliveryCompanyService.getDeliveryCompanyList(searchVO)); 		
		return "/purchase/updatePurchaseView.jsp";
	}
	
	// 구매 수정
	@RequestMapping("/updatePurchase.do")
	public String updatePurchase(PurchaseVO purchaseVO) throws Exception {
		purchaseService.updatePurchase(purchaseVO);
		return "/getPurchaseList.do";
	}
	
	// 구매 상세 조회
	@RequestMapping("/getPurchase.do")
	public String getPurchase(PurchaseVO purchaseVO, SearchVO searchVO, Model model) throws Exception {
		model.addAttribute("purchaseVO", purchaseService.getPurchase(purchaseVO.getTranNo()));
		return "/purchase/getPurchase.jsp";
	}

	// 구매 목록 검색
	@RequestMapping("/getPurchaseList.do")
	public String getPurchaseList(PurchaseVO purchaseVO, SearchVO searchVO, HttpSession session, Model model) throws Exception {
		// 로그인 성공한 사용자가 구매한 구매 목록만 조회하기 위한 코드
		String userId = (String)session.getAttribute("userId");
		searchVO.setSearchBuyerId(userId);
		model.addAttribute("searchVO", searchVO);
		model.addAttribute("purchaseList", purchaseService.getPurchaseList(searchVO));
		return "/purchase/getPurchaseList.jsp";
	}

	
}
