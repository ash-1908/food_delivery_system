package com.cg.FDS.model;

import java.util.List;

public class Restaurant {
	
	private String resturantId;
	private String resturantName;
	private Address address;
	private List<Item> itemList;
	private String managerName;
	private String contactNumber;
	public Restaurant() {
		super();
	}
	public Restaurant(String resturantId, String resturantName, Address address, List<Item> itemList, String managerName,
			String contactNumber) {
		super();
		this.resturantId = resturantId;
		this.resturantName = resturantName;
		this.address = address;
		this.itemList = itemList;
		this.managerName = managerName;
		this.contactNumber = contactNumber;
	}
	public String getResturantId() {
		return resturantId;
	}
	public void setResturantId(String resturantId) {
		this.resturantId = resturantId;
	}
	public String getResturantName() {
		return resturantName;
	}
	public void setResturantName(String resturantName) {
		this.resturantName = resturantName;
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
		return "Resturant [resturantId=" + resturantId + ", resturantName=" + resturantName + ", address=" + address
				+ ", managerName=" + managerName + ", contactNumber=" + contactNumber + "]";
	}
	
}
