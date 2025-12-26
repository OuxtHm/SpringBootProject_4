package com.sist.web.service;

import java.util.*;

import org.springframework.stereotype.Service;

import com.sist.web.mapper.FoodMapper;
import com.sist.web.mapper.SeoulMapper;
import com.sist.web.vo.FoodVO;
import com.sist.web.vo.SeoulVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SeoulServiceImpl implements SeoulService{
	private final SeoulMapper mapper;
	private final FoodMapper fMapper;
	@Override
	public List<SeoulVO> seoulListData(Map map) {
		return mapper.seoulListData(map);
	}
	
	@Override
	public int seoulTotalPage(Map map) {
		return mapper.seoulTotalPage(map);
	}
	
	@Override
	public SeoulVO seoulDetailData(Map map) {
		mapper.seoulHitIncrement(map);
		return mapper.seoulDetailData(map);
	}
	
	@Override
	public List<FoodVO> foodNearData4(String address) {
		return fMapper.foodNearData4(address);
	}
}
