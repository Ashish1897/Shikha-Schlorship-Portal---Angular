package com.coforge.alpha.ssp.model;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name="scholarship")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Scholarship {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String status;
	
	@Column(unique = true)
	private String sCode;
	
	
	
	@OneToOne
	@JoinColumn(name = "studentId")
	private Student student;
}
