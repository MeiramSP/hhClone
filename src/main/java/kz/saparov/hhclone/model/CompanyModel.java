package kz.saparov.hhclone.model;

import java.util.List;
import java.util.stream.Collectors;

import kz.saparov.hhclone.entity.Company;

public class CompanyModel {
	
	private Long id;
	private String name;
	private List<VacancyModel> vacancies;
	
	public static CompanyModel toModel(Company company) {
		CompanyModel model = new CompanyModel();
		model.setId(company.getId());
		model.setName(company.getName());
		
		model.setVacancies(company.getVacancies().stream()
				.map(VacancyModel::toModel)
				.collect(Collectors.toList())
		);
		
		return model;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<VacancyModel> getVacancies() {
		return vacancies;
	}
	public void setVacancies(List<VacancyModel> vacancies) {
		this.vacancies = vacancies;
	}	
}
