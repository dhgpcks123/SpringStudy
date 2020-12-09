package com.increpas.cls.dao;

import java.util.*;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.*;

import com.increpas.cls.util.PageUtil;
import com.increpas.cls.vo.*;

public class ReBoardDao {
	@Autowired
	SqlSessionTemplate sqlSession;
	

	//더미데이터 넣기 처리함수
	@Transactional
	public int initRBD(ReBoardVO rVO) {
		return sqlSession.insert("rSQL.initRBD", rVO);
	}
	public int initRBDList(ArrayList<ReBoardVO> list) {
		int cnt = 0;
		for(ReBoardVO rVO : list) {
			cnt += initRBD(rVO);
		}
		return cnt;
	}
	
	// 글 목록 리스트 가져오기
	public List<ReBoardVO> reBoardList(ReBoardVO rVO) {
		return sqlSession.selectList("rSQL.reBoardList", rVO);
	}
	
	//게시물 총 갯수 구해주기
	public int totoalCount() {
		return sqlSession.selectOne("rSQL.totalCount");
	}
	
	//아바타 구해오기
	public String getAvtImg(String id) {
		return sqlSession.selectOne("rSQL.getAvtImg", id);
	}
	
	//원글 쓰기 처리요청
	public int reBoardWriteProc(ReBoardVO rVO) {
		return sqlSession.insert("rSQL.reBoardWriteProc", rVO);
	}
	
	//게시판 글삭제 요청
	public int reBoardDelProc(ReBoardVO rVO) {
		return sqlSession.update("rSQL.reBoardDelProc", rVO);
	}
	
	//게시글 글수정 처리 요청
	public int reBoardEditProc(ReBoardVO rVO) {
		return sqlSession.update("rSQL.reBoardEditProc", rVO);
	}
	
	//댓글게시판 입력요청
	public int reBoardCommentProc(ReBoardVO rVO) {
		return sqlSession.insert("rSQL.reBoardCommentProc", rVO);
		
	}

}
