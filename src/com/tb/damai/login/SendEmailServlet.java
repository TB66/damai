package com.tb.damai.login;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tb.damai.dao.UserDao;
import com.tb.damai.po.DmUser;
import com.tb.damai.util.SendEmail;
import com.tb.damai.web.BaseServlet;

/**
 * Servlet implementation class SendEmailServlet
 */
@WebServlet("/SendEmailServlet")
public class SendEmailServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
	protected void send(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DmUser user=new DmUser();
		user.setEname(request.getParameter("username"));
		List<DmUser> list= new UserDao().query(user);
		if(list.size()==0) {
			response.getWriter().print("无此用户");
			return;
		}
		String email=user.getEmail();
		System.out.println(email);
		String yzm=SendEmail.random1();
		request.getSession().setAttribute("yzm", yzm);
		SendEmail.test(email, yzm);
		response.getWriter().print("验证码已发送至你的邮箱，请及时查看。");
	}

}
