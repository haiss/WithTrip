package com.mem.command.withtrip;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bcommand.withtrip.BCommand;
import com.mem.dao.withtrip.MemDAO;

public class JoinCommand implements BCommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("join-command");
		
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String country = request.getParameter("country");
		String city = request.getParameter("city");
		String sex = request.getParameter("sex");
		String[] hobby = request.getParameterValues("hobby");
		
		MemDAO dao = new MemDAO();
		dao.Join(email, pw, name, country, city, sex, hobby);
	}
}
