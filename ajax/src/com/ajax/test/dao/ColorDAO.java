package com.ajax.test.dao;

import java.util.List;
import java.util.Map;

public interface ColorDAO {
	public List<Map<String,String>> selectColorList(Map<String,String> color);
}
