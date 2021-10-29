package com.app.order.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.order.exception.ResourceNotFoundException;
import com.app.order.model.Order;
import com.app.order.model.OrdersList;
import com.app.order.service.OrderService;


@RestController
@RequestMapping("/api")
public class OrderController {
	
	private static final Logger log = LoggerFactory.getLogger(OrderController.class);
	
	@Autowired
	OrderService orderservice;
	
	@GetMapping("/orders")
	public ResponseEntity<OrdersList> getAllOrders() {
		log.info("Get all orders");
		return ResponseEntity.ok().body(orderservice.getAllOrders()) ;
	}

	
	
	
	@GetMapping("/orders/{id}")
	public ResponseEntity<Order> getOrderById(@PathVariable(value = "id") Long orderId)
	 {
		Order orderObj= null;
		log.info("OrderId is "+orderId);
		orderObj= orderservice.getOrderById(orderId);
		if(orderObj!=null) {
			return ResponseEntity.ok().body(orderObj);
		}else {
			return new ResponseEntity<Order>(orderObj, HttpStatus.NOT_FOUND);
		}
		
	}
	
	
	
	
	@GetMapping("/ordersByName/{name}")
	public ResponseEntity<OrdersList> getOrderByName(@PathVariable(value = "name") String name)
	{
		log.info("OrderName is "+name);
		return ResponseEntity.ok().body(orderservice.getOrderByName(name));
	}

	
	
	@PostMapping("/orders")
	public ResponseEntity<Order> createOrder(@RequestBody Order order) {
		
		Order orderObj= orderservice.save(order);
		log.info("Order is "+order);
		return ResponseEntity.ok().body(orderObj);
		
	}

	
	
	@PutMapping("/orders/{id}")
	public ResponseEntity<Order> updateOrder(@PathVariable(value = "id") Long orderId,
			@RequestBody Order orderDetails) throws ResourceNotFoundException {
		log.info("OrderId is "+orderId);
		Order updatedOrder =orderservice.updateOrder(orderId, orderDetails);
		return ResponseEntity.ok(updatedOrder);
	}

	
	@DeleteMapping("/orders/{id}")
	public ResponseEntity<String> deleteOrder(@PathVariable(value = "id") Long orderId)
			throws ResourceNotFoundException {
		log.info("OrderId is "+orderId);
		orderservice.deleteOrder(orderId);
		String deleteStatus= "Order with id "+ orderId +" deleted successfully";
		return ResponseEntity.ok(deleteStatus);
	}
}
