package com.increpas.cls.dao;

import java.util.*;

import org.mybatis.spring.*;
import org.springframework.beans.factory.annotation.*;

import com.increpas.cls.vo.*;

public class GBoardDao {
	
	@Autowired
	SqlSessionTemplate sqlSession;
	
	// 방명록 총 갯수 가져오기 전담 처리함수
	public int getTotal() {
		return sqlSession.selectOne("gSQL.getTotal");
	}
	
	// 방명록 리스트 가져오기 전담 처리함수
	public List<GBoardVO> getList(GBoardVO gVO) {
		return sqlSession.selectList("gSQL.getList", gVO);
	}
	
	// 사용자 아바타조회 전담 처리함수
	public String getAvatar(String id) {
		return sqlSession.selectOne("gSQL.getAvatar", id);
	}
	
	// 방명록 등록 전담 처리함수
	public int writeBoard(GBoardVO gVO) {
		System.out.println("### dao id : " + gVO.getId());
		System.out.println("### dao body : " + gVO.getBody());
		return sqlSession.insert("gSQL.writeBoard", gVO);
	}
}
