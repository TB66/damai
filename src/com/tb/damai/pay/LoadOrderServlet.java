package com.tb.damai.pay;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tb.damai.dao.OrderItemDao;
import com.tb.damai.dao.OrdersDao;
import com.tb.damai.web.BaseServlet;

@WebServlet("/LoadOrderServlet")
public class LoadOrderServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	protected void load(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer oid=Integer.valueOf(request.getParameter("oid"));
		List<Map<String, Object>> orderItem=new OrderItemDao().queryByOid(oid);
		Map<String, Object> orders=new OrdersDao().queryByid(oid);
		Map<String, Object> ret=new HashMap<String, Object>();
		ret.put("orders", orders);
		ret.put("orderItem", orderItem);
		print(response, ret);
	}

}
