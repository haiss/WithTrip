package com.mem.frontcom.withtrip;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bcommand.withtrip.BCommand;
import com.mem.command.withtrip.JoinCommand;
import com.mem.command.withtrip.LoginCommand;
import com.mem.command.withtrip.MemModifyCommand;

/**
 * Servlet implementation class MemberFcontroller
 */
@WebServlet("*.mem")
public class MemberFcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberFcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Actionmem(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Actionmem(request, response);
	}
	
	protected void Actionmem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Enter - MemFrontCon");
		
		request.setCharacterEncoding("UTF-8");
		
		String viewpage=null;
		BCommand command = null;
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		
		if (com.equals("/Join.mem")) {
			viewpage = "Join.jsp";
		}else if(com.equals("/JoinOK.mem")){
			command = new JoinCommand();
			command.execute(request, response);
			viewpage="Login.jsp";
		} else if(com.equals("/LoginOK.mem")){
			command = new LoginCommand();
			command.execute(request, response);
			viewpage = "index.jsp";
		}else if(com.equals("/MemModify.mem")){
			command = new MemModifyCommand();
			command.execute(request, response);
			viewpage = "MemModify.jsp";
		}
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewpage);
		dispatcher.forward(request, response);
		
		
	}//actionmem
	
	
}
