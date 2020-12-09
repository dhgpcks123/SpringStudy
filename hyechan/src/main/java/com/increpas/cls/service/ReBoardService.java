package com.increpas.cls.service;

import java.util.*;

import com.increpas.cls.vo.ReBoardVO;

public class ReBoardService {

	public ArrayList<ReBoardVO> list;
	
	public ReBoardService(){
		list = getRVO();
	};
	
	//ReBoardVO를 만들고 값을 채워준다.
	public ArrayList<ReBoardVO> getRVO(){
		ArrayList<ReBoardVO> list = new ArrayList<ReBoardVO>();
		ArrayList<String> idList = getId();
		for(int i = 0 ; i < idList.size(); i++) {
			ReBoardVO rVO = new ReBoardVO();
			rVO.setId(idList.get(i));
			rVO.setBody(idList.get(i)+"님이"+(i+1)+"번쨰 글을 썼습니다");
			
			list.add(rVO);
		}
		
		return list;
	}
	
	
	//회원 아이디를 반환해주는 함수
	public ArrayList<String> getId() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("hh");
		list.add("jiwoo");
		list.add("seok");
		list.add("dhgpcks");
		list.add("euns");
		list.add("dooly");
		list.add("joo");
		
		return list;
	}
}
