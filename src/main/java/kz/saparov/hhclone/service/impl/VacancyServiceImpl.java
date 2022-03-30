package kz.saparov.hhclone.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kz.saparov.hhclone.entity.Vacancy;
import kz.saparov.hhclone.model.VacancyModel;
import kz.saparov.hhclone.repository.VacancyRepository;
import kz.saparov.hhclone.service.VacancyService;

@Service
public class VacancyServiceImpl implements VacancyService{
	
	@Autowired
	private VacancyRepository vacancyRepository;
	
	@Override
	public List<VacancyModel> getPersonalVacancyList(Long id) {		
		return vacancyRepository.findAll().stream()
				.map(VacancyModel::toModel)
				.collect(Collectors.toList());
	}
	
	@Override
	public Vacancy saveVacancy(Vacancy vacancy) {
		return vacancyRepository.save(vacancy);
	}
	
	@Override
	public Vacancy getById(Long id) {
		return vacancyRepository.findById(id)			
				.orElseGet(() -> new Vacancy());
	}

}
