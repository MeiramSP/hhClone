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

import kz.saparov.hhclone.dto.reply.ReplyRequest;
import kz.saparov.hhclone.service.ReplyService;
import kz.saparov.hhclone.service.ResumeService;
import kz.saparov.hhclone.service.VacancyService;

@Controller
@RequestMapping("/customers/{id}")
@PreAuthorize("#id == authentication.principal.id and hasRole('ROLE_USER')")
public class CustomerController {
	
	private ResumeService resumeService;
	private VacancyService vacancyService;
	private ReplyService replyService;
	
	@Autowired
	public CustomerController(ResumeService resumeService, VacancyService vacancyService, ReplyService replyService) {		
		this.resumeService = resumeService;
		this.vacancyService = vacancyService;
		this.replyService = replyService;
	}

	@GetMapping("/resumes")
	public String showResumeList(Model model,@PathVariable Long id) {
		model.addAttribute("resumes", resumeService.findByUserId(id));		
		return "customer/resumes";
	}
	
	@GetMapping("/vacancies")
	public String showVacanyList(Model model, @PathVariable Long id) {	
		model.addAttribute("vacancies", vacancyService.getPersonalVacancyList(id));
		model.addAttribute("resumes", resumeService.findByUserId(id));
		return "customer/vacanciesList";
	}
	
	@GetMapping("/replyes")
	public String showReplyes(Model model, @PathVariable Long id) {
		model.addAttribute("replyes", replyService.findByUserId(id));
		return "customer/replyes";
	}
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@PostMapping("/response/create")
	public String createReply(@ModelAttribute("reply") ReplyRequest reply,
							  @PathVariable("id") Long userId) {	
		replyService.save(reply, userId);
		return "redirect:/customers/" + userId + "/resumes";
	}
	
}
