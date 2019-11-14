package com.ajax.test.service;

import java.util.List;
import java.util.Map;

public interface AddressService { //service에서는 get으로하는게 좀더 자바스러움
	public List<Map<String,String>> selectSidoList(Map<String,String> sido);
	public List<Map<String,String>> selecSido(Map<String,String> sido);

}
