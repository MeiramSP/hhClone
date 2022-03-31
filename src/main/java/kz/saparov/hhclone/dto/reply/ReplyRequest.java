package kz.saparov.hhclone.dto.reply;

public class ReplyRequest {
	
	private Long id;
	private Long resumeId;
	private Long vacancyId;
	private String message;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getResumeId() {
		return resumeId;
	}
	public void setResumeId(Long resumeId) {
		this.resumeId = resumeId;
	}
	public Long getVacancyId() {
		return vacancyId;
	}
	public void setVacancyId(Long vacancyId) {
		this.vacancyId = vacancyId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
