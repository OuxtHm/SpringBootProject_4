package com.sist.web.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.sist.web.vo.SeoulVO;

@Mapper
@Repository
public interface SeoulMapper {
	
	/*
	<select id="seoulListData" resultType="com.sist.web.vo.SeoulVO" parameterType="hashmap">
		<!-- 
				리턴형 : resultType : VO(1) : selectOne
									 VO(여러개) : selectList
				메소드 : id명과 일치
				매개변수 : parameterType
				
				-> 생성시 아래처럼 일치시켜야 한다
				public List<SeoulVO> seoulListData(Map map);
		 -->  	
  		SELECT no, title, poster, address, hit 
  		FROM ${table_name} 
  		ORDER BY no ASC 
  		OFFSET #{start} ROWS FETCH NEXT 12 ROWS ONLY
  	</select>
  	
  	*/
	public List<SeoulVO> seoulListData(Map map);
	
	/*
  	<select id="seoulTotalPage" resultType="int" parameterType="hashmap">
  		SELECT CEIL(COUNT(*)/10.0) FROM ${table_name}
  	</select>
	*/
	public int seoulTotalPage(Map map);
	
	// => 인터페이스는 서로 다른 클래스 연결 => 모든 변수 / 모든 메소드는 public
	// 1.8 => default 메소드 => 구현된 메소드
	/*
	<select id="seoulDetailData" resultType="com.sist.web.vo.SeroulVO" parameterType="hashmap">
  	SELECT no, title, poster, address, hit 
  	FROM ${table_name} 
  	WHERE no=#{no}
  </select>
	*/
	public SeoulVO seoulDetailData(Map map);
	
	@Update("UPDATE ${table_name} SET hit=hit+1 WHERE no=#{no}")
	public void seoulHitIncrement(Map map);
	
}
