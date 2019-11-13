package com.ajax.test.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ajax.test.service.BoardService;
import com.ajax.test.service.Impl.BoardServiceImpl;
import com.google.gson.Gson;

@WebServlet(name = "/BoardController", urlPatterns = { "/ajax/board/*", "/jsp/board/*"}, loadOnStartup = 1)



public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService bs = new BoardServiceImpl();
	private Gson g = new Gson();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	//	String kind = request.getRequestURI().substring(1, 4); // 'aja'
		response.setContentType("application/json;charset=utf-8");
		PrintWriter pw = response.getWriter();
		String cmd = request.getParameter("cmd");
		
		if ("list".equals(cmd)) {
			List<Map<String, String>> boardList = bs.selectBoardList(null); // board넣어도 됨
			pw.print(g.toJson(boardList));	
		//	String json = g.toJson(boardList);
		//	response.getWriter().print(json); // 해당 제이슨으로 응답
		//	return;
		} else if("view".equals(cmd)) {
			Map<String,String> param = new HashMap<>();
			param.put("biNum", request.getParameter("biNum"));
			Map<String,String> board = bs.selectBoard(param);
		//	String json = g.toJson(board);
			System.out.println(board);
			pw.print(g.toJson(board));
			
		}
		return;
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BufferedReader br = request.getReader(); // 버퍼된리더를 받아옴
		String str = null;
		String json = "";
		while ((str = br.readLine()) != null) { // 끝이안보일때까지 동작해라
			json += str;
			// System.out.println(str);
		}
		Map<String, String> board = g.fromJson(json, Map.class);
//		System.out.println(board); 

		response.setContentType("application/json;charset=utf-8");
		json = g.toJson(bs.insertBoard(board));
		response.getWriter().print(json);
		// doGet(request, response);
	}
	

}
