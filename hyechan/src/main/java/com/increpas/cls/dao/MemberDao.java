package com.increpas.cls.dao;

import java.util.*;
import org.mybatis.spring.*;
import org.springframework.beans.factory.annotation.*;

import com.increpas.cls.vo.*;

public class MemberDao {
	
	@Autowired
	SqlSessionTemplate sqlSession;
	// SqlSessinTemplate기억나? root-context에서 본 것 같지않아?
	// db작업은 mybatis가 해주는거야~

	// 로그인 조회 전담 처리함수
	public int loginCnt(MemberVO mVO) {
		return sqlSession.selectOne("mSQL.login", mVO);
		// selectOne은 mybatise에 정의 된 함수임
		// selectOne 질의결과 한 개 있으면 쓰는 거 selectOne
		// 질의결과 여러개다? selectList
	}
	
	//회원 정보조회 전담처리 함수
	public MemberVO getInfo(String id) {
		return sqlSession.selectOne("mSQL.getInfo", id);
	}
	
	//회원 정보조회 전담처리 함수
	public MemberVO getInfo(int tno) {
		return sqlSession.selectOne("mSQL.getInfoNo", tno);
	}
	
	//회원 정보조회 전담처리함수
	public MemberVO getNameInfo(MemberVO mVO){
		return sqlSession.selectOne("mSQL.nameInfo", mVO);
	}
	
	//회원 탈퇴 전담처리함수
	public int outMember(MemberVO mVO) {
		return sqlSession.update("mSQL.del_memb", mVO);
	}
	
	//회원 이름 리스트 조회 전담처리함수
	public List<MemberVO> getNameList(){
		return sqlSession.selectList("mSQL.nameList");
	}
	
	//아바타 리스트 가져오기 전담 처리함수
	public List<AvatarVO> getAvtList(){
		return sqlSession.selectList("aSQL.getAll");
	}
	
	//회원 아이디체크 전담 처리함수
	public int getIdCnt(String id) {
		return sqlSession.selectOne("mSQL.idCount", id);
	}
	
	//회원 가입 처리 전담 처리함수
	public int insertMember(MemberVO mVO) {
		return sqlSession.insert("mSQL.addMember", mVO);
	}

	//회원 정보 수정 전담 처리함수
	public int editMember(MemberVO mVO) {
		return sqlSession.update("mSQL.editMember", mVO);
	}
	
}
