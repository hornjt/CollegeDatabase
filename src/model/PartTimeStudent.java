package model;

import java.io.Serializable;
import java.text.DecimalFormat;


public class PartTimeStudent extends Student implements Serializable {

	private String credits;
	//private double tuition;
	DecimalFormat payFormat = new DecimalFormat("###,###.##");
	
	public PartTimeStudent(String name, String idNumber, String phoneNum,
			String address, String zipCode, String gender, String campus, String major, String gpa, String credits) throws IllegalInput {
		super(name, idNumber, phoneNum, address, zipCode, gender,
				campus, major, gpa);
		this.credits = credits;
	}

	public String getCredits() {
		return credits;
	}

	public void setCredits(String credits) {
		this.credits = credits;
	}

	@Override
	public String toString() {
		return super.toString() +
				"\nCredits: " + getCredits();
	}
}
