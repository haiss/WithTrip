package com.mem.dao.withtrip;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.mem.dto.withtrip.MemDTO;

public class MemDAO {
	
	DataSource ds =null;
	Connection con = null;
	PreparedStatement ps = null;
	
	public MemDAO() {
		System.out.println("Enter - MemDAO");
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
	
	//회원가입
	public void Join(String email, String pw, String name, String country, String city, String sex, String[] hobby){
		connect();
		System.out.println("Enter - MemJoin");
		int rs;
		
		char[] hb = {'0','0','0','0'};
		String lists[] = {"movie","game","book","sport"};
		for(int i = 0; i < hobby.length ; i++){
			for (int j = 0; j < lists.length; j++) {
				if(hobby[i].equals(lists[j]))
					hb[j]='1';
			}
		}
		
//		String hb="";
//		for (int i = 0; i < hobby.length; i++) {
//			hb = hb+hobby[i]+";";
//		}
		
		try {
			String query = "insert into member(email, pw, name, country, city, sex, hobby) values(?,?,?,?,?,?,?)";
			ps = con.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, pw);
			ps.setString(3, name);
			ps.setString(4, country);
			ps.setString(5, city);
			ps.setString(6, sex);
			ps.setString(7, new String(hb));
			//ps.setString(7, hb);
			
			rs = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			}
			disconnect();
		}
	
	//로그인
	public MemDTO Login(String email, String pw){
		connect();
		System.out.println("Enter - MemLogin");
		
		MemDTO dto = new MemDTO();
		
		String query="select * from member where email=? and pw=?";
		
		try {
			ps = con.prepareStatement(query);
			
			ps.setString(1, email);
			ps.setString(2, pw);
			
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			
			dto.setEmail(rs.getString("email"));
			dto.setPw(rs.getString("pw"));
			dto.setName(rs.getString("name"));
			dto.setEmail(rs.getString("email"));
			dto.setPw(rs.getString("pw"));
			dto.setName(rs.getString("name"));
			dto.setCountry(rs.getString("country"));
			dto.setCity(rs.getString("city"));
			dto.setSex(rs.getString("sex"));
			dto.setHobby(rs.getString("hobby"));
			
			
			String ex = dto.getHobby();
			System.out.println(ex);
			
			//취미를 배열로 담음
/*			String hobbys[]=new String[5];
			String hobby = rs.getString("hobby");
			for (int i = 0; i < hobbys.length; i++) {
				hobbys[i] = hobby.substring(i, i+1);
			}
			*/
			//dto.setHobby(hobbys);
			
			rs.close();

			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return dto;
	}//Login
	
	//회원정보수정
	public void MemModify(String email, String pw, String name, String country, String city, String sex, String[] hobby){
		connect();
		System.out.println("Enter - MemModify");
		
		System.out.println(email+pw);
	
		int rs;
		
		char[] hb = {'0','0','0','0'};
		String lists[] = {"movie","game","book","sport"};
		for(int i = 0; i < hobby.length ; i++){
			for (int j = 0; j < lists.length; j++) {
				if(hobby[i].equals(lists[j]))
					hb[j]='1';
			}
		}
		
		
		try {
			String query="update member set pw=?,name=?,country=?,city=?,sex=?,hobby=? where email = ?";
			
			ps = con.prepareStatement(query);
			
			ps.setString(1, pw);
			ps.setString(2, name);
			ps.setString(3, country);
			ps.setString(4, city);
			ps.setString(5, sex);
			ps.setString(6, new String(hb));
			ps.setString(7, email);
			//ps.setString(7, hb);
			
			rs = ps.executeUpdate();
			
			/*
			ps = con.prepareStatement(query);
			
			ps.setString(1, email);
			ps.setString(2, pw);
			
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			
			dto.setEmail(rs.getString("email"));
			dto.setPw(rs.getString("pw"));
			dto.setName(rs.getString("name"));
			dto.setCountry(rs.getString("country"));
			dto.setCity(rs.getString("city"));
			dto.setSex(rs.getString("sex"));
			dto.setHobby(rs.getString("hobby"));
	

			rs.close();*/
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	
	}
	
}//memdao.class
