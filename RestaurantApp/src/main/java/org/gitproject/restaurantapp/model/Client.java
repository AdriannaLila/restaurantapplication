package org.gitproject.restaurantapp.model;

public class Client {

private	String name;
private	String phoneNr;
private String address;
private String zipCode;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPhoneNr() {
	return phoneNr;
}
public void setPhoneNr(String phoneNr) {
	this.phoneNr = phoneNr;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getZipCode() {
	return zipCode;
}
public void setZipCode(String zipCode) {
	this.zipCode = zipCode;
}
public Client(String name, String phoneNr, String address, String zipCode) {
	this.name = name;
	this.phoneNr = phoneNr;
	this.address = address;
	this.zipCode = zipCode;
}

}
