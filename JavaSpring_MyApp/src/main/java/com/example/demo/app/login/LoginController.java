package com.example.demo.app.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/login")
public class LoginController {

	@GetMapping("/loginView")//html
	public String form(LoginForm loginForm, 
			Model model) {
//			@ModelAttribute("complete") String complete) {//「フラッシュスコープ」の値をhtmlへレンダリングできる。

		model.addAttribute("title", "Login Form1");
		return "login/loginView";//html
	}
	
	@PostMapping("/confirm")
	public String confirm(@Validated LoginForm loginForm,
			BindingResult result,
			Model model) {

		if(result.hasFieldErrors()) {
			model.addAttribute("title", "Login Form2");
			return "login/loginView";//html
		}
		
		model.addAttribute("title", "Comfirm Page");
		return "login/confirm";
	}
}
