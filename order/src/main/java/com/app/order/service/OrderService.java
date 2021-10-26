package com.app.order.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.order.controller.OrderController;
import com.app.order.exception.ResourceNotFoundException;
import com.app.order.model.Order;
import com.app.order.model.OrdersList;
import com.app.order.repository.OrderRepository;

@Service
public class OrderService {
	
	private static final Logger log = LoggerFactory.getLogger(OrderController.class);
	
	@Autowired
	private OrderRepository orderRepository;
	
	public OrdersList getAllOrders() {
		OrdersList orderslist = new OrdersList();
		orderslist.setOrder(orderRepository.findAll());
		return orderslist;
	}
	
	public Order getOrderById( Long orderId)
	{
		Order order= null;
		try {
			order = orderRepository.findById(orderId)
					.orElseThrow(() -> new ResourceNotFoundException("Order not found for this id :: " + orderId));
		} catch (ResourceNotFoundException e) {
			log.error("Error while fetching order for orderId "+orderId+ " :: " +e.getMessage());
		}
		return order;
	}

	public OrdersList getOrderByName( String name){
		OrdersList orderslist = new OrdersList();
		orderslist.setOrder(orderRepository.findByName(name));
		return orderslist;
	}

	public Order save(Order order) {
		return orderRepository.save(order);
	}
	
	public Order updateOrder(Long orderId, Order orderDetails) throws ResourceNotFoundException {
		Order order = orderRepository.findById(orderId)
				.orElseThrow(() -> new ResourceNotFoundException("Order not found for this id :: " + orderId));
		if(orderDetails.getDescription()!=null) {
			order.setDescription(orderDetails.getDescription());;
		}
		if(orderDetails.getQuantity()!=null) {
			order.setQuantity(orderDetails.getQuantity());
		}
		if(orderDetails.getName()!=null) {
			order.setName(orderDetails.getName());
		}
		final Order updatedOrder = orderRepository.save(order);
		return updatedOrder;
	}
	
	public void deleteOrder(Long orderId) throws ResourceNotFoundException {
		Order order = orderRepository.findById(orderId)
				.orElseThrow(() -> new ResourceNotFoundException("Order not found for this id :: " + orderId));
		orderRepository.delete(order);
	}

}
