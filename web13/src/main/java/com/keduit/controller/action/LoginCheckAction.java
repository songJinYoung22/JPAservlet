package com.keduit.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.keduit.dao.MemDAO;
import com.keduit.dto.MemVO;

public class LoginCheckAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "mem/login.jsp";
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String lev = request.getParameter("lev");


		MemDAO mDAO = MemDAO.getInstance();

		MemVO mVO = mDAO.idCheck(id);
		System.out.println(mVO);
		if (mVO.getPwd() == null) {
			request.setAttribute("message", "아이디가 존재하지 않습니다.");
		} else if (!(mVO.getPwd().equals(pwd))) {
			request.setAttribute("message", "비밀번호가 맞지 않습니다.");

		} else if (mVO.getPwd().equals(pwd) && lev.equals(mVO.getLev())) {
			HttpSession session = request.getSession();
			session.setAttribute("mVO", mVO); 
			// 키와 벨류 생성.
			request.setAttribute("massage", "회원 로그인 성공!");
			url = "mem/main.jsp";
			
			
			
//			if (lev.equals("A")) {
//				HttpSession session = request.getSession();
//				session.setAttribute("mVO", mVO);
//				// 키와 벨류 생성.
//				request.setAttribute("massage", "회원 로그인 성공!");
//				url = "mem/aMain.jsp";
//
//			} else if (lev.equals("B")) {
//				HttpSession session = request.getSession();
//				session.setAttribute("mVO", mVO);
//				// 키와 벨류 생성.
//				request.setAttribute("massage", "회원 로그인 성공!");
//				url = "mem/bMain.jsp";
//			}
		} else{
			request.setAttribute("message", "레벨이 맞지 않습니다");
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}
}
