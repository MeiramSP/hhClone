package kz.saparov.hhclone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kz.saparov.hhclone.entity.Vacancy;
import kz.saparov.hhclone.service.VacancyService;

@Controller
@RequestMapping("vacancies")
public class VacanciesController {
	
	@Autowired
	private VacancyService vacancyService;
	
	@ResponseBody
	@GetMapping("/{id}")
	public Vacancy getVacancyById(@PathVariable("id") Long id) {
		return vacancyService.getById(id);
	}

}
