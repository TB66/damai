package com.tb.damai.login;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.tb.damai.po.DmUser;
import com.tb.damai.web.BaseServlet;

@WebServlet("/GetLoginedUserServlet")
public class GetLoginedUserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
    
	public void getUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		DmUser user= (DmUser) request.getSession().getAttribute("user");
		Gson gson = new Gson();
        String json = gson.toJson(user);
		response.getWriter().print(json);
		
	}

}
