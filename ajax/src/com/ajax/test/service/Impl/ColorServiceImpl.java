package com.ajax.test.service.Impl;

import java.util.List;
import java.util.Map;

import com.ajax.test.dao.ColorDAO;
import com.ajax.test.dao.Impl.ColorDAOImpl;
import com.ajax.test.service.ColorService;

public class ColorServiceImpl implements ColorService {
	
	ColorDAO cdao = new ColorDAOImpl();
	
	@Override
	public List<Map<String, String>> getColorList(Map<String, String> color) {
		
		return cdao.selectColorList(color);
	}
	
	public static void main(String[] args) {
		ColorService cs = new ColorServiceImpl();
		System.out.println(cs.getColorList(null));
	}

}
