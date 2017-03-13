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
		System.out.println(email+pw);
		
		MemDAO dao = new MemDAO();
		MemDTO dto = dao.Login(email,pw);
		
		request.setAttribute("MemModify", dto);
		
		
	}

}
