package kz.saparov.hhclone.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "companies")
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "company_id")
	private Long id;
	
	@Column(name = "company_name", length = 100, nullable = false)
	private String name;
	
	@OneToMany(mappedBy = "company")
	private List<Vacancy> vacancies;
	
	@OneToMany
	@JoinColumn(name = "company_id")
	private List<User> hrManagers;
	
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

	public List<Vacancy> getVacancies() {
		return vacancies;
	}

	public void setVacancies(List<Vacancy> vacancies) {
		this.vacancies = vacancies;
	}

	public List<User> getHrManagers() {
		return hrManagers;
	}

	public void setHrManagers(List<User> hrManagers) {
		this.hrManagers = hrManagers;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + "]";
	}
}
