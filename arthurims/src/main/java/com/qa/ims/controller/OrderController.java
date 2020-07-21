package com.qa.ims.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.services.CrudServices;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order> {

	public static final Logger LOGGER = Logger.getLogger(OrderController.class);

	private CrudServices<Order> orderService;

	public OrderController(CrudServices<Order> orderService) {
		this.orderService = orderService;
	}

	String getInput() {
		return Utils.getInput();
	}

	/**
	 * Reads all orders to the logger
	 */
	@Override
	public List<Order> readAll() {
		List<Order> orders = orderService.readAll();
		for (Order order : orders) {
			LOGGER.info(order.toString());
		}
		return orders;
	}

	/**
	 * Creates a order by taking in user input
	 */
	@Override
	public Order create() {
		LOGGER.info("Please enter a customer ID");
		String fk_customer_id = getInput();
		LOGGER.info("Please enter an item ID");
		String fk_item_id = getInput();
		LOGGER.info("Please enter an order cost");
		String order_cost = getInput();
		LOGGER.info("Please enter an order date in format yyyy-mm-dd");
		String order_date = getInput();
		LOGGER.info("Please enter a quantity");
		String quantity = getInput();
		Order order = orderService.create(new Order(fk_customer_id, fk_item_id, order_cost, order_date, quantity));
		LOGGER.info("Order created");
		return order;
	}

	/**
	 * Updates an existing order by taking in user input
	 */
	@Override
	public Order update() {
		LOGGER.info("Please enter the id of the order you would like to update");
		int order_id = Integer.parseInt(getInput());
		LOGGER.info("Please enter a customer ID");
		String fk_customer_id = getInput();
		LOGGER.info("Please enter an item ID");
		String fk_item_id = getInput();
		LOGGER.info("Please enter an order cost");
		String order_cost = getInput();
		LOGGER.info("Please enter an order date in format yyyy-mm-dd");
		String order_date = getInput();
		LOGGER.info("Please enter an order quantity");
		String quantity = getInput();
		Order order = orderService.update(new Order(order_id, fk_customer_id, fk_item_id, order_cost, order_date, quantity));
		LOGGER.info("Item Updated");
		return order;
	}
	
	/**
	 * Deletes an existing order by the id of the order
	 */
	@Override
	public void delete() {
		LOGGER.info("Please enter the id of the order you would like to delete");
		int order_id = Integer.parseInt(getInput());
		orderService.delete(order_id);
	}
}
