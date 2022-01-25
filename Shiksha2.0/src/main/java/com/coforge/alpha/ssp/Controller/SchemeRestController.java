package com.coforge.alpha.ssp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.coforge.alpha.ssp.Exception.ResourceNotFoundException;
import com.coforge.alpha.ssp.Repository.SchemeRepository;
import com.coforge.alpha.ssp.model.ContactUs;
import com.coforge.alpha.ssp.model.Schemes;

@RestController
@RequestMapping(value = "/scheme")
@CrossOrigin(origins = "http://localhost:4200")
public class SchemeRestController {

	@Autowired
	private SchemeRepository schemeRepository;
	
	@PostMapping("/add")
    public Schemes saveScheme(@Validated @RequestBody Schemes schemes) {
		
		return schemeRepository.save(schemes);
	}
	
	@GetMapping("/all")
	public List<Schemes> getAllSchemes(){
		
		return schemeRepository.findAll();
	}
	
	@GetMapping("/get/{scode}")
	public double getAmount(@PathVariable(value="scode") String scode) {
		return schemeRepository.findByScode(scode);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteScheme(@PathVariable(value ="id") Long pId,
			@Validated @RequestBody Schemes scheme) 
					throws ResourceNotFoundException{
		
		Schemes s = schemeRepository.findById(pId).orElseThrow(() -> 
		new ResourceNotFoundException("Info not found for this id :: " + pId));
		
		schemeRepository.delete(s); //invokes delete method of JPA repository		
	}
}
