package com.tb.damai.cart;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.tb.damai.dao.CartDao;
import com.tb.damai.po.DmUser;
import com.tb.damai.web.BaseServlet;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private CartDao cd=new CartDao(); 
	protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DmUser user=(DmUser) request.getSession().getAttribute("user");
		Integer pid=Integer.valueOf(request.getParameter("pid"));
		Integer count=Integer.valueOf(request.getParameter("count"));
		if(cd.update(user.getId(), pid, count)==0) {
			cd.insert(user.getId(), pid, count);
		}
		response.getWriter().print("添加成功");
	}
	
	protected void load(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DmUser user=(DmUser) request.getSession().getAttribute("user");
		List<Map<String, Object>> list=cd.query(user.getId());
		print(response, list);
		
	}
	protected void del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id=Integer.valueOf(request.getParameter("id"));
		cd.del(id);
		response.getWriter().append("删除成功");
	}
	protected void delAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DmUser user=(DmUser) request.getSession().getAttribute("user");
		cd.delAll(user.getId());
		response.getWriter().append("删除成功");
	}
}
