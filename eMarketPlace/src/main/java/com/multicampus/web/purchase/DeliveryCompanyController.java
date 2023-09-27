package com.multicampus.web.purchase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multicampus.biz.common.SearchVO;
import com.multicampus.biz.purchase.DeliveryCompanyService;
import com.multicampus.biz.purchase.DeliveryCompanyVO;

import jakarta.servlet.http.HttpSession;

@Controller
public class DeliveryCompanyController {
	
	@Autowired
	private DeliveryCompanyService deliveryCompanyService;
		
	// 배송회사 등록 화면으로 이동
	@RequestMapping("/addDeliveryCompanyView.do")
	public String showAddDeliveryCompany(){
		return "/purchase/addDeliveryCompany.jsp";
	}
	
	// 배송회사 등록
	@RequestMapping("/addDeliveryCompany.do")
	public String addDeliveryCompany(DeliveryCompanyVO deliveryCompanyVO, HttpSession session) throws Exception {
		deliveryCompanyVO.setRegId((String)session.getAttribute("userId"));
		deliveryCompanyVO.setModifyId((String)session.getAttribute("userId"));
		deliveryCompanyService.addDeliveryCompany(deliveryCompanyVO);	
		return "redirect:getDeliveryCompanyList.do";
	}

	// 배송회사 수정
	@RequestMapping("/updateDeliveryCompany.do")
	public String updateDeliveryCompany(DeliveryCompanyVO deliveryCompanyVO, HttpSession session) throws Exception {
		String userId = (String)session.getAttribute("userId"); 
		deliveryCompanyVO.setModifyId(userId);		
		deliveryCompanyService.updateDeliveryCompany(deliveryCompanyVO);
		return "redirect:/getDeliveryCompanyList.do";
	}
	
	// 배송업체 상세 조회
	@RequestMapping("/getDeliveryCompany.do")
	public String getDeliveryCompany(DeliveryCompanyVO deliveryCompanyVO, Model model) throws Exception {
		model.addAttribute("deliveryCompanyVO", deliveryCompanyService.getDeliveryCompany(deliveryCompanyVO));
		return "/purchase/getDeliveryCompany.jsp";
	}

	// 배송업체 목록 검색
	@RequestMapping("/getDeliveryCompanyList.do")
	public String getDeliveryCompanyList(SearchVO searchVO, Model model) throws Exception {
		model.addAttribute("searchVO", searchVO);
		model.addAttribute("deliveryCompanyList", deliveryCompanyService.getDeliveryCompanyList(searchVO));
		return "/purchase/getDeliveryCompanyList.jsp";
	}


}
