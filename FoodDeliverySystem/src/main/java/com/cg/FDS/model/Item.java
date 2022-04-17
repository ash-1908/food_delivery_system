package com.cg.FDS.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Item_tbl")
public class Item {

	@Id
	@Column(name = "itemId", length = 30)
	String itemId;
	@Column(name = "itemName", length = 30)
	private String itemName;
	@OneToOne
	private Category category;

	@Column(name = "quantity", length = 30)
	private int quantity;
	@Column(name = "cost", length = 30)
	private double cost;
	@ManyToMany(mappedBy = "itemList")
	@JsonIgnore
	List<Restaurant> restaurants = new ArrayList<Restaurant>();

	public Item() {
		super();
	}

	public Item(String itemId, String itemName, Category category, int quantity, double cost,
			List<Restaurant> restaurants) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.category = category;
		this.quantity = quantity;
		this.cost = cost;
		this.restaurants = restaurants;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public List<Restaurant> getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(List<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", category=" + category + ", quantity=" + quantity
				+ ", cost=" + cost + "]";
	}
}
