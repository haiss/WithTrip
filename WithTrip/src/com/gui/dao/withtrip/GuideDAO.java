package com.gui.dao.withtrip;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
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
	
	public void GuideRequest(String name, String pw, String title, String country, String city, String language, int cost, String content) {
		connect();
		System.out.println("Enter - GuideRequest");
		System.out.println("in GuideRequest");
		
		
		try {
			String query = "insert into guide (name, pw, title, country, city, language, cost, content) values (?,?,?,?,?,?,?,?)";
			ps = con.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, pw);
			ps.setString(3, title);
			ps.setString(4, country);
			ps.setString(5, city);
			ps.setString(6, language);
			ps.setInt(7, cost);
			ps.setString(8, content);
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
				
				String name = rs.getString("name");
				String pw = rs.getString("pw");
				String title = rs.getString("title");
				String country = rs.getString("country");
				String city = rs.getString("city");
				String language = rs.getString("language");
				String content = rs.getString("content");
				int cost = rs.getInt("cost");
				
				GuideDTO dto = new GuideDTO(name, pw, title, country, city, language, content, cost);
				dtos.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		
		return dtos;	
	}//GuideView-method
	
	public GuideDTO GuideContent(){
		
		GuideDTO dto = null;
		ResultSet rs = null;
		
		connect();
		System.out.println("In GuideContent");
		
		try {
			String query = "select * from guide where "
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}//GuideDAO
