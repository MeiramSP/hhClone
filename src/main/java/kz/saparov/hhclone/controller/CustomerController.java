package kz.saparov.hhclone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kz.saparov.hhclone.model.ReplyModel;
import kz.saparov.hhclone.repository.ResumeRepository;
import kz.saparov.hhclone.service.ReplyService;
import kz.saparov.hhclone.service.VacancyService;

@Controller
@RequestMapping("/customers/{id}")
@PreAuthorize("#id == authentication.principal.id and hasRole('ROLE_USER')")
public class CustomerController {

	@Autowired
	private ResumeRepository resumeRepository;
	
	@Autowired
	private VacancyService vacancyService;
	
	@Autowired
	private ReplyService replyService;
	

	@GetMapping("/resumes")
	public String showResumeList(Model model,@PathVariable Long id) {
		model.addAttribute("resumes", resumeRepository.findByUserId(id));		
		return "customer/resumes";
	}
	
	@GetMapping("/vacancies")
	public String showVacanyList(Model model, @PathVariable Long id) {		
		model.addAttribute("vacancies", vacancyService.getPersonalVacancyList(id));
		model.addAttribute("resumes", resumeRepository.findByUserId(id));
		return "customer/vacanciesList";
	}
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@PostMapping("/response/create")
	public String createResponse(@ModelAttribute("response") ReplyModel model,
							     @PathVariable("id") Long userId) {	
		replyService.save(model, userId);
		return "redirect:/customers/" + userId + "/resumes";
	}
	
}
