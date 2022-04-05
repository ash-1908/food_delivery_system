package com.cg.FDS.model;

import java.util.List;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

public class FoodCart {
	private String cartId;
	private List<Item> itemList;
	@OneToOne
	private Customer customer;
	@OneToOne
	private OrderDetails orderDetail;
	
	@OneToMany
	private List<Item> item;
	public FoodCart() {
		super();
	}
	public FoodCart(String cartId, Customer customer, List<Item> itemList) {
		super();
		this.cartId = cartId;
		this.customer = customer;
		this.itemList = itemList;
	}
	public String getCartId() {
		return cartId;
	}
	public void setCartId(String cartId) {
		this.cartId = cartId;
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
	
	public OrderDetails getOrderDetail() {
		return orderDetail;
	}
	public void setOrderDetail(OrderDetails orderDetail) {
		this.orderDetail = orderDetail;
	}
	
	public List<Item> getItem() {
		return item;
	}
	public void setItem(List<Item> item) {
		this.item = item;
	}
	@Override
	public String toString() {
		return "FoodCart [cartId=" + cartId + ", customer=" + customer + ", itemList=" + itemList + "]";
	}
}
