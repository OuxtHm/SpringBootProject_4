package com.sist.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sist.web.mapper.*;
import com.sist.web.vo.BoardVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
	private final BoardMapper mapper;
	
	@Override
	public List<BoardVO> boardListData(int start) {
		return mapper.boardListData(start);
	}
	@Override
	public int boardTotalPage() {
		return mapper.boardTotalPage();
	}

	@Override
	public void boardInsert(BoardVO vo) {
		mapper.boardInsert(vo);		
	}
	
	@Override
	public BoardVO boardDetailData(int no) {
		mapper.updateHitIncrement(no);
		return mapper.boardDetailData(no);
	}  
}
