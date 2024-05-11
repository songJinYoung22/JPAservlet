package com.keduit.controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.keduit.dao.MemDAO;

import com.keduit.dto.MemVO;

public class CheckIdAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
	
		MemDAO mDAO = MemDAO.getInstance();
		int result = mDAO.checkId(id);
		
		if(result == 1) {
			
		String responseData = "true";
		
		response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.print(responseData);
        out.flush();
		
		}else if(result == 0) {
			String responseData = "false";
			
			response.setContentType("text/plain");
	        response.setCharacterEncoding("UTF-8");
	        PrintWriter out = response.getWriter();
	        out.print(responseData);
	        out.flush();
		}

	}

}
