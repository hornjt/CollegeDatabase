package model;

import java.io.Serializable;
import java.text.DecimalFormat;

public class FullTimeStudent extends Student implements Serializable {
	
	private String tuition;
	DecimalFormat payFormat = new DecimalFormat("###,###.##");
	DecimalFormat phoneFormat = new DecimalFormat("###-###-####");
	
	public FullTimeStudent(String name, String idNumber, 
			String phoneNum, String address, String zipCode, 
			String gender, String campus, String major, String gpa,  
			String tuition) throws IllegalInput {
		super(name, idNumber, phoneNum, address, zipCode, gender,
				campus, major, gpa);
		this.tuition = tuition;
	}
	
	public String getTuition() {
		return tuition;
	}

	public void setTuition(String tuition) {
		this.tuition = tuition;
	}

	@Override
	public String toString() {
		return super.toString() + "\n" +
				"Tuition: " + getTuition();
	}
	
	

}
