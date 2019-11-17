
package com.ajax.test.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet(name = "TestController2", urlPatterns = { "/test2/*" })
public class TestController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Gson g = new Gson();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<String> strList = new ArrayList<>();
		strList.add("red");
		strList.add("yellow");
		strList.add("green");
		strList.add("blue");
		strList.add("black");

		String id = request.getParameter("id");
		List<String> tmp = new ArrayList<>();
		PrintWriter pw = response.getWriter();

		if (id == null) {
			pw.print(g.toJson(strList));

		} else {
			for (int i = 0; i < strList.size(); i++) {
				if (strList.get(i).indexOf(id) != -1) {
					tmp.add(strList.get(i));
				}

			}
			pw.print(g.toJson(tmp));
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/*
	 * public static void main(String[] args) { 
	 * TestController2 t = new TestController2(); 
	 * System.out.println(t.); 
	 * }
	 */

}
