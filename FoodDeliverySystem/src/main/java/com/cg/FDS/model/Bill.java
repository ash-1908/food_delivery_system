package com.cg.FDS.model;

import java.time.LocalDateTime;

public class Bill {
	private String billId;
	private LocalDateTime billDate;
	private OrderDetails order;
	private Integer totalItem;
	private Double totalCost;
	
	public Bill() {
		
	}

	public Bill(String billId, LocalDateTime billDate, OrderDetails order, Integer totalItem, Double totalCost) {
		super();
		this.billId = billId;
		this.billDate = billDate;
		this.order = order;
		this.totalItem = totalItem;
		this.totalCost = totalCost;
	}

	public String getBillId() {
		return billId;
	}

	public void setBillId(String billId) {
		this.billId = billId;
	}

	public LocalDateTime getBillDate() {
		return billDate;
	}

	public void setBillDate(LocalDateTime billDate) {
		this.billDate = billDate;
	}

	public OrderDetails getOrder() {
		return order;
	}

	public void setOrder(OrderDetails order) {
		this.order = order;
	}

	public Integer getTotalItem() {
		return totalItem;
	}

	public void setTotalItem(Integer totalItem) {
		this.totalItem = totalItem;
	}

	public Double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}

	@Override
	public String toString() {
		return "Bill [billId=" + billId + ", billDate=" + billDate + ", order=" + order + ", totalItem=" + totalItem
				+ ", totalCost=" + totalCost + "]";
	}
	
	
}
