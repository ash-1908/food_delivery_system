package com.cg.FDS.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Restaurant_tbl")
public class Restaurant {
	
	@Id
	@Column(name = "restaurantId",length=20)
	private String resturantId;
	@Column(name = "restaurantName",length=20)
	private String resturantName;
	
	@Column(name = "managerName",length=20)
	private String managerName;
	@Column(name = "contactNumber",length=20)
	private String contactNumber;
	
	@ManyToMany
	private List<Item> itemList;
	
	@OneToOne
	Address address;
	
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
