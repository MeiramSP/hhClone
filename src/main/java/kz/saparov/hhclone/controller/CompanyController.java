package kz.saparov.hhclone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kz.saparov.hhclone.service.CompanyService;

@Controller
@RequestMapping("/companies")
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	
	@GetMapping("/{id}")
	public String getCompanyById(Model model, @PathVariable Long id) {
		
		model.addAttribute("company", companyService.getById(id));			
		return "company/companyVacancies";
	}

}
