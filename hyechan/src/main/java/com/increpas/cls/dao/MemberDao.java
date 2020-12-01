package com.increpas.cls.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.increpas.cls.vo.MemberVO;

public class MemberDao {
	
	@Autowired
	SqlSessionTemplate sqlSession;
	public int loginCnt(MemberVO mVO) {
		return sqlSession.selectOne("mSQL.login", mVO);
//		selectOne은 mybatise에 정의 된 함수임
// SqlSessinTemplate기억나? root-context에서 본 것 같지않아?
// db작업은 mybatis가 해주는거야~
	}
}
