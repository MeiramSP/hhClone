package kz.saparov.hhclone.service;

import kz.saparov.hhclone.entity.Resume;

public interface ResumeService {
	
	public Resume findByUserId(Long id);
}
