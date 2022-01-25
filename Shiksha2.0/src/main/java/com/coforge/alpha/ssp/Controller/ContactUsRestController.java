package com.coforge.alpha.ssp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coforge.alpha.ssp.Exception.ResourceNotFoundException;
import com.coforge.alpha.ssp.Repository.ContactUsRepository;
import com.coforge.alpha.ssp.model.ContactUs;

@RestController
@RequestMapping("/contact")
@CrossOrigin(origins = "http://localhost:4200")
public class ContactUsRestController {

	@Autowired
	private ContactUsRepository contactUsRepository;
	
	@PostMapping("/add")
    public ContactUs saveContact(@Validated @RequestBody ContactUs contact) {
		
		return contactUsRepository.save(contact);
	}
	
	@GetMapping("/all")
	public List<ContactUs> getAllSchemes(){
		
		return contactUsRepository.findAll();
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteProduct(@PathVariable(value ="id") Long pId,
			@Validated @RequestBody ContactUs contact) 
					throws ResourceNotFoundException{
		
		ContactUs c = contactUsRepository.findById(pId).orElseThrow(() -> 
		new ResourceNotFoundException("Info not found for this id :: " + pId));
		
		contactUsRepository.delete(c); //invokes delete method of JPA repository		
	}
	
}
