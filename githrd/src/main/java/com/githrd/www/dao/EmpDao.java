package com.githrd.www.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.githrd.www.vo.EmpVO;

public class EmpDao {
	@Autowired
	SqlSessionTemplate sqlSession;
	
	// 분류리스트 조회 전담 처리 함수
	public List<EmpVO> selList(EmpVO eVO) {
		return sqlSession.selectList("eSQL.selList", eVO);
	}
	
	
	// 분류별 직원리스트 조회 전담처리 함수
	public List<EmpVO> partList(EmpVO eVO){
		return sqlSession.selectList("eSQL.partList", eVO);
	}
}