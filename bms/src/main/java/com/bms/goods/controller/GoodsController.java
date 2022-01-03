package com.bms.goods.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bms.goods.service.GoodsService;

@Controller
@RequestMapping("/goods")
public class GoodsController {
	
	@Autowired
	private GoodsService goodsService;

	
	@RequestMapping(value="/goodsDetail.do" , method = RequestMethod.GET)
	public ModelAndView goodsDetail(@RequestParam("goodsId") String goodsId) throws Exception {
		
		Map<String,Object> goodsMap = goodsService.goodsDetail(goodsId);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/goods/goodsDetail");		// mv.setViewName: 페이지 이동값 세팅
		mv.addObject("goodsMap", goodsMap); 		// mv.addObject: 데이터 추가
		
		return mv;
		
	}
	
	
	@RequestMapping(value="/searchGoods.do" , method = RequestMethod.GET)
	public ModelAndView searchGoods(@RequestParam("searchWord") String searchWord) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/goods/searchGoods");
		mv.addObject("goodsList", goodsService.searchGoods(searchWord));
		
		return mv;
		
	}
	
	@RequestMapping(value= "/goodsBestSeller.do" , method = RequestMethod.GET)
	public ModelAndView goodsBestSeller(HttpServletRequest request) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/goods/goodsBestSeller");
		
		HttpSession session = request.getSession();
		session.setAttribute("sideMenu", "user");
		
		List<Map<String, Object>> bestseller   = goodsService.listGoods("bestseller");
		
		mv.addObject("bestseller" , bestseller);
		
		return mv;
	}
	
	@RequestMapping(value= "/goodsNewBook.do" , method = RequestMethod.GET)
	public ModelAndView goodsNewBook(HttpServletRequest request) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/goods/goodsNewBook");
		
		HttpSession session = request.getSession();
		session.setAttribute("sideMenu", "user");
		
		List<Map<String, Object>> newbook      = goodsService.listGoods("newbook");
	
		mv.addObject("newbook" , newbook);
		
		return mv;
	}
	
	@RequestMapping(value= "/goodsSteadySeller.do" , method = RequestMethod.GET)
	public ModelAndView goodsSteadySeller(HttpServletRequest request) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/goods/goodsSteadySeller");
		
		HttpSession session = request.getSession();
		session.setAttribute("sideMenu", "user");
		
		List<Map<String, Object>> steadyseller = goodsService.listGoods("steadyseller");
		
		mv.addObject("steadyseller" , steadyseller);
		
		return mv;
	}
		
}
