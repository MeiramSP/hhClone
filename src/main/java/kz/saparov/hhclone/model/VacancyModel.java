package kz.saparov.hhclone.model;

import kz.saparov.hhclone.entity.Vacancy;

public class VacancyModel {
	private Long id;
	private String title;
	private String describe;
	private Long salary;
	private boolean response;
	
	public static VacancyModel toModel(Vacancy vacancy) {
		VacancyModel model = new VacancyModel();
		model.setId(vacancy.getId());
		model.setTitle(vacancy.getTitle());
		model.setDescribe(vacancy.getDescribe());
		model.setSalary(vacancy.getSalary());
		return model;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public Long getSalary() {
		return salary;
	}
	public void setSalary(Long salary) {
		this.salary = salary;
	}
	public boolean isResponse() {
		return response;
	}
	public void setResponse(boolean response) {
		this.response = response;
	}
	
}
