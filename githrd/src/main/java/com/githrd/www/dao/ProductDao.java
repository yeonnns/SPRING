package com.githrd.www.dao;

import java.util.*;

import org.mybatis.spring.*;
import org.springframework.beans.factory.annotation.*;

import com.githrd.www.vo.*;

public class ProductDao {
	@Autowired
	SqlSessionTemplate sqlSession;
	
	public List<ProductVO> getCateList(){
		return sqlSession.selectList("pSQL.startCate");
	}
	
	public List<ProductVO> getCateList(ProductVO pVO){
		return sqlSession.selectList("pSQL.cateList", pVO);
	}
	
	// 상품 리스트 조회 전담 처리함수
	public List<ProductVO> getProductList(ProductVO pVO){
		return sqlSession.selectList("pSQL.pList", pVO);
	}
}