package com.example.demo.app.survey;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/survey")
public class SurveyController {
	
//	private final SurveyService surveyService;
//	
//	public SurveyController(SurveyService surveyService){
//		this.surveyService = surveyService;
//	}
	
//	@GetMapping
//	public String index(SurveyForm surveyForm, Model model) {
//		
//		model.addAttribute("title", "SurveyForm Form");
//		
//		return "survey/index";
//	}
	
	@GetMapping("/form")
	public String form(SurveyForm surveyForm, 
			Model model,
			@ModelAttribute("complete") String complete) {
		
		model.addAttribute("title", "SurveyForm Form");
		
		return "survey/form";
	}
	
	@PostMapping("/form")
	public String formGoBack(SurveyForm surveyForm, Model model) {
		
		model.addAttribute("title", "InquiryForm");
		
		return "survey/form";
	}
	
	
	@PostMapping("/confirm")
	public String confirm(@Validated SurveyForm surveyForm,
			BindingResult result,
			Model model) {
		
		if(result.hasFieldErrors()) {
			model.addAttribute("title", "Inquiry Form");
		}
		
		model.addAttribute("title", "Comfirm Page");
		
		return "survey/confirm";
	}
	
	@PostMapping("/complete")
	public String complete(@Validated SurveyForm surveyForm,
			BindingResult result,
			Model model,
			RedirectAttributes redirectAttributes) {
		
		if(result.hasErrors()) {
			model.addAttribute("title", "Error!");
			
			return "survey/form";
		}
		//modelのようなもの
		redirectAttributes.addFlashAttribute("complete", "Registered!");
		return "redirect:/survey/form";
	}
	
}
