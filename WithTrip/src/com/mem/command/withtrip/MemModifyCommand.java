package com.mem.command.withtrip;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bcommand.withtrip.BCommand;
import com.mem.dao.withtrip.MemDAO;
import com.mem.dto.withtrip.MemDTO;

public class MemModifyCommand implements BCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String country = request.getParameter("country");
		String city = request.getParameter("city");
		String sex = request.getParameter("sex");
		String[] hobby = request.getParameterValues("hobby");
		
		System.out.println(email+pw);
		
		MemDAO dao = new MemDAO();
		dao.MemModify(email, pw, name, country, city, sex, hobby);
		
		///request.setAttribute("MemModify", dto);
		
		
	}

}
