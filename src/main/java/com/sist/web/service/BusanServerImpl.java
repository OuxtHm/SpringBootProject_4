package com.sist.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import com.sist.web.SpringBootProject4Application;
import com.sist.web.mapper.*;
import com.sist.web.vo.BusanVO;
import com.sist.web.vo.FoodVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BusanServerImpl implements BusanService{

    private final SpringBootProject4Application springBootProject4Application;
	private final BusanMapper mapper;
	private final FoodMapper fMapper;

	@Override
	public List<BusanVO> busanListData(Map map) {
		return mapper.busanListData(map);
	}
	@Override
	public int busanTotalPage(Map map) {
		return mapper.busanTotalPage(map);
	}
	@Override
	public BusanVO busan_detail(int no) {
		mapper.busanHitIncrement(no);
		return mapper.busan_detail(no);
	}
	
	@Override
	public List<FoodVO> foodNearData4(String address) {
		return fMapper.foodNearData4(address);
	}
}
