package com.multicampus.web.common;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@WebFilter(urlPatterns = {"/getUser.do", 
		                  "/getUserList.do", 
		                  "/addProductView.do", 
		                  "/getSaleList.do",
		                  "/getCategoryList.do",
		                  "/getProductSearchList.do",
		                  "/getPurchaseList.do",
		                  "/getDeliveryCompanyList.do"})
public class AuthenticationCheckFilter extends HttpFilter implements Filter {
 	private static final long serialVersionUID = 1L;


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 세션에 userId가 존재하는지 확인한다. 
		HttpServletRequest req = (HttpServletRequest) request;
		
		HttpSession session = req.getSession();
		if(session.getAttribute("userId") == null) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/system/login.jsp");
			dispatcher.forward(request, response);
		} else {
			chain.doFilter(request, response);
		}
	}

}
