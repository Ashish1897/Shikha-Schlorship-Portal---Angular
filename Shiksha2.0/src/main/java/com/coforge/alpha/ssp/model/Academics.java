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
@Table(name="academics")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Academics {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String highestQual;
	private String collegeName;
	private double rollNumber;
	private double percentage;
	private int year;
	
	@OneToOne
	@JoinColumn(name = "studentId")
	private Student student;
}
