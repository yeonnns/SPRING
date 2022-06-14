package com.githrd.www.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import com.githrd.www.dao.*;
import com.githrd.www.service.*;
import com.githrd.www.vo.*;

@Controller
@RequestMapping("/survey")
public class Survey {
	@Autowired
	SurveyDao sDao;
	@Autowired
	SurveyService sSrvc;
	
	@RequestMapping("/surveyInfo.blp")
	public ModelAndView surveyInfo(ModelAndView mv, SurveyVO sVO) {
		List<SurveyVO> list = sDao.getIngList(sVO.getId());
		List<SurveyVO> old = sDao.getOldList();
		
		// 데이터심고
		mv.addObject("ING", list);
		mv.addObject("OLD", old);
		
		// 뷰 정하고
		mv.setViewName("survey/surveyInfo");
		return mv;
	}
	
	/**
	 * 설문조사 폼보기 요청 처리함수
	 */
	@RequestMapping("/survey.blp")
	public ModelAndView survey(ModelAndView mv, SurveyVO sVO) {
		
//		sSrvc.setBogi(sVO);
		sSrvc.settingList(sVO);
		
		// 데이터 심고
		mv.addObject("DATA", sVO);
		
		// 뷰 설정
		mv.setViewName("survey/survey");
		return mv;
	}
	
	/**
	 * 설문조사 응답 처리 요청 처리함수
	 */
	@RequestMapping("/surveyProc.blp")
	public ModelAndView surveyProc(ModelAndView mv, SurveyVO sVO) {
		/*
		for(int no : sVO.getDap()) {
			System.out.println("qno : " + no);
		}
		*/
		boolean bool = sSrvc.applyTx(sVO);
		
		String view = "/www/survey/surveyResult.blp";
		
		if(!bool) {
			// 실패한 작업이 있는 경우
			view = "/www/survey/survey.blp";
		}
		
		// 데이터심고
		mv.addObject("VIEW", view);
		
		// 뷰 정하고
		mv.setViewName("survey/redirect");
		return mv;
	}
	
	// 설문 결과페이지 폼보기 요청
	@RequestMapping("/surveyResult.blp")
	public ModelAndView surveyResult(ModelAndView mv) {
		mv.setViewName("survey/surveyResult");
		return mv;
	}
}