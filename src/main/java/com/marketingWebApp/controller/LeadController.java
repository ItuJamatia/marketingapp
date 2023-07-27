package com.marketingWebApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.marketingWebApp.DTO.LeadDto;
import com.marketingWebApp.entity.Lead;
import com.marketingWebApp.service.LeadService;
import com.marketingWebApp.utility.EmailService;

@Controller
public class LeadController {

	//http://localhost:9090/create
	@RequestMapping("/create")
	public String viewCreateLead() {
		return "create_lead";
	}	
	@Autowired
	private LeadService leadService;
	
	@Autowired
	private EmailService emailService;
	
	@RequestMapping("/saveLead")
	public String saveLead(@ModelAttribute Lead lead,Model model) {
		leadService.saveLead(lead);
		emailService.sendEmail(lead.getEmail(), "Test", "Hello");
		model.addAttribute("msg", "Record is saved! Please check you email");
		return "create_lead";
	}
	//http://localhost:9090/listAll
	@RequestMapping("/listAll")
	public String getAllLeads(ModelMap model) {
		List<Lead> leads = leadService.getAllLeads();
		model.addAttribute("leads",leads);
		return "search_result";
	}
	@RequestMapping("/delete")
	public String deleteLeadById(@RequestParam long id,Model model) {
		leadService.deleteLeadById(id);
		model.addAttribute("msg", "Record is deleted");
		List<Lead> leads = leadService.getAllLeads();
		model.addAttribute("leads",leads);
		return "search_result";	
	}
	@RequestMapping("/update")
	public String findLeadById(@RequestParam long id,Model model) {
		Lead lead=leadService.findLeadById(id);
		model.addAttribute("lead",lead);
		return "update_lead";	
	}
	@RequestMapping("/updateLead")
	public String updateLeadById(LeadDto dto,Model model) {
		
		Lead l=new Lead();
		l.setId(dto.getId());
		l.setFirstName(dto.getFirstName());
		l.setLastName(dto.getLastName());
		l.setEmail(dto.getEmail());
		l.setMobile(dto.getMobile());
		
		leadService.saveLead(l);
		List<Lead> leads = leadService.getAllLeads();
		model.addAttribute("leads",leads);
		return "search_result";		
	}
//	@RequestMapping("/saveLead")
//	public String saveLead(LeadDto leadDto) {
//		
//		Lead lead=new Lead();
//		lead.setFirstName(leadDto.getFirstName());
//		lead.setLastName(leadDto.getLastName());
//		lead.setEmail(leadDto.getEmail());
//		lead.setMobile(leadDto.getMobile());
//		leadService.saveLead(lead);
//		return "create_lead";
//	}
//	@RequestMapping("/saveLead")
//	public String saveLead(@RequestParam("firstName") String firstName,
//			@RequestParam("lastName") String lastName,
//			@RequestParam("email") String email,
//			@RequestParam("mobile") long mobile) {
//		
//		Lead lead=new Lead();
//		lead.setFirstName(firstName);
//		lead.setLastName(lastName);
//		lead.setEmail(email);
//		lead.setMobile(mobile);
//		leadService.saveLead(lead);
//		return "create_lead";
//	}
}
