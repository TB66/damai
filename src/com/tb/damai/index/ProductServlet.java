package com.tb.damai.index;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tb.damai.dao.ProductDao;
import com.tb.damai.po.DmProduct;
import com.tb.damai.web.BaseServlet;

@WebServlet("/ProductServlet.do")
public class ProductServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	protected void query(HttpServletRequest request, HttpServletResponse response ,DmProduct product) throws ServletException, IOException {
		
		List<DmProduct> list=new ProductDao().query(product, 0, 10);
		HashMap<String, Object> page=new HashMap<String, Object>();
		page.put("list", list);
		print( response, page);
    }
	protected void queryHot(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DmProduct product=new DmProduct();
		product.setIs_hot(Integer.valueOf(request.getParameter("is_hot")));
		query(request, response, product);
	}

	protected void queryNew(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DmProduct product=new DmProduct();
		product.setIs_hot(Integer.valueOf(request.getParameter("is_hot")));
		query(request, response,product);
	}
	protected void queryByCid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DmProduct product=new DmProduct();
		product.setCid(Integer.valueOf(request.getParameter("cid")));
		query(request, response,product);
	}
	protected void queryByPid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DmProduct product=new DmProduct();
		product.setId(Integer.valueOf(request.getParameter("pid")));
		query(request, response,product);
	}
}
