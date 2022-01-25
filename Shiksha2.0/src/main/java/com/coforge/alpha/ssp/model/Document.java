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
@Table(name="document")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Document {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String fatherName;
	private String motherName;
	
	private double familyIncome;
	private double incomeCertiNo;
	
	private String category;
	private double domicileCertiNo;
	
	@OneToOne
	@JoinColumn(name = "studentId")
	private Student student;

}
