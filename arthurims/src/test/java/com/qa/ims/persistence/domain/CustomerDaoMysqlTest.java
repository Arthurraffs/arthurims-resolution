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
import com.qa.ims.persistence.dao.CustomerDaoMysql;


@RunWith(MockitoJUnitRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class CustomerDaoMysqlTest {

	public static final Logger LOGGER = Logger.getLogger(CustomerDaoMysql.class);

	@BeforeClass
	public static void aInit() {
		Ims ims = new Ims();
		ims.init("jdbc:mysql://localhost:3306/arthurimstest?serverTimezone=UTC", "root", "root",
				"src/test/resources/sql-schema.sql");
	}

	@Test
	public void bcusCreateTest() {
		CustomerDaoMysql customerDaoMysql = new CustomerDaoMysql(
				"jdbc:mysql://localhost:3306/arthurimstest?serverTimezone=UTC", "root", "root");
		String fname = "Vinesh";
		String surname = "Ghela";
		String email = "vinesh@email.com";
		Customer customer = new Customer(1, fname, surname, email);
		String fname2 = "Marie";
		String surname2 = "Rafferty";
		String email2 = "marie@email.com";
		Customer customer2 = new Customer(2, fname2, surname2, email2);
		String fname3 = "Steph";
		String surname3 = "Gilmore";
		String email3 = "steph@email.com";
		Customer customer3 = new Customer(3, fname3, surname3, email3);
		assertEquals(customer, customerDaoMysql.create(customer));
		assertEquals(customer2, customerDaoMysql.create(customer2));
		assertEquals(customer3, customerDaoMysql.create(customer3));
	}

	@Test
	public void cusReadAllTest() {
		CustomerDaoMysql customerDaoMysql = new CustomerDaoMysql(
				"jdbc:mysql://localhost:3306/arthurimstest?serverTimezone=UTC", "root", "root");
		List<Customer> customers = new ArrayList<>();
		customers.add(new Customer(1, "Vinesh", "Ghela", "vinesh@email.com"));
		customers.add(new Customer(2, "Marie", "Rafferty", "marie@email.com"));
		customers.add(new Customer(3, "Steph", "Gilmore", "steph@email.com"));

		assertEquals(customers, customerDaoMysql.readAll());
	}

	@Test
	public void dcusReadLatestTest() {
		CustomerDaoMysql customerDaoMysql = new CustomerDaoMysql(
				"jdbc:mysql://localhost:3306/arthurimstest?serverTimezone=UTC", "root", "root");
		Customer customer = new Customer(3, "Steph", "Gilmore", "steph@email.com");

		assertEquals(customer, customerDaoMysql.readLatest());
	}
	
	@Test 
	public void ecusReadCustomerTest() {
		CustomerDaoMysql customerDaoMysql = new CustomerDaoMysql(
				"jdbc:mysql://localhost:3306/arthurimstest?serverTimezone=UTC", "root", "root");
		Customer customer = new Customer(2, "Marie", "Rafferty", "marie@email.com");
		assertEquals(customer, customerDaoMysql.readCustomer(2));
	}

	@Test
	public void fcusUpdateTest() {
		CustomerDaoMysql customerDaoMysql = new CustomerDaoMysql(
				"jdbc:mysql://localhost:3306/arthurimstest?serverTimezone=UTC", "root", "root");
		int customer_id = 1;
		String fname = "Vinesh";
		String surname = "Ghela";
		String email = "vinesh@email.com";
		Customer customer = new Customer(customer_id, fname, surname, email);
		assertEquals(customer, customerDaoMysql.update(customer));

	}

	@Test
	public void gcusDeleteTest() {

		CustomerDaoMysql customerDaoMysql = new CustomerDaoMysql(
				"jdbc:mysql://localhost:3306/arthurimstest?serverTimezone=UTC", "root", "root");
		int customer_id = 3;
		customerDaoMysql.delete(customer_id);
		List<Customer> customers = new ArrayList<>();
		customers.add(new Customer(1, "Vinesh", "Ghela", "vinesh@email.com"));
		customers.add(new Customer(2, "Marie", "Rafferty", "marie@email.com"));
		assertEquals(customers, customerDaoMysql.readAll());
	}

	@AfterClass
	public static void XcleanCusDB() {
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
	public static void YcleanCusDB1() {
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
