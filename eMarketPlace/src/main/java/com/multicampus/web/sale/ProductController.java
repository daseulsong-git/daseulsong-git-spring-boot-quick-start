package com.multicampus.web.sale;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.multicampus.biz.common.SearchVO;
import com.multicampus.biz.sale.CategoryService;
import com.multicampus.biz.sale.CategoryVO;
import com.multicampus.biz.sale.ProductService;
import com.multicampus.biz.sale.ProductVO;

import jakarta.servlet.http.HttpSession;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;	
	
	@Autowired
	private CategoryService categoryService;
	
	// 상품 등록 화면으로 이동
	@RequestMapping("/addProductView.do")
	public String addProductView(CategoryVO categoryVO, SearchVO searchVO, Model model) throws Exception {
		model.addAttribute("categoryList", categoryService.getCategoryList(searchVO));
		return "/sale/addProduct.jsp";
	}
	
	// 상품 등록 
	@RequestMapping("/addProduct.do")
	public String addProduct(ProductVO productVO, HttpSession session) throws Exception {
		// 파일 업로드
		MultipartFile uploadFile = productVO.getUploadFile();
		if (!uploadFile.isEmpty()) {
			String originalFilename = uploadFile.getOriginalFilename();
			File dirPath = new File("C:/DEV_ECLIPSE_PROJECT/eclipse-workspace/eMarketPlace/src/main/webapp/images/upload_files/productImage/" + originalFilename);
			uploadFile.transferTo(dirPath);
			productVO.setImageFile(originalFilename);
		} else productVO.setImageFile("");

		productService.addProduct(productVO);
		return "redirect:getSaleList.do";
	}	
	
	// 상품 수정
	@RequestMapping("/updateProduct.do")
	public String updateProduct(ProductVO productVO)throws Exception {
		productService.updateProduct(productVO);
		return "redirect:/getSaleList.do";
	}
	
	// 상품 상세 조회
	@RequestMapping("/getProduct.do")
	public String GetProduct(ProductVO productVO, CategoryVO categoryVO, SearchVO searchVO, Model model) throws Exception {
		model.addAttribute("categoryList", categoryService.getCategoryList(searchVO));
		model.addAttribute("productVO", productService.getProduct(productVO));		
		return "/sale/getProduct.jsp";
	}

}
