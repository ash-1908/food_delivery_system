package com.cg.FDS.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class Category {
	@Id
	@Column(name = "catId",length=20)
	private String catId;
	@Column(name = "categoryName",length=20)
	private String categoryName;
	
	@OneToOne
	Item item;
	
	public Category(String catId, String categoryName) {
		super();
		this.catId = catId;
		this.categoryName = categoryName;
	}
	public Category() {
		super();
	}
	public String getCatId() {
		return catId;
	}
	public void setCatId(String catId) {
		this.catId = catId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	@Override
	public String toString() {
		return "Category [catId=" + catId + ", categoryName=" + categoryName + "]";
	}
	
	

}
