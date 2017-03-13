package com.gui.command.withtrip;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bcommand.withtrip.BCommand;
import com.gui.dao.withtrip.GuideDAO;
import com.gui.dto.withtrip.GuideDTO;

public class GuideContenViewCommand implements BCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id");
//		if (id==null) {
//			System.out.println("null");			
//		}
//		System.out.println(id);			
		
		GuideDAO dao = new GuideDAO();
		GuideDTO dto = dao.GuideContent(id);
		
		request.setAttribute("ContentView", dto);
	}

}
