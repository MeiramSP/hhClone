package kz.saparov.hhclone.service;

import java.util.List;

import kz.saparov.hhclone.entity.Vacancy;
import kz.saparov.hhclone.model.VacancyModel;

public interface VacancyService {
	
	public List<VacancyModel> getPersonalVacancyList(Long id);	
	
	public Vacancy saveVacancy(Vacancy vacancy);
	
	public Vacancy getById(Long id); 
	

}
