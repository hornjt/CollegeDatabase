package model;

import java.io.Serializable;
import java.text.DecimalFormat;

public class FullTimeFaculty extends Faculty implements Serializable {

	private String pay;
	
	DecimalFormat payFormat = new DecimalFormat("###,###.##");
	
	public FullTimeFaculty(String name, String idNumber, String phoneNum,
			String address, String zipCode, String gender, String campus,
			String department,  String pay) throws IllegalInput {
		super(name, idNumber, phoneNum, address, zipCode, gender, campus, department);
		this.pay = pay;
	}

	public String getPay() {
		return pay;
	}

	public void setPay(String pay) {
		this.pay = pay;
	}
	
	@Override
	public String toString() {
		return super.toString() +
				"\nPay: " + pay;
	}
}
