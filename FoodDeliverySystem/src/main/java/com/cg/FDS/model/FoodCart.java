package com.cg.FDS.model;

import java.util.List;

public class FoodCart {
 private String cardId;
 private Customer customer;
private List<Item> itemList;
public FoodCart() {
	super();
}
public FoodCart(String cardId, Customer customer, List<Item> itemList) {
	super();
	this.cardId = cardId;
	this.customer = customer;
	this.itemList = itemList;
}
public String getCardId() {
	return cardId;
}
public void setCardId(String cardId) {
	this.cardId = cardId;
}
public Customer getCustomer() {
	return customer;
}
public void setCustomer(Customer customer) {
	this.customer = customer;
}
public List<Item> getItemList() {
	return itemList;
}
public void setItemList(List<Item> itemList) {
	this.itemList = itemList;
}
@Override
public String toString() {
	return "FoodCart [cardId=" + cardId + ", customer=" + customer + "]";
}

 
}
