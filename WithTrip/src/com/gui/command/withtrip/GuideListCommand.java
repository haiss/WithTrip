package com.gui.command.withtrip;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bcommand.withtrip.BCommand;
import com.gui.dao.withtrip.GuideDAO;
import com.gui.dto.withtrip.GuideDTO;

public class GuideListCommand implements BCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Enter - GuideListCon");
		GuideDAO dao = new GuideDAO();
		ArrayList<GuideDTO> dtos = dao.GuideView();
		request.setAttribute("GuideList", dtos);
		
	}

}
