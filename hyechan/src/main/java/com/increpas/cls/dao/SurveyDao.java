package com.increpas.cls.dao;

import java.util.*;

import org.mybatis.spring.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.transaction.annotation.*;

import com.increpas.cls.vo.SurveyVO;

public class SurveyDao {
	@Autowired
	SqlSessionTemplate sqlSession;
	
	public List<SurveyVO> getCurList(String id){
		return sqlSession.selectList("sSQL.infoList", id);
	}
	
	public List<SurveyVO> getQuestList(int sno){
		return sqlSession.selectList("sSQL.questList", sno);
	}
	public List<SurveyVO> surveyResult(int sno){
		return sqlSession.selectList("sSQL.surveyResult", sno);
	}
	public int addAnswer(SurveyVO sVO) {
		return sqlSession.insert("sSQL.addAnswer", sVO);
	}
	
	@Transactional
	public int addAnswer(ArrayList<SurveyVO> list) {
		int cnt = 0;
		for(SurveyVO sVO: list) {
			cnt += addAnswer(sVO);			
		}
		return cnt;
	}
}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  