package model;

import java.io.Serializable;

import javax.swing.JTextField;

public class Person implements Serializable {

	private String name;
	private String idNumber;
	private String phoneNum;
	private String address;
	private String zipCode;
	private String gender;
	private String campus;
	
	public Person(String name, String idNumber,
			String phoneNum, String address, 
			String zipCode, String gender, String campus) throws IllegalInput {
		this.name = name;
		this.idNumber = idNumber;
		this.phoneNum = phoneNum;
		this.address = address;
		this.zipCode = zipCode;
		this.idNumber = idNumber;
		this.phoneNum = phoneNum;
		this.zipCode = zipCode;
		this.gender = gender;
		this.campus = campus;
	}
	
	public String getName() {
		return name;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public String getAddress() {
		return address;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
		
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipCode() {
		return zipCode;
	}
	
	public String getGender() {
		return gender;
	}
	
	@Override
	public String toString() {
		return "Student Name: " + getName() +
				"\nStudent ID: " + getIdNumber() +
				"\nPhone Number: " + getPhoneNum() +
				"\nAddress: " + getAddress() +
				"\nZip Code: " + getZipCode() +
				"\nGender: " + getGender() +
				"\nCampus: " + getCampus();
	}

	public String getCampus() {
		return campus;
	}

	public void setCampus(String campus) {
		this.campus = campus;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
}
