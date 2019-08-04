package com.neu.entity;

public class Storey {
private String storey;
private String storeyname;
public String getStorey() {
	return storey;
}
public void setStorey(String storey) {
	this.storey = storey;
}
public String getStorename() {
	return storeyname;
}
public void setStorename(String storename) {
	this.storeyname = storename;
}
public Storey(String storey, String storename) {
	super();
	this.storey = storey;
	this.storeyname = storename;
}
public Storey() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Storey [storey=" + storey + ", storename=" + storeyname + "]";
}

}
