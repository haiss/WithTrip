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
		httpSession.setAttribute("pw", dto.getPw());
		httpSession.setAttribute("name", dto.getName());
		
		System.out.println("User Name = " + httpSession.getAttribute("name"));
		
		request.setAttribute("LoginOK", dto);
		
	}
}
