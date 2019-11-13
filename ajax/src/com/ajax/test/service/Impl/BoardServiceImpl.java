package com.ajax.test.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ajax.test.dao.BoardDAO;
import com.ajax.test.dao.Impl.BoardDAOImpl;
import com.ajax.test.service.BoardService;

public class BoardServiceImpl implements BoardService {
	
	private BoardDAO bdao = new BoardDAOImpl();

	@Override
	public Map<String, String> selectBoard(Map<String, String> board) {
		
		return bdao.selectBoard(board);
	}

	@Override
	public List<Map<String, String>> selectBoardList(Map<String, String> board) {
		
		return bdao.selectBoardList(board);
	}

	@Override
	public Map<String, String> insertBoard(Map<String, String> board) {
		
		Map<String,String> rMap = new HashMap<>(); //여기서는 
		int result = bdao.insertBoard(board);
		if(result==1) {
			rMap.put("msg","저장성공");
		}else {
			rMap.put("msg", "저장실패");
		}
		
		return rMap;
	}

	@Override
	public Map<String, String> updateBoard(Map<String, String> board) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> deleteBoard(Map<String, String> board) {
		// TODO Auto-generated method stub
		return null;
	}

}
