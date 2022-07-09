package com.githrd.www.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import com.githrd.www.dao.*;
import com.githrd.www.vo.*;

@Controller
@RequestMapping("/cate")
public class Product {
	@Autowired
	ProductDao pDao;
	
	@RequestMapping("/product.blp")
	public ModelAndView productMain(ModelAndView mv, ProductVO pVO) {
		List<ProductVO> list = pDao.getCateList(pVO);
		
		// 데이터 심고
		mv.addObject("LIST", list);
		// 뷰 부르고
		mv.setViewName("cate/product");
		return mv;
	}
	
	@RequestMapping("/cateList.blp")
	@ResponseBody
	public List<ProductVO> cateList(ProductVO pVO){
		List<ProductVO> list = pDao.getCateList(pVO);
		return list;
	}
	
	// 상품 리스트 요청 전담 처리함수
	@RequestMapping("/productList.blp")
	@ResponseBody
	public List<ProductVO> productList(ProductVO pVO){
//		List<ProductVO> list = pDao.getProductList(pVO);
		return pDao.getProductList(pVO);
	}
}