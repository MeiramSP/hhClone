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

@Entity
@Table(name = "replyes")
public class Reply {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reply_id")
	private Long id;
	
	@Column(name = "message")
	private String message;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "resume_id", nullable=false)
	private Resume resume;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vacancy_id", nullable=false)
	private Vacancy vacancy;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable=false)
	private User user;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Resume getResume() {
		return resume;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}

	public Vacancy getVacancy() {
		return vacancy;
	}

	public void setVacancy(Vacancy vacancy) {
		this.vacancy = vacancy;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
