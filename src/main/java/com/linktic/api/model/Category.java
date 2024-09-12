package com.linktic.api.model;

//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;

//@ApiModel(description = "Entity that representation category in the project")
public class Category {

	//@ApiModelProperty(value = "primary key category identifier", required = true)
	private Integer categoryId;

	//@ApiModelProperty(value = "category name identifier")
	private String categoryName;

	//@ApiModelProperty(value = "description category")
	private String description;
	
	public Category() {}

	public Category(Integer categoryId, String categoryName, String description) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.description = description;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
