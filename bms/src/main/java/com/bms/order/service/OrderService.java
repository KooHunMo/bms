package com.bms.order.service;

import java.util.List;
import java.util.Map;

import com.bms.goods.dto.GoodsDto;
import com.bms.member.dto.MemberDto;
import com.bms.order.dto.OrderDto;

public interface OrderService {
	
	public List<Map<String, Object>> listMyOrderGoods(OrderDto orderDto) throws Exception;
	public void addNewOrder(OrderDto orderDto) throws Exception;
	public OrderDto findMyOrder(String orderId) throws Exception;
	public void addPoint(MemberDto memberDto) throws Exception;
	public void useAllPoint(MemberDto memberDto) throws Exception;
}
