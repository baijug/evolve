package com.baiju.evolve.data;

public class MenuData {
	
	private int order;
	private String type;
	private String description;
	private boolean isMandatory;
	private boolean isMultipleAllow;
	
	public MenuData(int order, String type, String description, boolean isMandatory, boolean isMultipleAllow) {
		this.order = order;
		this.type = type;
		this.description = description;
		this.isMandatory = isMandatory;
		this.isMultipleAllow = isMultipleAllow;
	}
	
	public boolean isMultipleAllow() {
		return isMultipleAllow;
	}
	public void setMultipleAllow(boolean isMultipleAllow) {
		this.isMultipleAllow = isMultipleAllow;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isMandatory() {
		return isMandatory;
	}
	public void setMandatory(boolean isMandatory) {
		this.isMandatory = isMandatory;
	}
	
}
