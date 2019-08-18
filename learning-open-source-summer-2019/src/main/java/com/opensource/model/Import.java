package com.opensource.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "import")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Import {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "import_id", nullable = false)
	private long importId;

	@Column(name = "import_date", nullable = false)
	private String importDate;
	
	@Column(name="total_price")
	private String totalPrice;

	@Override
	public String toString() {
		return "Import [importId=" + importId + ", importDate=" + importDate + ", totalPrice=" + totalPrice + "]";
	}

	public Import() {
		super();
	}

	public Import(long importId, String importDate, String totalPrice) {
		super();
		this.importId = importId;
		this.importDate = importDate;
		this.totalPrice = totalPrice;
	}
	
	

	public long getImportId() {
		return importId;
	}

	public void setImportId(long importId) {
		this.importId = importId;
	}

	public String getImportDate() {
		return importDate;
	}

	public void setImportDate(String importDate) {
		this.importDate = importDate;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
}
