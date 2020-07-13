package com.tb.damai.orders;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tb.damai.dao.OrderItemDao;
import com.tb.damai.web.BaseServlet;

@WebServlet("/OrderItemServlet")
public class OrderItemServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
	protected void load(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		new OrderItemDao().query(7);

	}

}
