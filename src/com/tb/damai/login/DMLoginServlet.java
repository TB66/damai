package com.tb.damai.login;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tb.damai.dao.UserDao;
import com.tb.damai.po.DmUser;
import com.tb.damai.web.BaseServlet;

/**
 * Servlet implementation class DMLoginServlet
 */
@WebServlet("/DMLoginServlet")
public class DMLoginServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DmUser user=new DmUser();
		user.setEname(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		String captcha=request.getParameter("captcha");
		boolean isRememberUsername=Boolean.valueOf(request.getParameter("isRememberUsername"));
		String username=URLEncoder.encode(user.getEname());
		String password=URLEncoder.encode(user.getPassword());
		Cookie cun=new Cookie("username", username);
		Cookie cuw=new Cookie("password", password);
		
		String vcaptcha=(String) request.getSession().getAttribute("captcha");
		List<DmUser> list=new UserDao().query(user);
		user=list.get(0);
		if(!captcha.equalsIgnoreCase(vcaptcha)) {
			response.getWriter().print("验证码错误");
			return;
		}else if(list==null) {
			response.getWriter().print("用户名或密码错误");
			return;
		}else {
			if(isRememberUsername==true) {
				
				
				cun.setMaxAge(60*60);
				cuw.setMaxAge(60*60);
				response.addCookie(cun);
				response.addCookie(cuw);
			}else {
				cun.setMaxAge(0);
				cuw.setMaxAge(0);
				response.addCookie(cun);
				response.addCookie(cuw);
			}
			request.getSession().setAttribute("user", user);
			response.getWriter().print("登录成功");
		}
		
	}
	protected void findPwd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DmUser user=new DmUser();
		user.setEname(request.getParameter("username"));
		String gyzm=request.getParameter("yzm");
		String captcha=request.getParameter("captcha");
		String vcaptcha=(String) request.getSession().getAttribute("captcha");
		String yzm=(String) request.getSession().getAttribute("yzm");
		System.out.println(yzm);
		if(!captcha.equalsIgnoreCase(vcaptcha)) {
			response.getWriter().print("验证码错误");
			return;
		}
		if(gyzm.equals(yzm)==false) {
			response.getWriter().print("找回密码的验证码错误");
			return;
		}
		List<DmUser> list=new UserDao().query(user);
		if(list.size()==0) {
			response.getWriter().print("没有该用户");
		}else {
			user=list.get(0);
			response.getWriter().print(user.getPassword());
		}
		
	}

}
