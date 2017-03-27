package com.order.model;

public class Order {

	private int orderId;
	private String orderType;

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	private String orderName;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderType=" + orderType + ", orderName=" + orderName + "]";
	}

	
}

