package kz.saparov.hhclone.dto.reply;

import kz.saparov.hhclone.entity.Reply;

public class ReplyResponse {
	private Long id;
	private Long vacancyId;
	private String vacancyName;
	private String status;
	
	public static ReplyResponse convert(Reply reply) {
		ReplyResponse response = new ReplyResponse();
		response.setId(reply.getId());
		response.setVacancyId(reply.getVacancy().getId());
		response.setVacancyName(reply.getVacancy().getTitle());
		return response;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public Long getVacancyId() {
		return vacancyId;
	}

	public void setVacancyId(Long vacancyId) {
		this.vacancyId = vacancyId;
	}

	public String getVacancyName() {
		return vacancyName;
	}

	public void setVacancyName(String vacancyName) {
		this.vacancyName = vacancyName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
