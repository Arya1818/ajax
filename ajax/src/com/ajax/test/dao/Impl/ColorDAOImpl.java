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

		try {

			String sql = "select * from color";
			if (color.get("id") != null) {
				sql += " where c_name like ? order by c_num desc";
				ps = con.prepareStatement(sql);
				ps.setString(1, "%" + color.get("id") + "%");
			} else {
				sql += " order by c_num desc";
				ps = con.prepareStatement(sql);
			}

			rs = ps.executeQuery();

			List<Map<String, String>> colorList = new ArrayList<>();
			while (rs.next()) {
				Map<String, String> map = new HashMap<>();
				map.put("cNum", rs.getString("c_num"));
				map.put("cName", rs.getString("c_name"));
				colorList.add(map);
			}
			return colorList;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}

		return null;
	}

	public static void main(String[] args) {
		ColorDAO cdao = new ColorDAOImpl();
		System.out.println(cdao.selectColorList(null));
	}

}
