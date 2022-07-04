package com.githrd.www.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.githrd.www.vo.SingVO;

public class SingDao {
	@Autowired
	SqlSessionTemplate sqlSession;
	
	// 가수 조회 전담 처리 함수
	public List<SingVO> singList(SingVO siVO){
		return sqlSession.selectList("siSQL.singList", siVO);	
	}
	// 멤버 조회 전담 처리 함수
	public List<SingVO> singMemb(SingVO siVO){
		return sqlSession.selectList("siSQL.singMemb", siVO);	
	}
	// 사진 조회 전담 처리 함수
	public SingVO singImg(SingVO siVO){
		return sqlSession.selectOne("siSQL.singImg", siVO);	
	}
}
