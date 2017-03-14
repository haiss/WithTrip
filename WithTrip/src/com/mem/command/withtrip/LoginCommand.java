package com.mem.command.withtrip;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bcommand.withtrip.BCommand;
import com.mem.dao.withtrip.MemDAO;
import com.mem.dto.withtrip.MemDTO;

public class LoginCommand implements BCommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		
		MemDAO dao = new MemDAO();
		MemDTO dto = dao.Login(email,pw);
		
		HttpSession httpSession = request.getSession();
		httpSession.setAttribute("email", dto.getEmail());
		httpSession.setAttribute("name", dto.getName());
		httpSession.setAttribute("pw", dto.getPw());
		httpSession.setAttribute("country", dto.getCountry());
		httpSession.setAttribute("city", dto.getCity());
		httpSession.setAttribute("sex", dto.getSex());
		httpSession.setAttribute("hobby", dto.getHobby());

		System.out.println("Login User Name = " + httpSession.getAttribute("name"));
		System.out.println("Login User hobby = " + httpSession.getAttribute("hobby"));
		
		request.setAttribute("LoginOK", dto);
		
	}
}
