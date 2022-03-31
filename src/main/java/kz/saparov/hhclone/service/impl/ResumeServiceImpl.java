package kz.saparov.hhclone.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kz.saparov.hhclone.entity.Resume;
import kz.saparov.hhclone.repository.ResumeRepository;
import kz.saparov.hhclone.service.ResumeService;

@Service
public class ResumeServiceImpl implements ResumeService {

	@Autowired
	private ResumeRepository resumeRepository;
	
	@Override
	public Resume findByUserId(Long id) {
		return resumeRepository.findById(id).orElseGet(() -> new Resume());
	}
	
	
}
