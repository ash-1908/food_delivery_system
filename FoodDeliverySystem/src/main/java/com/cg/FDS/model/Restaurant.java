package com.cg.FDS.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Restaurant_tbl")
public class Restaurant {

	@Id
	@Column(name = "restaurantId", length = 20)
	private String restaurantId;
	@Column(name = "restaurantName", length = 20)
	private String restaurantName;

	@Column(name = "managerName", length = 20)
	private String managerName;
	@Column(name = "contactNumber", length = 20)
	private String contactNumber;

	@ManyToMany
	@JoinTable(name = "restaurant_items", joinColumns = { @JoinColumn(name = "restaurantId") }, inverseJoinColumns = {
			@JoinColumn(name = "itemId") })
	private List<Item> itemList = new ArrayList<Item>();

	@OneToOne(cascade = CascadeType.ALL)
	Address address;

	public Restaurant() {
		super();
	}

	public Restaurant(String restaurantId, String restaurantName, Address address, List<Item> itemList,
			String managerName, String contactNumber) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.address = address;
		this.itemList = itemList;
		this.managerName = managerName;
		this.contactNumber = contactNumber;
	}

	public String getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(String resturantId) {
		this.restaurantId = resturantId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName + ", address="
				+ address + ", managerName=" + managerName + ", contactNumber=" + contactNumber + "]";
	}

}
