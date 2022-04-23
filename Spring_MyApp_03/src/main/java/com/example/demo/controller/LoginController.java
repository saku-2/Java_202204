//package com.example.demo.Controller;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//public class LoginController {
//
//	@RequestMapping(value="/login")
//	private String hello(Model model){
//		
//		model.addAttribute("title", "Login !");
//		model.addAttribute("msg", "Hello Spring!!!");
////		★
//		model.addAttribute("loginForm", new LoginForm("","",""));
//		
//		return "/View/loginView.html";
//	}
//	
//	@RequestMapping(value="/menu")
//    public String menu(@ModelAttribute LoginForm loginForm, Model model) {
//		
//		model.addAttribute("loginForm", loginForm);
//		
//		//ログイン処理
//		
//        return "/View/menuView.html";
//    }
//	
//	@RequestMapping(value="/back")
//    public String back(@ModelAttribute LoginForm loginForm, Model model) {
//		
//		model.addAttribute("loginForm", loginForm);
//		
//		//ログイン処理
//		
//        return "/View/loginView.html";
//    }
//	
//	//「表」
//	@RequestMapping(value="/table")
//    public String table(@ModelAttribute LoginForm loginForm, Model model) {
//		
//		model.addAttribute("loginForm", loginForm);
//		
////		List<LoginForm> fruits = new ArrayList<LoginForm>() {
////			{
////				add(loginForm);
////			}
////		};
//		
//		List<TableForm> fruits = new ArrayList<TableForm>();
//
//		TableForm apple = new TableForm(1,"りんご","あか");
//	    fruits.add(apple);
//
//	    TableForm lemon = new TableForm(2, "レモン", "きいろ");
//	    fruits.add(lemon);
//
//	    TableForm kiwi = new TableForm(3, "キウイ", "みどり");
//	    fruits.add(kiwi);
//
//	    TableForm orange = new TableForm(4, "みかん", "オレンジ");
//	    fruits.add(orange);
//
//	    model.addAttribute("fruits", fruits);
//		
//        return "/View/tableView.html";
//    }
//	
//}




package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/login")
public class LoginController {

	@GetMapping(value="/login")
	private String hello(LoginForm loginForm, 
			Model model,
			@ModelAttribute("complete") String complete){
		
		model.addAttribute("title", "Login !");
		model.addAttribute("msg", "Hello Spring!!!");
//		★
		model.addAttribute("loginForm", new LoginForm("","",""));
		
		return "/View/loginView.html";
	}
	
	@PostMapping(value="/login")
	private String helloGoBack(LoginForm loginForm, 
			Model model){
		
		model.addAttribute("title", "Login Back!");
		
		return "/View/loginView.html";
	}
	
	@PostMapping("/menu")
	public String confirm(@Validated LoginForm loginForm,
			BindingResult result,
			Model model) {

		if(result.hasFieldErrors()) {
			model.addAttribute("title", "Inquiry Form");
		}
		
		model.addAttribute("title", "Comfirm Page");
		return "/View/menuView.html";
	}
	
//	//「フラッシュスコープ」
//	@PostMapping("/complete")
//	public String complete(@Validated LoginForm loginForm,
//			BindingResult result,
//			Model model,
//			RedirectAttributes redirectAttributes) {//セッション
//		if(result.hasErrors()) {
//			model.addAttribute("title", "InquiryForm");
//			return "inquiry/form";
//		}
//		//modelのようなもの
//		redirectAttributes.addFlashAttribute("complete", "Registered!");
//		return "/View/loginView.html";
//	}
//	
	
	
	
//	@RequestMapping(value="/menu")
//    public String menu(@ModelAttribute LoginForm loginForm, Model model) {
//		
//		model.addAttribute("loginForm", loginForm);
//		
//		//ログイン処理
//		
//        return "/View/menuView.html";
//    }
	
	@RequestMapping(value="/back")
    public String back(@ModelAttribute LoginForm loginForm, Model model) {
		
		model.addAttribute("loginForm", loginForm);
		
		//ログイン処理
		
        return "/View/loginView.html";
    }
	
	//「表」
	@RequestMapping(value="/table")
    public String table(@ModelAttribute LoginForm loginForm, Model model) {
		
		model.addAttribute("loginForm", loginForm);
		
//		List<LoginForm> fruits = new ArrayList<LoginForm>() {
//			{
//				add(loginForm);
//			}
//		};
		
		List<TableForm> fruits = new ArrayList<TableForm>();

		TableForm apple = new TableForm(1,"りんご","あか");
	    fruits.add(apple);

	    TableForm lemon = new TableForm(2, "レモン", "きいろ");
	    fruits.add(lemon);

	    TableForm kiwi = new TableForm(3, "キウイ", "みどり");
	    fruits.add(kiwi);

	    TableForm orange = new TableForm(4, "みかん", "オレンジ");
	    fruits.add(orange);

	    model.addAttribute("fruits", fruits);
		
        return "/View/tableView.html";
    }
	
}



















