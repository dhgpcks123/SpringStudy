package com.increpas.cls.dao;

import java.util.*;

import org.mybatis.spring.*;
import org.springframework.beans.factory.annotation.*;

import com.increpas.cls.util.*;
import com.increpas.cls.vo.*;

public class ReBoardDao1 {

	@Autowired
	SqlSessionTemplate sqlSession;
	
	// 총 게시글 수 조회 전담 처리함수
	public int getTotal() {
		return sqlSession.selectOne("reSQL.getTotal");
	}
	
	// 게시글 리스트 조회 전담 처리함수
	public List<ReBoardVO> getList(PageUtil page){
		return sqlSession.selectList("reSQL.getList", page);
	}
	
	// 회원 아바타 조회 전담 처리함수
	public String getAvatar(String id) {
		return sqlSession.selectOne("reSQL.getAvatar", id);
	}

	// 게시글 삭제 전담 처리함수 (댓글 포함)
	public int delReBoard(int bno) {
		return sqlSession.update("reSQL.delReBoard", bno);
	}
}
