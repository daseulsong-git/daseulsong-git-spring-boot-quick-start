package com.rubypaper.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import com.rubypaper.persistence.BoardDAO;

@Service
public class BoardService implements ApplicationRunner {
	
	@Autowired
	private BoardDAO boardDAO;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Map<String, Object> board = new HashMap<String, Object>();
		board.put("TITLE", "스프링으로 글 등록 처리");
		board.put("WRITER", "테스터");
		board.put("CONTENT", "스프링으로 글 등록 테스트합니다.");
		boardDAO.insertBoard(board);
		
		List<Map<String, Object>> boardList = boardDAO.getBoardList();
		for (Map<String, Object> row : boardList) {
			System.out.println("---> " + row.toString());
		}
	}

}







