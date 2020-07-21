package com.qa.ims.persistence.domain;

public class Order {

	private int order_id;
	private String fk_customer_id;
	private String fk_item_id;
	private String order_cost;
	private String order_date;
	private String quantity;
	
	public Order(String fk_customer_id, String fk_item_id, String order_cost, String order_date, String quantity) {
		super();
		this.fk_customer_id = fk_customer_id;
		this.fk_item_id = fk_item_id;
		this.order_cost = order_cost;
		this.order_date = order_date;
		this.quantity = quantity;
	}

	public Order(int order_id, String fk_customer_id, String fk_item_id, String order_cost, String order_date,
			String quantity) {
		super();
		this.order_id = order_id;
		this.fk_customer_id = fk_customer_id;
		this.fk_item_id = fk_item_id;
		this.order_cost = order_cost;
		this.order_date = order_date;
		this.quantity = quantity;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public String getFk_customer_id() {
		return fk_customer_id;
	}

	public void setFk_customer_id(String fk_customer_id) {
		this.fk_customer_id = fk_customer_id;
	}

	public String getFk_item_id() {
		return fk_item_id;
	}

	public void setFk_item_id(String fk_item_id) {
		this.fk_item_id = fk_item_id;
	}

	public String getOrder_cost() {
		return order_cost;
	}

	public void setOrder_cost(String order_cost) {
		this.order_cost = order_cost;
	}

	public String getOrder_date() {
		return order_date;
	}

	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fk_customer_id == null) ? 0 : fk_customer_id.hashCode());
		result = prime * result + ((fk_item_id == null) ? 0 : fk_item_id.hashCode());
		result = prime * result + ((order_cost == null) ? 0 : order_cost.hashCode());
		result = prime * result + ((order_date == null) ? 0 : order_date.hashCode());
		result = prime * result + order_id;
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
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
		Order other = (Order) obj;
		if (fk_customer_id == null) {
			if (other.fk_customer_id != null)
				return false;
		} else if (!fk_customer_id.equals(other.fk_customer_id))
			return false;
		if (fk_item_id == null) {
			if (other.fk_item_id != null)
				return false;
		} else if (!fk_item_id.equals(other.fk_item_id))
			return false;
		if (order_cost == null) {
			if (other.order_cost != null)
				return false;
		} else if (!order_cost.equals(other.order_cost))
			return false;
		if (order_date == null) {
			if (other.order_date != null)
				return false;
		} else if (!order_date.equals(other.order_date))
			return false;
		if (order_id != other.order_id)
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order_id = " + order_id + ", Customer_id = " + fk_customer_id + ", Item_id = " + fk_item_id
				+ ", Order_cost = " + order_cost + ", Order_date = " + order_date + ", Quantity = " + quantity + "]";
	}

	
	

}
