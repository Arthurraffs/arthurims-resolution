package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ItemTest {
	
	private Item item;
	private Item other;
	
	@Before
	public void setUp() {
		item = new Item(1, "phone", "250.0");
		other = new Item(1, "phone", "250.0");
	}
	
	@Test
	public void settersTest() {
		assertNotNull(item.getItem_id());
		assertNotNull(item.getItem_name());
		assertNotNull(item.getItem_cost());
		
		item.setItem_name(null);
		assertNull(item.getItem_name());
		item.setItem_cost(null);
		assertNull(item.getItem_cost());
		
	}
	
	@Test
	public void equalsWithNull() {
		assertFalse(item.equals(null));
	}
	
	@Test
	public void equalsWithDifferentObject() {
		assertFalse(item.equals(new Object()));
	}
	
	@Test
	public void createItemWithId() {
		assertEquals(1L, item.getItem_id(), 0);
		assertEquals("phone", item.getItem_name());
		assertEquals("250.0", item.getItem_cost());
	}
	
	@Test
	public void checkEquality() {
		assertTrue(item.equals(item));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertTrue(item.equals(other));
	}
	
	@Test
	public void itemNameNullButOtherNameNotNull() {
		item.setItem_name(null);
		assertFalse(item.equals(other));
	}
	
	@Test
	public void itemNamesNotEqual() {
		other.setItem_name("tablet");
		assertFalse(item.equals(other));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjectsNullName() {
		item.setItem_name(null);
		other.setItem_name(null);
		assertTrue(item.equals(other));
	}
	
	@Test
	public void nullId() {
		item.setItem_id(0);
		assertFalse(item.equals(other));
	}
	
	@Test
	public void nullIdOnBoth() {
		item.setItem_id(0);
		other.setItem_id(0);
		assertTrue(item.equals(other));
	}
	
	@Test
	public void otherIdDifferent() {
		other.setItem_id(2);
		assertFalse(item.equals(other));
	}
	
	@Test
	public void nullItem_cost() {
		item.setItem_cost(null);
		assertFalse(item.equals(other));
	}
	
	@Test
	public void nullItem_costOnBoth() {
		item.setItem_cost(null);
		other.setItem_cost(null);
		assertTrue(item.equals(other));
	}
	
	@Test
	public void otherItem_costDifferent() {
		other.setItem_cost("300.0");
		assertFalse(item.equals(other));
	}
	
	@Test
	public void constructorWithoutId() {
		Item item = new Item("phone", "250.0");
		assertNotNull(item.getItem_name());
		assertNotNull(item.getItem_cost());
	}
	
	@Test
	public void hashCodeTest() {
		assertEquals(item.hashCode(), other.hashCode());
	}
	@Test
	public void hashCodeTestWithNull() {
		Item item = new Item(null, null);
		Item other = new Item(null, null);
		assertEquals(item.hashCode(), other.hashCode());
	}

}
