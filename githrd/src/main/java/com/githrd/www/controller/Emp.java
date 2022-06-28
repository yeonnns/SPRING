package com.githrd.www.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.githrd.www.dao.EmpDao;
import com.githrd.www.vo.EmpVO;

@Controller
@RequestMapping("/emp")
public class Emp {
	@Autowired
	EmpDao eDao;
	// 사원 페이지 폼보기 요청 처리 함수
	@RequestMapping("/empPage.blp")
	public ModelAndView empPage(ModelAndView mv) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("부 서");
		list.add("직 급");
		
		// 데이터 전달하고
		mv.addObject("LIST", list);
		mv.setViewName("emp/empPage");
		return mv;
	}

	// 분류 리스트 요청 처리 함수
	@RequestMapping("/selList.blp")
	@ResponseBody
	public List<EmpVO> selList(EmpVO eVO) {
		List<EmpVO> list = 	eDao.selList(eVO);
		return list;
	}

	// 분류별 사원 리스트 요청 처리 함수
	@RequestMapping("/partList.blp")
	@ResponseBody
	public List<EmpVO> partList(EmpVO eVO) {
		List<EmpVO> list = 	eDao.partList(eVO);
		return list;
	}
}
