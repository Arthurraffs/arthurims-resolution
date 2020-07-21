package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.Ims;
import com.qa.ims.persistence.dao.CustomerDaoMysql;
import com.qa.ims.persistence.dao.ItemDaoMysql;
import com.qa.ims.persistence.dao.OrderDaoMysql;

@RunWith(MockitoJUnitRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class OrderDaoMysqlTest {

	public static final Logger LOGGER = Logger.getLogger(OrderDaoMysql.class);

	@BeforeClass
	public static void aInit() {
		Ims ims = new Ims();
		ims.init("jdbc:mysql://localhost:3306/arthurimstest?serverTimezone=UTC", "root", "root",
				"src/test/resources/sql-schema.sql");
		CustomerDaoMysql customerDaoMysql = new CustomerDaoMysql(
				"jdbc:mysql://localhost:3306/arthurimstest?serverTimezone=UTC", "root", "root");
		Customer customer = new Customer("Vin", "Ghela", "vin@email.com");
		Customer customer2 = new Customer("Rob", "Robson", "rob@email.com");
		Customer customer3 = new Customer("Jay", "Jack", "jay@email.com");
		customerDaoMysql.create(customer);
		customerDaoMysql.create(customer2);
		customerDaoMysql.create(customer3);
		ItemDaoMysql itemDaoMysql = new ItemDaoMysql("jdbc:mysql://localhost:3306/arthurimstest?serverTimezone=UTC",
				"root", "root");
		Item item = new Item(1, "phone", "250.0");
		Item item2 = new Item(2, "laptop", "300.0");
		Item item3 = new Item(3, "tablet", "350.0");
		itemDaoMysql.create(item);
		itemDaoMysql.create(item2);
		itemDaoMysql.create(item3);
	}

	@Test
	public void doCreateTest() {
		OrderDaoMysql orderDaoMysql = new OrderDaoMysql("jdbc:mysql://localhost:3306/arthurimstest?serverTimezone=UTC",
				"root", "root");
		String fk_customer_id = "1";
		String fk_item_id = "1";
		String order_cost = "250.0";
		String order_date = "2020-01-01";
		String quantity = "1";
		Order order = new Order(1, fk_customer_id, fk_item_id, order_cost, order_date, quantity);
		String fk_customer_id2 = "2";
		String fk_item_id2 = "2";
		String order_cost2 = "300.0";
		String order_date2 = "2020-01-02";
		String quantity2 = "1";
		Order order2 = new Order(2, fk_customer_id2, fk_item_id2, order_cost2, order_date2, quantity2);
		String fk_customer_id3 = "3";
		String fk_item_id3 = "3";
		String order_cost3 = "350.0";
		String order_date3 = "2020-01-03";
		String quantity3 = "1";
		Order order3 = new Order(3, fk_customer_id3, fk_item_id3, order_cost3, order_date3, quantity3);
		assertEquals(order, orderDaoMysql.create(order));
		assertEquals(order2, orderDaoMysql.create(order2));
		assertEquals(order3, orderDaoMysql.create(order3));
	}

	@Test
	public void eoReadAllTest() {
		OrderDaoMysql orderDaoMysql = new OrderDaoMysql("jdbc:mysql://localhost:3306/arthurimstest?serverTimezone=UTC",
				"root", "root");
		List<Order> orders = new ArrayList<>();
		orders.add(new Order(1, "1", "1", "250.0", "2020-01-01", "1"));
		orders.add(new Order(2, "2", "2", "300.0", "2020-01-02", "1"));
		orders.add(new Order(3, "3", "3", "350.0", "2020-01-03", "1"));

		assertEquals(orders, orderDaoMysql.readAll());
	}

	@Test
	public void foReadLatestTest() {
		OrderDaoMysql orderDaoMysql = new OrderDaoMysql("jdbc:mysql://localhost:3306/arthurimstest?serverTimezone=UTC",
				"root", "root");
		Order order = new Order(3, "3", "3", "350.0", "2020-01-03", "1");

		assertEquals(order, orderDaoMysql.readLatest());
	}

	@Test
	public void goReadOrderTest() {
		OrderDaoMysql orderDaoMysql = new OrderDaoMysql("jdbc:mysql://localhost:3306/arthurimstest?serverTimezone=UTC",
				"root", "root");
		Order order = new Order(2, "2", "2", "300.0", "2020-01-02", "1");
		assertEquals(order, orderDaoMysql.readOrder(2));
	}

	@Test
	public void hoUpdateTest() {
		OrderDaoMysql orderDaoMysql = new OrderDaoMysql("jdbc:mysql://localhost:3306/arthurimstest?serverTimezone=UTC",
				"root", "root");
		int order_id = 1;
		String fk_customer_id = "1";
		String fk_item_id = "1";
		String order_cost = "250.0";
		String order_date = "2020-01-01";
		String quantity = "1";
		Order order = new Order(order_id, fk_customer_id, fk_item_id, order_cost, order_date, quantity);
		assertEquals(order, orderDaoMysql.update(order));

	}

	@Test
	public void ioDeleteTest() {

		OrderDaoMysql orderDaoMysql = new OrderDaoMysql("jdbc:mysql://localhost:3306/arthurimstest?serverTimezone=UTC",
				"root", "root");
		int order_id = 3;
		orderDaoMysql.delete(order_id);
		List<Order> orders = new ArrayList<>();
		orders.add(new Order(1, "1", "1", "250.0", "2020-01-01", "1"));
		orders.add(new Order(2, "2", "2", "300.0", "2020-01-02", "1"));
		assertEquals(orders, orderDaoMysql.readAll());
	}

	@AfterClass
	public static void xcleanOrderDB() {
		try (Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/arthurimstest?serverTimezone=UTC", "root", "root");
				Statement statement = connection.createStatement()) {
			statement.executeUpdate("drop table orders");
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());

		}

	}

	@AfterClass
	public static void ycleanOrderDB1() {
		try (Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/arthurimstest?serverTimezone=UTC", "root", "root");
				Statement statement = connection.createStatement()) {
			statement.executeUpdate("drop table customers");
			statement.executeUpdate("drop table items");

		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());

		}

	}
}
