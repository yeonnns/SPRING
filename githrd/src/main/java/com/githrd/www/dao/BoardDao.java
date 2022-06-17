package com.githrd.www.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.githrd.www.util.PageUtil;
import com.githrd.www.vo.BoardVO;
import com.githrd.www.vo.FileVO;

public class BoardDao {

	@Autowired
	SqlSessionTemplate sqlSession;
	
	// 총 게시글 갯수 조회 전담 처리 함수
	public int getTotal() {
		return sqlSession.selectOne("bSQL.getTotal");
	}
	
	// 게시글 리스트 조회 전담 처리 함수
	public List<BoardVO> getList(PageUtil page){
		return sqlSession.selectList("bSQL.getList", page);
	}
	
	// 게시글 번호로 첨부파일 리스트 조회 전담 처리 함수
	public List<FileVO> getFileList(int bno){
		return sqlSession.selectList("bSQL.fileList", bno);
	}
	
	// 게시글 번호로 게시글 정보 조회 전담 처리 함수
	public BoardVO getDetail(int bno) {
		return sqlSession.selectOne("bSQL.boardDetail", bno);
	}
	
}
