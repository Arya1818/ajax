package com.ajax.test.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ajax.test.common.DBCon;
import com.ajax.test.dao.BoardDAO;

public class BoardDAOImpl implements BoardDAO {

	@Override
	public Map<String, String> selectBoard(Map<String, String> board) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = DBCon.getCon();
			String sql = "select * from board_info where bi_num=?";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, board.get("biNum"));
			rs = ps.executeQuery();
			
			if(rs.next()) { //bi_num pk이니까? 중복될일 없으니까 if문으로?
				Map<String,String> b = new HashMap<>();
				b.put("biNum", rs.getString("bi_num"));
				b.put("biTitle", rs.getString("bi_title"));
				b.put("biContent", rs.getString("bi_content"));
				b.put("uiNum", rs.getString("ui_num"));
				b.put("credat", rs.getString("credat"));
				b.put("cretim", rs.getString("cretim"));
				b.put("moddat", rs.getString("moddat"));
				b.put("modtim", rs.getString("modtim"));
		
				return b;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				
				if(con!=null) {
					con.close();
				}
			}catch(SQLException e) {
				
			}
			
		}
		return null;
	}

	@Override
	public List<Map<String, String>> selectBoardList(Map<String, String> board) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = DBCon.getCon();
			String sql = "select * from board_info order by bi_num desc";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			List<Map<String,String>> boardList = new ArrayList<>();
			while(rs.next()) {
				Map<String,String> b = new HashMap<>();
				b.put("biNum", rs.getString("bi_num"));
				b.put("biTitle", rs.getString("bi_title"));
				b.put("credat", rs.getString("credat"));
				b.put("cretim", rs.getString("cretim"));
				
				boardList.add(b);
			}
			return boardList;
		}catch(SQLException e) {
			
		}finally {
			try {
				if(con!=null) {
					con.close();
				}
				if(ps!=null) {
					con.close();
				}
				if(rs!=null) {
					con.close();
				}
			}catch(SQLException e) {
				
			}
			
		}
		return null;
	}

	@Override
	public int insertBoard(Map<String, String> board) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = DBCon.getCon();
			String sql = "insert into board_info(BI_NUM, BI_TITLE, BI_CONTENT, UI_NUM, CREDAT, CRETIM, MODDAT, MODTIM)";
			sql += "values(seq_bi_num.nextval,?,?,?,to_char(sysdate,'yyyymmdd'),to_char(sysdate,'hh24miss'),to_char(sysdate,'yyyymmdd'),to_char(sysdate,'hh24miss'))";
			ps = con.prepareStatement(sql);
			ps.setString(1, board.get("biTitle"));
			ps.setString(2, board.get("biContent"));
			ps.setString(3, board.get("uiNum"));
			
			int result = ps.executeUpdate();
			
			return result;
			 
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(con!=null) {
					con.close();
				}
				if(ps!=null) {
					con.close();
				}
				
			}catch(SQLException e) {
				
			}
			
		}
	
		return 0;
	}

	@Override
	public int updateBoard(Map<String, String> board) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBoard(Map<String, String> board) {
		// TODO Auto-generated method stub
		return 0;
	}
	public static void main(String[] args) { //찍어보기
		BoardDAO bdao = new BoardDAOImpl();
		System.out.println(bdao.selectBoardList(null));
	}
}
