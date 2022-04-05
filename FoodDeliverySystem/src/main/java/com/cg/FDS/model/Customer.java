package com.cg.FDS.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Customer {
	
	@Id
	private String customerId;
	@Column(name="firstName", length=30)
	private String firstName;
	@Column(name="lastName", length=30)
	private String lastName;
	@Column(name="age", length=30)
	private int age;
	@Column(name="gender", length=30)
	private String gender;
	@Column(name="mobileNumber", length=30)
	private String mobileNumber;
	@Column(name="email", length=30)
	private String email;
	
	@OneToOne
	private Address address;
	
	@OneToOne(mappedBy="customer")
	private FoodCart foodCart; 
	
	public Customer() {
		super();
	}
	
	public Customer(String customerId, String firstName, String lastName, int age, String gender, String mobileNumber,
			Address address, String email) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.email = email;
		this.foodCart=foodCart;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public FoodCart getFoodCart() {
		return foodCart;
	}

	public void setFoodCart(FoodCart foodCart) {
		this.foodCart = foodCart;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName + ", age="
				+ age + ", gender=" + gender + ", mobileNumber=" + mobileNumber + ", email=" + email + ", address="
				+ address + ", foodCart=" + foodCart + "]";
	}

	
}
