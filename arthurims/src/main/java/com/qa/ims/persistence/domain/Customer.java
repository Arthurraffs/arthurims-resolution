package com.qa.ims.persistence.domain;

public class Customer {

	private int customer_id;
	private String fname;
	private String surname;
	private String email;

	public Customer(String fname, String surname, String email) {
		this.fname = fname;
		this.surname = surname;
		this.email = email;
	}

	public Customer(int customer_id, String fname, String surname, String email) {
		this.customer_id = customer_id;
		this.fname = fname;
		this.surname = surname;
		this.email = email;
	}

	public int getCustomer_Id() {
		return customer_id;
	}

	public void setCustomer_Id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getFname() {
		return fname;
	}

	public void setfname(String fname) {
		this.fname = fname;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String toString() {
		return "customer id:" + customer_id + " first name:" + fname + " surname:" + surname;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + customer_id;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((fname == null) ? 0 : fname.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (customer_id != other.customer_id)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (fname == null) {
			if (other.fname != null)
				return false;
		} else if (!fname.equals(other.fname))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}


}
