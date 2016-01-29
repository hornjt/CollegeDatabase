package model;

import java.io.Serializable;
import java.text.DecimalFormat;


public class AdjunctFaculty extends Faculty implements Serializable{

	private String credits;
	DecimalFormat payFormat = new DecimalFormat("###,###.##");
	
	public AdjunctFaculty(String name, String idNumber, String phoneNum,
			String address, String zipCode, String gender, String campus,
			String department, String credits) throws IllegalInput {
		super(name, idNumber, phoneNum, address, zipCode, gender, campus, department);
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
				"\nCredits: " + credits;
	}
}
