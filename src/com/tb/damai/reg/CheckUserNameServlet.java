package com.tb.damai.reg;

import java.io.IOException;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tb.damai.dao.UserDao;
import com.tb.damai.po.DmUser;
import com.tb.damai.web.BaseServlet;

/**
 * Servlet implementation class CheckUserNameServlet
 */
@WebServlet("/CheckUserNameServlet")
public class CheckUserNameServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	public void checkUserName(HttpServletRequest request, HttpServletResponse response) throws IOException {
		DmUser user=new DmUser();
		user.setEname(request.getParameter("ename"));
		List<DmUser> list=new UserDao().query(user);
		if(list.size()>0) {
			response.getWriter().print("用户名重复");
		}else{
			response.getWriter().print("用户名可用");
		};
	}
}
