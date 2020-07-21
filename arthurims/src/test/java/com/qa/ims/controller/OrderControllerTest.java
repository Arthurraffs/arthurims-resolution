package com.qa.ims.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.services.OrderServices;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {

	/**
	 * The thing I want to fake functionlity for
	 */
	@Mock
	private OrderServices orderServices;

	/**
	 * Spy is used because i want to mock some methods inside the order I'm testing
	 * InjectMocks uses dependency injection to insert the mock into the order
	 * controller
	 */
	@Spy // for the methods in orderController
	@InjectMocks // for any classes our orderController calls (in this case orderService)
	private OrderController orderController;

	@Test
	public void readAllTest() {
		OrderController orderController = new OrderController(orderServices);
		List<Order> orders = new ArrayList<>();
		orders.add(new Order("1", "1", "250.0", "2020-01-01", "1"));
		orders.add(new Order("2", "2", "300.0", "2020-01-01", "1"));
		orders.add(new Order("3", "3", "350.0", "2020-01-01", "1"));
		Mockito.when(orderServices.readAll()).thenReturn(orders);
		assertEquals(orders, orderController.readAll());
	}

	@Test
	public void createTest() {
		String fk_customer_id = "1";
		String fk_item_id = "1";
		String order_cost = "250.0";
		String order_date = "2020-01-01";
		String quantity = "1";
		Mockito.doReturn(fk_customer_id, fk_item_id, order_cost, order_date, quantity).when(orderController).getInput();
		Order order = new Order(fk_customer_id, fk_item_id, order_cost, order_date, quantity);
		Order savedOrder = new Order("1", "1", "250.0", "2020-01-01", "1");
		Mockito.when(orderServices.create(order)).thenReturn(savedOrder);
		assertEquals(savedOrder, orderController.create());
	}

	/**
	 *
	 */
	@Test
	public void updateTest() {
		String order_id = "2";
		String fk_customer_id = "2";
		String fk_item_id = "2";
		String order_cost = "300.0.0";
		String order_date = "2020-01-01";
		String quantity = "1";
		Mockito.doReturn(order_id, fk_customer_id, fk_item_id, order_cost, order_date, quantity).when(orderController)
				.getInput();
		Order order = new Order(2, fk_customer_id, fk_item_id, order_cost, order_date, quantity);
		Mockito.when(orderServices.update(order)).thenReturn(order);
		assertEquals(order, orderController.update());
	}

	/**
	 * Delete doesn't return anything, so we can just verify that it calls the
	 * delete method
	 */
	@Test
	public void deleteTest() {
		String id = "1";
		Mockito.doReturn(id).when(orderController).getInput();
		orderController.delete();
		Mockito.verify(orderServices, Mockito.times(1)).delete(1);
	}

}
