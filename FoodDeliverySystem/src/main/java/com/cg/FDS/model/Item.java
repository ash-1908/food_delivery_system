package com.cg.FDS.model;

import java.util.List;

public class Item {
private  String itemid;
private String itemName;
private Category category;
private int quantity;
private double cost;
List<Restaurant> restaurants;
public Item() {
	super();
}
public Item(String itemid, String itemName, Category category, int quantity, double cost,
		List<Restaurant> restaurants) {
	super();
	this.itemid = itemid;
	this.itemName = itemName;
	this.category = category;
	this.quantity = quantity;
	this.cost = cost;
	this.restaurants = restaurants;
}
public String getItemid() {
	return itemid;
}
public void setItemid(String itemid) {
	this.itemid = itemid;
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
	return "Item [itemid=" + itemid + ", itemName=" + itemName + ", category=" + category + ", quantity=" + quantity
			+ ", cost=" + cost + "]";
}


}
