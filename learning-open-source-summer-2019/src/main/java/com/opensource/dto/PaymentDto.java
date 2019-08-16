package com.opensource.dto;

import java.util.ArrayList;
import java.util.List;

import com.opensource.model.Payment;
import com.opensource.model.PaymentProduct;

public class PaymentDto {

	private long paymentId;

	public long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}

	private String productName;
	private String customerName;
	private String phone;
	private String address;
	private String postcode;
	private String date;
	private String total;
	private int status;

	public PaymentDto() {
		super();
	}
	
	public PaymentDto(long paymentId, int status) {
		this.paymentId=paymentId;
		this.status=status;
	}

	public PaymentDto(Payment payment) {
		super();
		this.paymentId=payment.getId();
		List<PaymentProduct> list = new ArrayList<PaymentProduct>(payment.getPaymentProduct());
		if (payment.getPaymentProduct().isEmpty()) {
			this.productName = "ok";
		} else {
			this.productName = list.get(0).getProduct().getName();
		}
		this.customerName = payment.getUser().getUserInfo().getLastName()
				+ payment.getUser().getUserInfo().getFirstName();
		this.phone = payment.getUser().getUserInfo().getPhone();
		this.address = payment.getAddress();
		this.postcode = payment.getPostcode();
		this.date = payment.getDate();
		this.total = payment.getTotal();
		this.status = payment.getStatus();
	}

	@Override
	public String toString() {
		return "PaymentDto [productName=" + productName + ", customerName=" + customerName + ", phone=" + phone
				+ ", address=" + address + ", postcode=" + postcode + ", date=" + date + ", total=" + total
				+ ", status=" + status + "]";
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
