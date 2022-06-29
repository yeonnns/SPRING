package com.githrd.www.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import com.githrd.www.dao.*;
import com.githrd.www.vo.*;

@Controller
@RequestMapping("/emp")
public class Emp {
	@Autowired
	EmpDao eDao;
	
	// 사원 페이지 폼보기 요청 처리함수
	@RequestMapping("/empPage.blp")
	public ModelAndView empPage(ModelAndView mv) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("부 서");
		list.add("직 급");
		
		List<EmpVO> iList = eDao.getIniList();
		// 데이터 전달하고
		mv.addObject("LIST", list);
		mv.addObject("ILIST", iList);
		mv.setViewName("emp/empPage");
		return mv;
	}
	
	// 분류 리스트 요청 처리함수
	@RequestMapping("/selList.blp")
	@ResponseBody
	public List<EmpVO> selList(EmpVO eVO){
		List<EmpVO> list = eDao.selList(eVO);
		return list;
	}
	
	// 분류 리스트 요청 처리함수
	@RequestMapping("/partList.blp")
	@ResponseBody
	public List<EmpVO> partList(EmpVO eVO){
		List<EmpVO> list = eDao.partList(eVO);
		return list;
	}
	
	// 사원 정보 조회 요청 처리함수
	@RequestMapping("/empInfo.blp")
	@ResponseBody
	public EmpVO empInfo(EmpVO eVO) {
		eVO = eDao.getInfo(eVO);
		return eVO;
	}
	
	// 이니셜로 이름 리스트 조회 요청 처리함수
	@RequestMapping("/enameList.blp")
	@ResponseBody
	public List<EmpVO> enameList(EmpVO eVO){
		List<EmpVO> list = eDao.nameList(eVO);
		return list;
	}
	
}