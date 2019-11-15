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
import com.ajax.test.dao.ColorDAO;

public class ColorDAOImpl implements ColorDAO {

	@Override
	public List<Map<String, String>> selectColorList(Map<String, String> color) {
		Connection con = DBCon.getCon();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "select * from Color";
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			List<Map<String,String>> colorList = new ArrayList<>();
			while(rs.next()) {
			Map<String,String> map = new HashMap<>();
			map.put("cNum", rs.getString("c_num"));
			map.put("cName", rs.getString("c_name"));
			colorList.add(map);
			}
			return colorList;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	public static void main(String[] args) {
		ColorDAO cdao = new ColorDAOImpl();
		System.out.println(cdao.selectColorList(null));
	}
	
}
