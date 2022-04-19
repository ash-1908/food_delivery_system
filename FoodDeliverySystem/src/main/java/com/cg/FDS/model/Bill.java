package com.cg.FDS.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "bill_tbl")
public class Bill {
	@Id
	@Column(name = "billId", length = 20)
	private String billId;
	// @JsonSerialize(using = LocalDateSerializer.class)
	// @JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime billDate;
	private Integer totalItem;
	private Double totalCost;

	@OneToOne
	private OrderDetails order;

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
