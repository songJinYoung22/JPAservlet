package com.keduit.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.keduit.dao.MemDAO;
import com.keduit.dto.MemVO;

public class InsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "mem/insertForm.jsp";
		
		MemVO mVO = new MemVO();
		mVO.setId(request.getParameter("id"));
		mVO.setPwd(request.getParameter("pwd"));
		mVO.setName(request.getParameter("name"));
		mVO.setPhone(request.getParameter("phone"));
		mVO.setLev(request.getParameter("lev"));
		mVO.setGender(request.getParameter("gender"));
		
		MemDAO mDAO = MemDAO.getInstance();
		int result = mDAO.insertAction(mVO);
		
		if(1 <= result ) {
			request.setAttribute("message", "계정 등록 성공!");
		}else {
			request.setAttribute("message", "계정 등록 실패했습니다.");
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
		
	}

}
