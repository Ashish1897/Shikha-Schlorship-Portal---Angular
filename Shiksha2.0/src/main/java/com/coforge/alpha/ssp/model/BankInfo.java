package com.coforge.alpha.ssp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="bank")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BankInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private double accNo;
	private String bankName;
	private String ifscCode;
	private String bankAddress;
	
	@OneToOne
	@JoinColumn(name = "studentId")
	private Student student;

}
