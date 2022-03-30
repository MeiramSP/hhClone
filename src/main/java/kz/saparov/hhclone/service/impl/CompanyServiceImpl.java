package kz.saparov.hhclone.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kz.saparov.hhclone.model.CompanyModel;
import kz.saparov.hhclone.repository.CompanyRepository;
import kz.saparov.hhclone.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService{
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Override
	public CompanyModel getById(Long id) {
		return companyRepository.findById(id)
				.map(CompanyModel::toModel).orElseGet(() -> new CompanyModel());		
	}

	@Override
	public CompanyModel getByHrId(Long id) {			
		return companyRepository.findByHrId(id)
				.map(CompanyModel::toModel).orElseGet(() -> new CompanyModel());					
	}
}
