package com.tb.damai.web;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

//@WebServlet("/BaseServlet")
public abstract class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		// 获取操作字段
		String op = request.getParameter("op");
		// java 的黑科技 ==> 反射技术
		// 通过 op 获取 方法对象
		try {
			
			Method method = this.getClass().getDeclaredMethod(op, HttpServletRequest.class, HttpServletResponse.class);
			// 设置方法的可以被访问
			method.setAccessible(true);
			// 执行方法
			method.invoke(this, request, response);
		} catch (Exception e) {
			// 捕获异常
			e.printStackTrace();
			response.getWriter().append("系统错误!");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	protected void print (HttpServletResponse response, Object obj) throws IOException {
		response.getWriter().print(new Gson().toJson(obj));
	}
}
