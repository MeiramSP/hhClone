package kz.saparov.hhclone.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Vacancy {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "vacancy_id")
	private Long id;
	
	@Column(name = "title", length = 100, nullable = false)
	private String title;
	
	@Column(name = "describe", length = 2000)
	private String describe;
	
	@Column(name = "visible")
	private boolean visible;
	
	@Column(name = "salary")
	private Long salary;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="company_id", nullable=false)
	private Company company;

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
	
	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	@JsonIgnore
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Vacancy [id=" + id + ", title=" + title + ", describe=" + describe + ", visible=" + visible
				+ ", salary=" + salary + ", company=" + company + "]";
	}
}
