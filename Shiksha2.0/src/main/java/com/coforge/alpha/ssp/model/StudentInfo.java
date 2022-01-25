package com.coforge.alpha.ssp.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentInfo {
	
	private String fname;
	private String lname;
	private String gender;
	private double aadharNumber;
	private String email;
	private double mobNo;
	
	private String password;
	private Date dob;
	
	private String fatherName;
	private String motherName;
	
	private String street;
	private String city;
	private String state;
	private int pincode;
	
	private double familyIncome;
	private double incomeCertiNo;
	
	private String category;
	private double domicileCertiNo;
	
	private String highestQual;
	private String collegeName;
	private double rollNumber;
	private double percentage;
	private int year;
	
	private double accNo;
	private String bankName;
	private String ifscCode;
	private String bankAddress;
	
	private String status;
	private String sCode;
		
}
	
