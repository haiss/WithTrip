package com.gui.command.withtrip;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bcommand.withtrip.BCommand;
import com.gui.dao.withtrip.GuideDAO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class WriteCommand implements BCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//request.setCharacterEncoding("UTF-8");			
		MultipartRequest multi = null;
		int filesize = 10 * 1024 * 1024;
		ServletContext context = request.getSession().getServletContext();
		String path = context.getRealPath("listimgfile");
		//ServletContext context = getServletContext();
		//String path = request.getContextPath()+"/listimgfile";
		
		try {
			multi = new MultipartRequest(request, path, filesize, "UTF-8", new DefaultFileRenamePolicy());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String listimg = multi.getFilesystemName("listimg");
		String name = multi.getParameter("name");
		String pw = multi.getParameter("pw");
		String title =  multi.getParameter("title");
		String country = multi.getParameter("country");
		String city = multi.getParameter("city");
		String language = multi.getParameter("language");
		String Scost = multi.getParameter("cost");
		int cost = Integer.parseInt(Scost);
		String content = multi.getParameter("content");
		
		GuideDAO dao = new GuideDAO();
		
		dao.GuideRequest(name, pw, title, country, city, language, cost, content, listimg);
		
	}

}
