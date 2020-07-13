package com.tb.damai.reg;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tb.damai.dao.UserDao;
import com.tb.damai.web.BaseServlet;



@WebServlet("/DMRegServlet")
public class DMRegServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	protected void reg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String ename=request.getParameter("username");
		String cname=request.getParameter("name");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String sex=request.getParameter("sex");
		String vcaptcha=request.getParameter("captcha");
		String captcha=(String) request.getSession().getAttribute("captcha");
		if(vcaptcha.trim().isEmpty()==true) {
			response.getWriter().print("请输入验证码");
			return;
		}
		if(!captcha.equalsIgnoreCase(vcaptcha)) {
			response.getWriter().print("验证码错误");
			return;
		}
		
		new UserDao().reg(ename, cname, password, email, phone, sex);
		response.getWriter().print("注册成功");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
