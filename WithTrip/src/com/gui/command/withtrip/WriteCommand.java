package com.gui.command.withtrip;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bcommand.withtrip.BCommand;
import com.gui.dao.withtrip.GuideDAO;

public class WriteCommand implements BCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		String pw = request.getParameter("pw");
		String title =  request.getParameter("title");
		String country = request.getParameter("country");
		String city = request.getParameter("city");
		String language = request.getParameter("language");
		String Scost = request.getParameter("cost");
		int cost = Integer.parseInt(Scost);
		String content = request.getParameter("content");
		
		GuideDAO dao = new GuideDAO();
		
		dao.GuideRequest(name, pw, title, country, city, language, cost, content);
		
	}

}
