package com.qa.ims.persistence.domain;

public class Item {
	
	private int item_id;
	private String item_name;
	private String item_cost;
	
	public Item(String item_name, String item_cost) {
		this.item_name = item_name;
		this.item_cost = item_cost;
	}

	public Item(int item_id, String item_name, String item_cost) {
		this.item_id = item_id;
		this.item_name = item_name;
		this.item_cost = item_cost;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getItem_cost() {
		return item_cost;
	}

	public void setItem_cost(String item_cost) {
		this.item_cost = item_cost;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((item_cost == null) ? 0 : item_cost.hashCode());
		result = prime * result + item_id;
		result = prime * result + ((item_name == null) ? 0 : item_name.hashCode());
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
		Item other = (Item) obj;
		if (item_cost == null) {
			if (other.item_cost != null)
				return false;
		} else if (!item_cost.equals(other.item_cost))
			return false;
		if (item_id != other.item_id)
			return false;
		if (item_name == null) {
			if (other.item_name != null)
				return false;
		} else if (!item_name.equals(other.item_name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Item id = " + item_id + ", Item name = " + item_name + ", Item cost = £" + item_cost;
	}
	
	
	


}
