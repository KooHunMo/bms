package com.bms.order.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bms.goods.dto.GoodsDto;
import com.bms.member.dto.MemberDto;
import com.bms.order.dto.OrderDto;

@Repository
public class OrderDaoImpl implements OrderDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<Map<String, Object>> listMyOrderGoods(OrderDto orderDto) throws Exception{
		return sqlSession.selectList("mapper.order.selectMyOrderList" , orderDto);
	}
	
	public void insertNewOrder(OrderDto orderDto) throws Exception{
		sqlSession.insert("mapper.order.insertNewOrder" , orderDto);
	}	
	
	public OrderDto findMyOrder(String orderId) throws Exception{
		return sqlSession.selectOne("mapper.order.selectMyOrder" , orderId);
	}

	public void addPoint(MemberDto memberDto) throws Exception {
	sqlSession.update("mapper.order.updatePoint", memberDto);
		
	}

	public void useAllPoint(MemberDto memberDto) throws Exception {
		sqlSession.update("mapper.order.useAllPoint", memberDto);
		
	}
	
}

