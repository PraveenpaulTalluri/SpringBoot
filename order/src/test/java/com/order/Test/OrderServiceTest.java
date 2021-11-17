package com.order.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.app.order.model.Order;
import com.app.order.repository.OrderRepository;
import com.app.order.service.OrderService;

@SpringBootTest
public class OrderServiceTest {
	
	
	@Autowired
	private OrderService orderService;
	
	@MockBean
	private OrderRepository orderRepository;

	
	@Test
	public void getOrdersList() throws Exception {
		List<Order> ordersList=new ArrayList<>();
		ordersList.add(new Order(1,"abc",100,"Fruits"));
		ordersList.add(new Order(2,"bcd",200,"Electroics"));
		ordersList.add(new Order(3,"cde",300,"Veggies"));
		
		when(orderRepository.findAll()).thenReturn(ordersList);
		
		List<Order> ordersListResult=orderService.getAllOrders();
		assertEquals(ordersList.size(),ordersListResult.size());
	}
}
