package com.cg.FDS.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "foodcart_tbl")
public class FoodCart {

	@Id
	@Column(name = "cart_id", length = 20)
	private String cartId;

	@OneToOne(cascade = CascadeType.ALL)
	@Column(name = "cust_id", length = 20)
	Customer customer;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "foodcart_items", joinColumns = { @JoinColumn(name = "cartId") }, inverseJoinColumns = {
			@JoinColumn(name = "itemId") })
	private List<Item> itemList = new ArrayList<Item>();

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

	@Override
	public String toString() {
		return "FoodCart [cartId=" + cartId + ", customer=" + customer + ", itemList=" + itemList + "]";
	}
}
