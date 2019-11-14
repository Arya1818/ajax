package com.ajax.test.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ajax.test.service.AddressService;
import com.ajax.test.service.Impl.AddressServiceImpl;
import com.google.gson.Gson;


@WebServlet(name = "TestController", urlPatterns= {"/test/*"}) //*.test *.do로도 씀
public class TestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  private AddressService as = new AddressServiceImpl();
  
  private Gson g = new Gson();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("applicaton/json;charset=utf-8");
		PrintWriter pw = response.getWriter();
		//pw.print("[\"서울\",\"광주\",\"대전\",\"부산\"]");
		
		pw.print(g.toJson(as.selectSidoList(null))); //조건필요없이 값만가져오면되기때문에 null
		

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
