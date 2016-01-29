package model;


import java.io.Serializable;

public class Student extends Person implements Serializable {

	private String major;
	private String gpa;
	
	public Student(String name, String idNumber, String phoneNum, String address, 
			String zipCode, String gender, String major, String gpa, String campus) throws IllegalInput {
		super(name, idNumber, phoneNum, address, zipCode, gender, campus);
		this.major = major;
		this.gpa = gpa;
	}
	
	public String getMajor() {
		return major;
	}

	public String getGpa() {
		return gpa;
	}
	


	@Override
	public String toString() {
		return super.toString() +
				"\nMajor: " + getMajor() +
				"\nGPA: " + getGpa();
	}
	
}
