package com.coforge.alpha.ssp.model;

import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="student")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long StudentId;
	
	private String fname;
	private String lname;
	private String gender;
	
	@Column(unique = true)
	private double aadharNumber;
	
	@Column(unique = true)
	private String email;
	
	@Column(unique = true)
	private double mobNo;
	
	private String password;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dob;
	
	@OneToOne(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Address address;
	
	@OneToOne(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Academics academics;
	
	@OneToOne(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private BankInfo bankInfo;
	
	@OneToOne(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Document document;
	
	@OneToOne(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Scholarship scholarship;
		
	
}
