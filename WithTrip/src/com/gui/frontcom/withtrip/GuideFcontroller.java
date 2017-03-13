package com.gui.frontcom.withtrip;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bcommand.withtrip.BCommand;
import com.gui.command.withtrip.GuideContenViewCommand;
import com.gui.command.withtrip.GuideListCommand;
import com.gui.command.withtrip.WriteCommand;
import com.mem.command.withtrip.JoinCommand;
import com.mem.command.withtrip.LoginCommand;

/**
 * Servlet implementation class GuideFcontroller
 */
@WebServlet("*.gu")
public class GuideFcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuideFcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ActionGu(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ActionGu(request, response);
	}
	protected void ActionGu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Enter - GuideFrontCon");
		
		request.setCharacterEncoding("UTF-8");
		
		String viewpage=null;
		BCommand command = null;
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		
		if (com.equals("/write.gu")) {
			command = new WriteCommand();
			command.execute(request, response);
			viewpage = "guidelist.gu";
		}else if(com.equals("/guidelist.gu")){
			command = new GuideListCommand();
			command.execute(request, response);
			viewpage="GuideView.jsp";
		}else if (com.equals("/guidecontent.gu")) {
			command = new GuideContenViewCommand();
			command.execute(request, response);
			viewpage="GuideContent.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewpage);
		dispatcher.forward(request, response);
		
	}//ActionGu
	
}//GuideFcontroller
