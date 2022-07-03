package com.githrd.www.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.githrd.www.dao.SingDao;
import com.githrd.www.vo.SingVO;

@Controller
@RequestMapping("/singer")
public class Singer {
	@Autowired
	SingDao siDao;
	@RequestMapping("/singer.blp")
	public ModelAndView singer(ModelAndView mv) {
		mv.setViewName("singer/singer");
		return mv;
	}
	// 가수 선택
	@RequestMapping("/singList.blp")
	@ResponseBody
	public List<SingVO> singList(SingVO siVO) {
		List<SingVO> list = siDao.singList(siVO);
		return list;
	}
	// 멤버 선택
	@RequestMapping("/singMemb.blp")
	@ResponseBody
	public List<SingVO> singMemb(SingVO siVO) {
		List<SingVO> list = siDao.singMemb(siVO);
		return list;
	}
}