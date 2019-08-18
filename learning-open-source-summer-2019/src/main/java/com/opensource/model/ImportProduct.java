package com.opensource.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "import_product")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class ImportProduct implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	@JoinColumn(name="import_id")
	private Import imports;
	
	@Override
	public String toString() {
		return "ImportProduct [id=" + id + ", imports=" + imports + ", product=" + product + "]";
	}

	public Import getImports() {
		return imports;
	}

	public void setImports(Import imports) {
		this.imports = imports;
	}

	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;

	public ImportProduct() {
		super();
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public ImportProduct(Import imports, Product product) {
		super();
		this.imports = imports;
		this.product = product;
	}

}
