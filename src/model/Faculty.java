package model;


import java.io.Serializable;

public class Faculty extends Person implements Serializable {
	
	private String department;
	private String campus;
	
	public Faculty(String name, String idNumber, String phoneNum, 
			String address, String zipCode, String gender,String campus, String department) throws IllegalInput {
		super(name, idNumber, phoneNum, address, zipCode, gender, campus);
		this.department = department;
	}
	
	@Override
	public String toString() {
		return super.toString() +
				"\nDepartment: " + department;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
}
