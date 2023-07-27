package com.marketingWebApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marketingWebApp.entity.Lead;

public interface LeadRepository extends JpaRepository<Lead, Long>{

}
