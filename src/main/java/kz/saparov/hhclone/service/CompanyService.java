package kz.saparov.hhclone.service;

import kz.saparov.hhclone.model.CompanyModel;

public interface CompanyService {
	
	CompanyModel getById(Long id);
	
	CompanyModel getByHrId(Long id);
	
}
