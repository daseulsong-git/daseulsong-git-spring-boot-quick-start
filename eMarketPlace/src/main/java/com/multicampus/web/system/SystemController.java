package com.multicampus.web.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multicampus.biz.user.UserService;
import com.multicampus.biz.user.UserVO;

import jakarta.servlet.http.HttpSession;

@Controller
public class SystemController {

	@Autowired
	private UserService userService;

	@RequestMapping("/loginView.do")
	public String loginView() {
		return "/system/login.jsp";
	}

	@RequestMapping("/login.do")
	public String login(UserVO userVO, HttpSession session) throws Exception {
		UserVO resultUserVO = userService.getUser(userVO.getUserId());
		if (resultUserVO != null) {
			session.setAttribute("userId", resultUserVO.getUserId());
			return "/system/welcome.jsp";
		} else {
			return "/loginView.do";
		}
	}

	@RequestMapping("/logout.do")
	public String logout(HttpSession session) throws Exception {
		session.invalidate();
		return "redirect:/";
	}
}
