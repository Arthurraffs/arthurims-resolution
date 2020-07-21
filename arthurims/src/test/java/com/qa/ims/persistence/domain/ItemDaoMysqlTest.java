package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
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
import com.qa.ims.persistence.dao.ItemDaoMysql;

@RunWith(MockitoJUnitRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ItemDaoMysqlTest {
	public static final Logger LOGGER = Logger.getLogger(ItemDaoMysql.class);

	@BeforeClass
	public static void aInit() {
		Ims ims = new Ims();
		ims.init("jdbc:mysql://localhost:3306/arthurimstest?serverTimezone=UTC", "root", "root",
				"src/test/resources/sql-schema.sql");
	}

	@Test
	public void biCreateTest() {
		ItemDaoMysql itemDaoMysql = new ItemDaoMysql(
				"jdbc:mysql://localhost:3306/arthurimstest?serverTimezone=UTC", "root", "root");
		String item_name = "phone";
		String item_cost = "250.0";
		Item item = new Item(1, item_name, item_cost);
		String item_name2 = "laptop";
		String item_cost2 = "500.0";
		Item item2 = new Item(2, item_name2, item_cost2);
		String item_name3 = "tablet";
		String item_cost3 = "300.0";
		Item item3 = new Item(3, item_name3, item_cost3);
		assertEquals(item, itemDaoMysql.create(item));
		assertEquals(item2, itemDaoMysql.create(item2));
		assertEquals(item3, itemDaoMysql.create(item3));
	}

	@Test
	public void ciReadAllTest() {
		ItemDaoMysql itemDaoMysql = new ItemDaoMysql(
				"jdbc:mysql://localhost:3306/arthurimstest?serverTimezone=UTC", "root", "root");
		List<Item> items = new ArrayList<>();
		items.add(new Item(1, "phone", "250.0"));
		items.add(new Item(2, "laptop", "500.0"));
		items.add(new Item(3, "tablet", "300.0"));

		assertEquals(items, itemDaoMysql.readAll());
	}

	@Test
	public void diReadLatestTest() {
		ItemDaoMysql itemDaoMysql = new ItemDaoMysql(
				"jdbc:mysql://localhost:3306/arthurimstest?serverTimezone=UTC", "root", "root");
		Item item = new Item(3, "tablet", "300.0");

		assertEquals(item, itemDaoMysql.readLatest());
	}
	
	@Test 
	public void eReadItemTest() {
		ItemDaoMysql itemDaoMysql = new ItemDaoMysql(
				"jdbc:mysql://localhost:3306/arthurimstest?serverTimezone=UTC", "root", "root");
		Item item = new Item(2, "laptop", "500.0");
		assertEquals(item, itemDaoMysql.readItem(2));
	}

	@Test
	public void fiUpdateTest() {
		ItemDaoMysql itemDaoMysql = new ItemDaoMysql(
				"jdbc:mysql://localhost:3306/arthurimstest?serverTimezone=UTC", "root", "root");
		int item_id = 1;
		String item_name = "phone";
		String item_cost = "250.0";
		Item item = new Item(item_id, item_name, item_cost);
		assertEquals(item, itemDaoMysql.update(item));

	}

	@Test
	public void giDeleteTest() {

		ItemDaoMysql itemDaoMysql = new ItemDaoMysql(
				"jdbc:mysql://localhost:3306/arthurimstest?serverTimezone=UTC", "root", "root");
		int item_id = 3;
		itemDaoMysql.delete(item_id);
		List<Item> items = new ArrayList<>();
		items.add(new Item(1, "phone", "250.0"));
		items.add(new Item(2, "laptop", "500.0"));
		assertEquals(items, itemDaoMysql.readAll());
	}

	@AfterClass
	public static void XcleanItemDB() {
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
	public static void YcleanItemDB1() {
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
