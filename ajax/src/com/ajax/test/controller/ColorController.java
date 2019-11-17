package com.ajax.test.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ajax.test.service.ColorService;
import com.ajax.test.service.Impl.ColorServiceImpl;
import com.google.gson.Gson;


@WebServlet(name="ColorController", urlPatterns= {"/color/*"})
public class ColorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ColorService cs = new ColorServiceImpl();
	private Gson g = new Gson();

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		Map<String,String> color = new HashMap<>();
		color.put("id",request.getParameter("id"));
		String json = g.toJson(cs.getColorList(color));

		out.print(json);
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
