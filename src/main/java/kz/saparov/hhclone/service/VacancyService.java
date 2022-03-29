package kz.saparov.hhclone.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kz.saparov.hhclone.entity.Vacancy;
import kz.saparov.hhclone.model.VacancyModel;
import kz.saparov.hhclone.repository.VacancyRepository;

@Service
public class VacancyService {
	
	@Autowired
	private VacancyRepository vacancyRepository;
	
	public List<VacancyModel> getPersonalVacancyList(Long id) {		
		return vacancyRepository.findAll().stream()
				.map(VacancyModel::toModel)
				.collect(Collectors.toList());
	}
	
	public Vacancy saveVacancy(Vacancy vacancy) {
		return vacancyRepository.save(vacancy);
	}
	
	public Vacancy getById(Long id) {
		return vacancyRepository.findById(id)			
				.orElseGet(() -> new Vacancy());
	}
	
}
