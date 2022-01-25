package com.coforge.alpha.ssp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.coforge.alpha.ssp.Repository.ScholarshipRepository;
import com.coforge.alpha.ssp.Repository.StudentRepository;
//import com.coforge.alpha.ssp.exception.ResourceNotFoundException;
import com.coforge.alpha.ssp.model.Academics;
import com.coforge.alpha.ssp.model.Address;
import com.coforge.alpha.ssp.model.BankInfo;
import com.coforge.alpha.ssp.model.Document;
import com.coforge.alpha.ssp.model.Scholarship;
import com.coforge.alpha.ssp.model.Student;
import com.coforge.alpha.ssp.model.StudentInfo;

@RestController
@RequestMapping(value = "/student")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentRestController {
	
	@Autowired
	private StudentRepository sRepo;
	
	@Autowired
	private ScholarshipRepository scRepo;
	
	@GetMapping("/all")
	public List<StudentInfo> getStudent() {
		return sRepo.findStudent();
	}
	
	@GetMapping("/getOne/{email}")
	public StudentInfo getOneStudent(@PathVariable(value ="email") String email) {
		return sRepo.findByEmail(email);
	}
	
	
	@PostMapping("/add")
	public StudentInfo createStudent(@Validated @RequestBody StudentInfo studentinfo) {

		Student s = new Student();
		s.setFname(studentinfo.getFname());
		s.setLname(studentinfo.getLname());
		s.setGender(studentinfo.getGender());
		s.setAadharNumber(studentinfo.getAadharNumber());
		s.setDob(studentinfo.getDob());
		s.setEmail(studentinfo.getEmail());
		s.setMobNo(studentinfo.getMobNo());
		s.setPassword(studentinfo.getPassword());
		

		Address a = new Address();
		a.setStreet(studentinfo.getStreet());
		a.setCity(studentinfo.getCity());
		a.setState(studentinfo.getState());
		a.setPincode(studentinfo.getPincode());
		
		Academics academics = new Academics();
		academics.setHighestQual(studentinfo.getHighestQual());
		academics.setCollegeName(studentinfo.getCollegeName());
		academics.setRollNumber(studentinfo.getRollNumber());
		academics.setYear(studentinfo.getYear());
		academics.setPercentage(studentinfo.getPercentage());
		
		Document document = new Document();
		document.setFatherName(studentinfo.getFatherName());
		document.setMotherName(studentinfo.getMotherName());
		document.setCategory(studentinfo.getCategory());
		document.setFamilyIncome(studentinfo.getFamilyIncome());
		document.setIncomeCertiNo(studentinfo.getIncomeCertiNo());
		document.setDomicileCertiNo(studentinfo.getDomicileCertiNo());
		
		BankInfo bank = new BankInfo();
		bank.setAccNo(studentinfo.getAccNo());
		bank.setBankName(studentinfo.getBankName());
		bank.setIfscCode(studentinfo.getIfscCode());
		bank.setBankAddress(studentinfo.getBankAddress());
		
		Scholarship sc = new Scholarship();
		sc.setStatus("Pending");
		sc.setSCode(studentinfo.getSCode());
		
		s.setAddress(a);
		s.setAcademics(academics);
		s.setBankInfo(bank);
		s.setDocument(document);
		a.setStudent(s);
		academics.setStudent(s);
		document.setStudent(s);
		bank.setStudent(s);
		s.setScholarship(sc);
		sc.setStudent(s);
		
		sRepo.save(s);

		return studentinfo;
	}
	
	@PutMapping("/forward/{email}")
	public void forward(@Validated @PathVariable(value="email") String email) {
		
		Student s = sRepo.findItByEmail(email);
		Long id = s.getStudentId();
		
		String status="Forwarded";
		
		scRepo.updateStatusById(id, status);
	}
	
	@PutMapping("/reject/{email}")
	public void reject(@Validated @PathVariable(value="email") String email) {
		
		Student s = sRepo.findItByEmail(email);
		Long id = s.getStudentId();
		
		String status="Rejected";
		
		scRepo.updateStatusById(id, status);
	}
	
	@PostMapping("/apply/{email}")
	public void apply(@Validated @PathVariable(value="email") String email, @RequestParam("scode") String scode ) {
		
		Student s = sRepo.findItByEmail(email);
		Long id = s.getStudentId();
		
		String sCode=scode;
		
		scRepo.updateScodeById(id,sCode);
	}
	
	@PostMapping("/login")
	public Boolean loginStudent(@Validated @RequestBody Student student) {
		Boolean a = false;

		String email = student.getEmail();
		String password = student.getPassword();

		Student d = sRepo.findItByEmail(email);

		if (email.equals(d.getEmail()) && password.equals(d.getPassword())) {
			a = true;
		}
		return a;
	}
	
}
