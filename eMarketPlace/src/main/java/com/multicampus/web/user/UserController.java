package com.multicampus.web.user;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.multicampus.biz.code.CodeService;
import com.multicampus.biz.common.SearchVO;
import com.multicampus.biz.user.UserService;
import com.multicampus.biz.user.UserVO;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	@Autowired
	private CodeService codeService;
	
	@Autowired
	private UserService userService;

	// 회원가입 화면으로 이동
	@RequestMapping("/addUserView.do")
	public String addUserView(Model model) throws Exception {
		model.addAttribute("cellPhoneCodeList", codeService.getCodeList("A01"));
		model.addAttribute("emailCodeList", codeService.getCodeList("A02"));		
		return "/user/addUser.jsp";
	}
	
	// 아이디 중복 체크
	@RequestMapping("/checkDuplication.do")
	public String checkDuplication(UserVO userVO, Model model) throws Exception {
		UserVO findUser = userService.getUser(userVO.getUserId());
		String message = "이미 사용중인 아이디입니다.";
		if(findUser == null) {
			message = "사용 가능한 아이디입니다.";
		}
		model.addAttribute("message", message);
		model.addAttribute("userVO", userVO);
		return "/user/checkDuplication.jsp";
	}
	
	// 회원 등록
	@RequestMapping("/addUser.do")
	public String addUser(UserVO userVO, HttpSession session) throws Exception {
		// 파일 업로드
		MultipartFile uploadFile = userVO.getUploadFile();
		if (!uploadFile.isEmpty()) {
			String originalFilename = uploadFile.getOriginalFilename();
			File dirPath = new File("C:/DEV_ECLIPSE_PROJECT/eclipse-workspace/eMarketPlace/src/main/webapp/images/upload_files/userImage/" + originalFilename);
			uploadFile.transferTo(dirPath);
			userVO.setImageFile(originalFilename);
		} else userVO.setImageFile("");
		
		// 회원 등록
		userService.addUser(userVO);
		return "/";
	}
	
	// 회원 수정
	@RequestMapping("/updateUser.do")
	public String updateUser(UserVO userVO) throws Exception {
		userService.updateUser(userVO);
		return "redirect:/getUserList.do";
	}
	
	// 회원 상세 조회
	@RequestMapping("/getUser.do")
	public String getUser(UserVO userVO, HttpSession session, Model model) throws Exception {
		String userId = userVO.getUserId();
		if(userId == null) {
			userId = (String) session.getAttribute("userId");
		}
		model.addAttribute("emailCodeList", codeService.getCodeList("A02"));
		model.addAttribute("userVO", userService.getUser(userId));		
		System.out.println();
		return "/user/getUser.jsp";
	}
	
	// 회원 목록 검색
	@RequestMapping("/getUserList.do")
	public String getUserList(SearchVO searchVO, Model model) throws Exception {
		List<UserVO> userList = userService.getUserList(searchVO);
		model.addAttribute("userList", userList);
		model.addAttribute("searchVO", searchVO);
		return "/user/getUserList.jsp";
	}
}
