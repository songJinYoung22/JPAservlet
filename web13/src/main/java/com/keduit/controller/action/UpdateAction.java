package com.keduit.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.keduit.dao.MemDAO;
import com.keduit.dto.MemVO;

public class UpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "mem/bMyPage.jsp";
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String lev = request.getParameter("lev");
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");
		
		HttpSession session = request.getSession();
		MemVO mVO = (MemVO) session.getAttribute("mVO");
		
		if(pwd.equals(mVO.getPwd())) {
			MemVO mVO2 = new MemVO(name, mVO.getId(), mVO.getPwd(), mVO.getLev(), phone, gender);
			System.out.println("mVO2에 잘 담겼는지" + mVO2);
			MemDAO mDAO = MemDAO.getInstance();
			int result = mDAO.update(mVO2);
			
			if(1<=result) {
				session.setAttribute("mVO", mVO2);
				request.setAttribute("message", "수정 성공");
			}else {
				request.setAttribute("message", "수정 실패");
			}
			
			
		}else {
			request.setAttribute("message", "비밀번호 틀림");
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		

	}

}
