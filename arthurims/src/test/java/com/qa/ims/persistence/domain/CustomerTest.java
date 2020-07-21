package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class CustomerTest {
	
	private Customer customer;
	private Customer other;
	
	@Before
	public void setUp() {
		customer = new Customer(1, "Chris", "Perrins", "chris@email.com");
		other = new Customer(1, "Chris", "Perrins", "chris@email.com");
	}
	
	@Test
	public void settersTest() {
		assertNotNull(customer.getCustomer_Id());
		assertNotNull(customer.getFname());
		assertNotNull(customer.getSurname());
		assertNotNull(customer.getEmail());
		
		customer.setfname(null);
		assertNull(customer.getFname());
		customer.setSurname(null);
		assertNull(customer.getSurname());
		customer.setEmail(null);
		assertNull(customer.getEmail());
		
	}
	
	@Test
	public void equalsWithNull() {
		assertFalse(customer.equals(null));
	}
	
	@Test
	public void equalsWithDifferentObject() {
		assertFalse(customer.equals(new Object()));
	}
	
	@Test
	public void createCustomerWithId() {
		assertEquals(1L, customer.getCustomer_Id(), 0);
		assertEquals("Chris", customer.getFname());
		assertEquals("Perrins", customer.getSurname());
		assertEquals("chris@email.com", customer.getEmail());
	}
	
	@Test
	public void checkEquality() {
		assertTrue(customer.equals(customer));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertTrue(customer.equals(other));
	}
	
	@Test
	public void customerNameNullButOtherNameNotNull() {
		customer.setfname(null);
		assertFalse(customer.equals(other));
	}
	
	@Test
	public void customerNamesNotEqual() {
		other.setfname("rhys");
		assertFalse(customer.equals(other));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjectsNullName() {
		customer.setfname(null);
		other.setfname(null);
		assertTrue(customer.equals(other));
	}
	
	@Test
	public void nullId() {
		customer.setCustomer_Id(0);
		assertFalse(customer.equals(other));
	}
	
	@Test
	public void nullIdOnBoth() {
		customer.setCustomer_Id(0);
		other.setCustomer_Id(0);
		assertTrue(customer.equals(other));
	}
	
	@Test
	public void otherIdDifferent() {
		other.setCustomer_Id(2);
		assertFalse(customer.equals(other));
	}
	
	@Test
	public void nullSurname() {
		customer.setSurname(null);
		assertFalse(customer.equals(other));
	}
	
	@Test
	public void nullSurnameOnBoth() {
		customer.setSurname(null);
		other.setSurname(null);
		assertTrue(customer.equals(other));
	}
	
	@Test
	public void otherSurnameDifferent() {
		other.setSurname("thompson");
		assertFalse(customer.equals(other));
	}
	
	@Test
	public void constructorWithoutId() {
		Customer customer = new Customer("Chris", "Perrins", "chris@email.com");
		assertNotNull(customer.getFname());
		assertNotNull(customer.getSurname());
		assertNotNull(customer.getEmail());
	}
	
	@Test
	public void hashCodeTest() {
		assertEquals(customer.hashCode(), other.hashCode());
	}
	@Test
	public void hashCodeTestWithNull() {
		Customer customer = new Customer(null, null, null);
		Customer other = new Customer(null, null, null);
		assertEquals(customer.hashCode(), other.hashCode());
	}

}
