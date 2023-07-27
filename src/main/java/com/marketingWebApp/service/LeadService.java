package com.marketingWebApp.service;

import java.util.List;
import com.marketingWebApp.entity.Lead;

public interface LeadService {

	public void saveLead(Lead lead);
	public List<Lead> getAllLeads();
	public void deleteLeadById(long id);
	public Lead findLeadById(long id);
}
