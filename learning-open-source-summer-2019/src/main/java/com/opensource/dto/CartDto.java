package com.opensource.dto;

import com.opensource.model.CartProduct;

public class CartDto {

	private String name;
	private String price;
	private String quantity;
	private String total;
	private String image;
	

	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	public String getQuantity() {
		return quantity;
	}


	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}


	public String getTotal() {
		return total;
	}


	public void setTotal(String total) {
		this.total = total;
	}


	public CartDto(CartProduct item){
		super();
		this.name = item.getProduct().getName();
		this.price = String.valueOf((int)(item.getProduct().getPrice()));
		if(item.getQuantity()==null) {
			this.quantity = String.valueOf("0");
			this.total = String.valueOf("0");
		}else {
			this.quantity = item.getQuantity();
			this.total = String.valueOf((int)(item.getProduct().getPrice()*Float.parseFloat(item.getQuantity())));
		}
		this.image = item.getProduct().getImage();
	}
}
