package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class OrderTest {
	
	private Order order;
	private Order other;
	
	@Before
	public void setUp() {
		order = new Order(1, "1", "1", "250.0", "2020-01-01", "1");
		other = new Order(1, "1", "1","250.0", "2020-01-01", "1");
	}
	
	@Test
	public void settersTest() {
		assertNotNull(order.getOrder_id());
		assertNotNull(order.getFk_customer_id());
		assertNotNull(order.getFk_item_id());
		assertNotNull(order.getOrder_cost());
		assertNotNull(order.getOrder_date());
		assertNotNull(order.getQuantity());
		
		order.setFk_customer_id(null);
		assertNull(order.getFk_customer_id());
		order.setFk_item_id(null);
		assertNull(order.getFk_item_id());
		order.setOrder_cost(null);
		assertNull(order.getOrder_cost());
		order.setOrder_date(null);
		assertNull(order.getOrder_date());
		order.setQuantity(null);
		assertNull(order.getQuantity());
	}
	
	@Test
	public void equalsWithNull() {
		assertFalse(order.equals(null));
	}
	
	@Test
	public void equalsWithDifferentObject() {
		assertFalse(order.equals(new Object()));
	}
	
	@Test
	public void createOrderWithId() {
		assertEquals(1L, order.getOrder_id(), 0);
		assertEquals("1", order.getFk_customer_id());
		assertEquals("1", order.getFk_item_id());
		assertEquals("250.0", order.getOrder_cost());
		assertEquals("2020-01-01", order.getOrder_date());
		assertEquals("1", order.getQuantity());
	}
	
	@Test
	public void checkEquality() {
		assertTrue(order.equals(order));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertTrue(order.equals(other));
	}
	
	@Test
	public void orderNameNullButOtherNameNotNull() {
		order.setFk_customer_id(null);
		assertFalse(order.equals(other));
	}
	
	@Test
	public void orderNamesNotEqual() {
		other.setFk_customer_id("2");
		assertFalse(order.equals(other));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjectsNullName() {
		order.setFk_customer_id(null);
		other.setFk_customer_id(null);
		assertTrue(order.equals(other));
	}
	
	@Test
	public void nullId() {
		order.setOrder_id(0);
		assertFalse(order.equals(other));
	}
	
	@Test
	public void nullIdOnBoth() {
		order.setOrder_id(0);
		other.setOrder_id(0);
		assertTrue(order.equals(other));
	}
	
	@Test
	public void otherIdDifferent() {
		other.setOrder_id(2);
		assertFalse(order.equals(other));
	}
	
	@Test
	public void nullFk_item_id() {
		order.setFk_item_id(null);
		assertFalse(order.equals(other));
	}
	
	@Test
	public void nullFk_item_idOnBoth() {
		order.setFk_item_id(null);
		other.setFk_item_id(null);
		assertTrue(order.equals(other));
	}
	
	@Test
	public void otherFk_item_idDifferent() {
		other.setFk_item_id("2");
		assertFalse(order.equals(other));
	}
	
	@Test
	public void constructorWithoutId() {
		Order order = new Order("1", "1", "250.0", "2020-01-01", "1");
		assertNotNull(order.getFk_customer_id());
		assertNotNull(order.getFk_item_id());
		assertNotNull(order.getOrder_cost());
	}
	
	@Test
	public void hashCodeTest() {
		assertEquals(order.hashCode(), other.hashCode());
	}
	@Test
	public void hashCodeTestWithNull() {
		Order order = new Order(null, null, null, null, null);
		Order other = new Order(null, null, null, null, null);
		assertEquals(order.hashCode(), other.hashCode());
	}

}