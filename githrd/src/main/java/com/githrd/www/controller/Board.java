package com.githrd.www.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.githrd.www.dao.BoardDao;
import com.githrd.www.util.PageUtil;
import com.githrd.www.vo.BoardVO;
import com.githrd.www.vo.FileVO;


/**
 * 이 클래스는 파일 게시판에 관련된 요청을 처리할 컨트롤러 클래스
 * @author 김소연
 * since 2022.06.17
 * @version v.1.0
 * 
 * 			작업이력 ]
 * 				2022.06.17 - 담당자 : 김소연
 * 							클래스 제작
 * 							1) 게시글 리스트 보기 요청 처리 함수 제작
*/
@Controller
@RequestMapping("/board")
public class Board {
	@Autowired
	BoardDao bDao;
	
		@RequestMapping("/boardList.blp")
		public ModelAndView boardList(ModelAndView mv, PageUtil page) {
			// 1. 총 게시글 수 가져오기
			int total = bDao.getTotal();
			// 2. 해당 페이지의 페이지 정보 만들고
			page.setPage(total);
			// 3. 해당 페이지의 글 목록 가져오고
			List<BoardVO> list = bDao.getList(page);
			// 4. 데이터 심고
			mv.addObject("LIST", list);
			mv.addObject("PAGE", page);
			// 5. 뷰 브르고
			mv.setViewName("board/boardList");
			// 6. mv 반환하고
			return mv;
		}
		
		// 게시글 상세보기 요청 처리 함수
		
		@RequestMapping(path="/boardDetail.blp",
						method=RequestMethod.POST, params={"bno", "nowPage"})
		public ModelAndView boardDetail(ModelAndView mv, BoardVO bVO) {
			// 첨부파일 리스트 조회
			List<FileVO> list = bDao.getFileList(bVO.getBno());
			bVO = bDao.getDetail(bVO.getBno());
			
			mv.addObject("DATA", bVO);
			mv.addObject("List", list);
			
			// 뷰정하고
			mv.setViewName("board/boardDetail");
			return mv;
		}

}
