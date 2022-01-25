package com.coforge.alpha.ssp.Repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.coforge.alpha.ssp.model.Student;
import com.coforge.alpha.ssp.model.StudentInfo;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

	
	@Query("select new com.coforge.alpha.ssp.model.StudentInfo(s.fname, s.lname,s.gender,s.aadharNumber, s.email,"
			+ "s.mobNo, s.password, s.dob, doc.fatherName , doc.motherName, a.street,a.city,a.state,a.pincode, doc.familyIncome, doc.incomeCertiNo, doc.category,"
			+ "doc.domicileCertiNo, acd.highestQual, acd.collegeName, acd.rollNumber,"
			+ "acd.percentage, acd.year, b.accNo, b.bankName, b.ifscCode,"
			+ "b.bankAddress, sc.status,sc.sCode) from Student s Inner Join s.address a Inner Join s.document doc Inner Join s.bankInfo b Inner Join s.academics acd Inner Join s.scholarship sc Where s.email =:email")
	public StudentInfo findByEmail(@Param("email")String email);//custom repository method
		
	
	public Student findItByEmail(String email);
	
	// custom query using JPQL in CRUD repository 
	@Query("select new com.coforge.alpha.ssp.model.StudentInfo(s.fname, s.lname,s.gender, s.aadharNumber,s.email,"
			+ "s.mobNo, s.password, s.dob, doc.fatherName , doc.motherName, a.street,a.city,a.state,a.pincode, doc.familyIncome, doc.incomeCertiNo, doc.category,"
			+ "doc.domicileCertiNo, acd.highestQual, acd.collegeName, acd.rollNumber,"
			+ "acd.percentage, acd.year, b.accNo, b.bankName, b.ifscCode,"
			+ "b.bankAddress,sc.status,sc.sCode) from Student s Inner Join s.address a Inner Join s.document doc Inner Join s.bankInfo b Inner Join s.academics acd Inner Join s.scholarship sc")
	public List<StudentInfo> findStudent();

	
	
}
