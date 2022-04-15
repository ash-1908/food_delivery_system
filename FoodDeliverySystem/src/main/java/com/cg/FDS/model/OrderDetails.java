package com.cg.FDS.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "orderdetails_tbl")
public class OrderDetails {

	@Id
	@Column(name = "order_id", length = 10)
	private Integer orderId;

	@DateTimeFormat(style = "dd:MM:yy")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss[.SSS][.SS][.S]")
	@Column(name = "order_date", length = 20)
	private LocalDateTime orderDate;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cart_id")
	private FoodCart cart;

	@Column(name = "status", length = 20)
	private String orderStatus;

	public OrderDetails() {

	}

	public OrderDetails(Integer orderId, LocalDateTime orderDate, FoodCart cart, String orderStatus) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.cart = cart;
		this.orderStatus = orderStatus;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public FoodCart getCart() {
		return cart;
	}

	public void setCart(FoodCart cart) {
		this.cart = cart;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Override
	public String toString() {
		return "OrderDetails [orderId=" + orderId + ", orderDate=" + orderDate + ", orderStatus=" + orderStatus + "]";
	}

}
