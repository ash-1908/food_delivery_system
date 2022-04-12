package com.cg.FDS.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Customer_tbl")
public class Customer {

	@Id
	@Column(name = "cust_id", length = 20)
	private String customerId;

	@Column(name = "f_name", length = 20)
	private String firstName;

	@Column(name = "l_name", length = 20)
	private String lastName;

	@Column(name = "age", length = 3)
	private int age;

	@Column(name = "gender", length = 6)
	private String gender;

	@Column(name = "mobile", length = 10)
	private String mobileNumber;

	@Column(name = "email", length = 30)
	private String email;

	@OneToOne(cascade = CascadeType.ALL)
	@Column(name = "adr_id", length = 20)
	private Address address;

	public Customer() {
	}

	public Customer(String customerId, String firstName, String lastName, int age, String gender, String mobileNumber,
			String email, Address address) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.address = address;
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

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName + ", age="
				+ age + ", gender=" + gender + ", mobileNumber=" + mobileNumber + ", email=" + email + ", address="
				+ address + "]";
	}

}
