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

import kz.saparov.hhclone.entity.Vacancy;
import kz.saparov.hhclone.service.CompanyService;
import kz.saparov.hhclone.service.VacancyService;

@Controller
@RequestMapping("/companies/hrs/{id}")
@PreAuthorize("#id == authentication.principal.id and hasRole('ROLE_HR')")
public class HRManagerController {
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private VacancyService vacancyService;
	
	@GetMapping
	public String showAdmin(Model model, @PathVariable Long id) {
		model.addAttribute("company", companyService.getByHrId(id));
		model.addAttribute("hr_id", id);
		return "company/hrCabinet";
	}
	
	@PostMapping("/save/{company}")
	public String createVacancy(@ModelAttribute("vacancy") Vacancy vacancy, @PathVariable("id") Long id,
								@PathVariable("company") Long companyId) {
		vacancyService.saveVacancy(vacancy);
		return "redirect:/companies/hrs/" + id;
	}
}
