package com.marketingWebApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import com.marketingWebApp.DTO.LeadDto;
import com.marketingWebApp.entity.Lead;
import com.marketingWebApp.repository.LeadRepository;

@RestController
@RequestMapping("/api/leads")
public class LeadRestController {

	@Autowired
	private LeadRepository leadRepo;
	
	//http://localhost:9090/api/leads
	@GetMapping()
	public List<Lead>getAllLeads(){
		List<Lead> leads = leadRepo.findAll();
		return leads;
	}
	 @PostMapping
	 public void createLead(@RequestBody Lead lead) {
		 leadRepo.save(lead);
	 }
	 @DeleteMapping("/{id}")
	 public void deleteLead(@PathVariable long id) {
		 leadRepo.deleteById(id);
	 }
	 @PutMapping("/{id}")
	 public void updateLead(@RequestBody LeadDto dto,@PathVariable long id) {
		 Lead l=new Lead();
		 l.setId(dto.getId());
		 l.setFirstName(dto.getFirstName());
		 l.setLastName(dto.getLastName());
		 l.setEmail(dto.getEmail());
		 l.setMobile(dto.getMobile());
		 leadRepo.save(l);
	 }
}
