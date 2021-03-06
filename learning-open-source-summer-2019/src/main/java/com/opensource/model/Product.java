package com.opensource.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "product")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Product implements Serializable {

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", size=" + size + ", price=" + price
				+ ", description=" + description + ", quantity=" + quantity + ", image=" + image + ", category="
				+ category + ", provider=" + provider + "]";
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "product_id", nullable = false)
	private long productId;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "size", nullable = false)
	private String size;

	@Column(name = "price", nullable = false)
	private float price;

	@Column(name = "description")
	private String description;

	@Column(name = "quantity", nullable = false)
	private String quantity;

	@Column(name = "image", nullable = false)
	private String image;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	private Category category;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "provider_id")
	private Provider provider;
	
	@OneToMany(mappedBy = "product")
	private Set<CartProduct> cartProducts;
	
	@OneToMany(mappedBy = "product")
	private Set<PaymentProduct> paymentProducts;

	public Product() {
		super();
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public Set<CartProduct> getCartProducts() {
		return cartProducts;
	}

	public void setCartProducts(Set<CartProduct> cartProducts) {
		this.cartProducts = cartProducts;
	}

	public Product(String name, String size, float price, String description, String quantity, String image) {
		super();
		this.name = name;
		this.size = size;
		this.price = price;
		this.description = description;
		this.quantity = quantity;
		this.image = image;
	}

	public Product(long productId, String name, String size, float price, String description, String quantity,
			String image) {
		super();
		this.productId = productId;
		this.name = name;
		this.size = size;
		this.price = price;
		this.description = description;
		this.quantity = quantity;
		this.image = image;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
