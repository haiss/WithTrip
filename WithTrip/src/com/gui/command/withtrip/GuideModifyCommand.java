package com.gui.command.withtrip;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bcommand.withtrip.BCommand;
import com.gui.dao.withtrip.GuideDAO;
import com.gui.dto.withtrip.GuideDTO;

public class GuideModifyCommand implements BCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Enter - GuideModifyCom");
		String email = request.getParameter("email");
		
		GuideDAO dao = new GuideDAO();
		GuideDTO dto = dao.GuideModify(email);
		if (dto!=null) {
			System.out.println("not null");
			request.setAttribute("GuideModify", dto);
			
		}else {			
			try {
				System.out.println("null");
				response.setCharacterEncoding("UTF-8");
				PrintWriter out = response.getWriter();
				
				out.print("<html>");
				out.print("<head>");
				out.print("<script>");
				out.print("<alert('등록된 가이드 글이 없습니다.')>");
				out.print("location.href='index.jsp';");
				out.print("</script>");
				out.print("</head>");
				out.print("</html>");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
