package com.gui.dao.withtrip;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.jsp.PageContext;
import javax.sql.DataSource;

import com.gui.dto.withtrip.GuideDTO;

public class GuideDAO {
	DataSource ds =null;
	Connection con = null;
	PreparedStatement ps = null;
	
	public GuideDAO() {
		System.out.println("Enter - GuideDAO");
		Context ctx;
		try {
			ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/mysql");
			
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
	}//memdao.method
	void connect(){
		try {

			con=ds.getConnection();
			System.out.println("connect ok");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("connect fail");
		}
	}//con
	
	void disconnect(){	
		try{
			if(ps!=null)ps.close();
			if(con!=null)con.close();
		}catch (SQLException e) {	
			e.printStackTrace();
		}
	}//discon
	
	public void GuideRequest(String name, String pw, String title, String country, String city, String language, int cost, String content, String listimg) {
		connect();
		System.out.println("Enter - GuideRequest");
		System.out.println("in GuideRequest");
		System.out.println(listimg);
		
		try {
			String query = "insert into guide (name, pw, title, country, city, language, cost, content, listimg) values (?,?,?,?,?,?,?,?,?)";
			ps = con.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, pw);
			ps.setString(3, title);
			ps.setString(4, country);
			ps.setString(5, city);
			ps.setString(6, language);
			ps.setInt(7, cost);
			ps.setString(8, content);
			ps.setString(9, listimg);
			int rs = ps.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			disconnect();
		}
	}//GuideReq.method
	
	public ArrayList<GuideDTO> GuideView() {
		connect();
		System.out.println("in GuideView");
		ArrayList<GuideDTO> dtos = new ArrayList<GuideDTO>();
		ResultSet rs = null;
		
		try {
			String query = "select * from guide order by id desc";
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				String email = rs.getString("email");
				String name = rs.getString("name");
				String pw = rs.getString("pw");
				String title = rs.getString("title");
				String country = rs.getString("country");
				String city = rs.getString("city");
				String language = rs.getString("language");
				String content = rs.getString("content");
				String listimg = rs.getString("listimg");
				int cost = rs.getInt("cost");
				int id = rs.getInt("id");
				
				System.out.println(id);
				GuideDTO dto = new GuideDTO(email, name, pw, title, country, city, language, content, cost, id, listimg);
				dtos.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		
		return dtos;	
	}//GuideView-method
	
	public GuideDTO GuideContent(String id){
		
		GuideDTO dto = null;
		ResultSet rs = null;
		
		connect();
		System.out.println("In GuideContent");
		
		try {
			String query = "select * from guide where id=?";
			ps = con.prepareStatement(query);
			ps.setInt(1, Integer.parseInt(id));
			rs = ps.executeQuery();
			
			if (rs.next()) {
				String name = rs.getString("name");
				String pw = rs.getString("pw");
				String title = rs.getString("title");
				String country = rs.getString("country");
				String city = rs.getString("city");
				String language = rs.getString("language");
				String content = rs.getString("content");
				int cost = rs.getInt("cost");
				int sid = rs.getInt("id");
				
				dto = new GuideDTO(name, pw, title, country, city, language, content, cost, sid);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
				
			}
			disconnect();
		}
		return dto;
	}//GuideContent
	
	public GuideDTO GuideModify(String email) {
		GuideDTO dto = null;
		ResultSet rs = null;
		
		connect();
		System.out.println("Enter - GuideModify");
		
		try {
			String query = "select * from guide where email=?";
			ps = con.prepareStatement(query);
			ps.setString(1, email);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				String semail = rs.getString("email");
				String name = rs.getString("name");
				String pw = rs.getString("pw");
				String title = rs.getString("title");
				String country = rs.getString("country");
				String city = rs.getString("city");
				String language = rs.getString("language");
				String content = rs.getString("content");
				int cost = rs.getInt("cost");
				int sid = rs.getInt("id");
				String listimg = rs.getString("listimg");
				
				dto = new GuideDTO(semail, name, pw, title, country, city, language, content, cost, sid, listimg);
			}else {
				return dto;				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			disconnect();
		}
		return dto;		
	}
	
}//GuideDAO
