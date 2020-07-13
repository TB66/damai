package com.tb.damai.dao;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tb.damai.util.VerifyCodeUtils;

/**
 * Servlet implementation class VcodeServlet
 */
@WebServlet("/DMVcodeServlet.do")
public class VcodeServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String captcha =VerifyCodeUtils.outputImage(response);
		session.setAttribute("captcha", captcha);
	}

	

}
