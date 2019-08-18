package com.opensource.dto;

import com.opensource.model.ImportProduct;

public class ImportProductDto {

	private long importId;
	private String productName;
	private String size;
	private float price;
	private String importQuantity;
	private String providerName;
	private String importDate;
	
	@Override
	public String toString() {
		return "ImportProductDto [importId=" + importId + ", productName=" + productName + ", size=" + size + ", price="
				+ price + ", importQuantity=" + importQuantity + ", providerName=" + providerName + ", importDate="
				+ importDate + "]";
	}
	public ImportProductDto() {
		super();
	}
	public ImportProductDto(ImportProduct importProduct) {
		this.importId =importProduct.getImports().getImportId() ;
		this.productName = importProduct.getProduct().getName();
		this.size = importProduct.getProduct().getSize();
		this.price=importProduct.getProduct().getPrice();
		this.importQuantity = importProduct.getProduct().getQuantity();
		this.providerName = importProduct.getProduct().getProvider().getName();
		this.importDate = importProduct.getImports().getImportDate();
	}
	
	
	public ImportProductDto(String productName, String size, float price, String importQuantity, String providerName,
			String importDate) {
		super();
		this.productName = productName;
		this.size = size;
		this.price = price;
		this.importQuantity = importQuantity;
		this.providerName = providerName;
		this.importDate = importDate;
	}
	
	public ImportProductDto(long importId, String productName, String size, float price, String importQuantity,
			String providerName, String importDate) {
		super();
		this.importId = importId;
		this.productName = productName;
		this.size = size;
		this.price = price;
		this.importQuantity = importQuantity;
		this.providerName = providerName;
		this.importDate = importDate;
	}
	public long getImportId() {
		return importId;
	}
	public void setImportId(long importId) {
		this.importId = importId;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getImportQuantity() {
		return importQuantity;
	}
	public void setImportQuantity(String importQuantity) {
		this.importQuantity = importQuantity;
	}
	public String getProviderName() {
		return providerName;
	}
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	public String getImportDate() {
		return importDate;
	}
	public void setImportDate(String importDate) {
		this.importDate = importDate;
	}
	
	
}
