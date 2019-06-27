package com.esfirst.Resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.esfirst.Repo.StaffRepository;
import com.esfirst.model.Staff;

@RestController
public class StaffController {
	
	@Autowired
	private StaffRepository repository;
	
      @PostMapping("/addStaff")
	  public String saveStaff(@Valid @RequestBody Staff staff){
   	  java.util.Optional<Staff> s = repository.findById(staff.getId());
  	  if(s.isPresent()) {
  	  return "Id already exists";
  	  }
  	  { java.util.Optional<Staff> s1 =repository.findByEmail(staff.getEmail());
    	 if(s1.isPresent()) {
    		  return "This Email Already Exists";
    	 }
		repository.save(staff);
		return "Added Staff with id : "+staff.getId();
  	  }
  	  	
    }
	@GetMapping("/findAllStaff")
	public Iterable<Staff> getStaff(){
		return repository.findAll();
	}
	@GetMapping("findAllStaff/{id}")
	public java.util.Optional<Staff> getStaff(@PathVariable int id){
		return repository.findById(id);
	}
   //@GetMapping("findAllStaff/{Email}")
	//  public 	java.util.List<Staff>getStaff(@PathVariable String Email){
	//	return repository.findByEmail(Email);
	//}
	
   @DeleteMapping("/delete/{id}")
	public String deleteStaff(@PathVariable int id){
		repository.deleteById(id);
		return "Staff deleted with id :"+id;
	}
}
