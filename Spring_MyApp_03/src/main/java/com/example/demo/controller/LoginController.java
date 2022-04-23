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
////		��
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
//		//���O�C������
//		
//        return "/View/menuView.html";
//    }
//	
//	@RequestMapping(value="/back")
//    public String back(@ModelAttribute LoginForm loginForm, Model model) {
//		
//		model.addAttribute("loginForm", loginForm);
//		
//		//���O�C������
//		
//        return "/View/loginView.html";
//    }
//	
//	//�u�\�v
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
//		TableForm apple = new TableForm(1,"���","����");
//	    fruits.add(apple);
//
//	    TableForm lemon = new TableForm(2, "������", "������");
//	    fruits.add(lemon);
//
//	    TableForm kiwi = new TableForm(3, "�L�E�C", "�݂ǂ�");
//	    fruits.add(kiwi);
//
//	    TableForm orange = new TableForm(4, "�݂���", "�I�����W");
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
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
	
	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public LoginController(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	

	@GetMapping(value="/login")
	private String hello(LoginForm loginForm, 
			Model model,
			@ModelAttribute("complete") String complete){
		
		model.addAttribute("title", "Login !");
		model.addAttribute("msg", "Hello Spring!!!");
//		��
		model.addAttribute("loginForm", new LoginForm("","",""));
		
		return "/View/loginView.html";
	}
	
	@PostMapping(value="/login")
	private String helloGoBack(LoginForm loginForm, 
			Model model){
		
		model.addAttribute("title", "Login Back!");
		
		String name = loginForm.getName().toString();
		String pass = loginForm.getTel().toString();
		
		model.addAttribute("title", name + ", " + pass);
		

		
//		String sql = "SELECT id, name, email "
//				+ "FROM inquiry WHERE id = 1";
//		Map<String, Object> map = jdbcTemplate.queryForMap(sql);
		
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
	
//	//�u�t���b�V���X�R�[�v�v
//	@PostMapping("/complete")
//	public String complete(@Validated LoginForm loginForm,
//			BindingResult result,
//			Model model,
//			RedirectAttributes redirectAttributes) {//�Z�b�V����
//		if(result.hasErrors()) {
//			model.addAttribute("title", "InquiryForm");
//			return "inquiry/form";
//		}
//		//model�̂悤�Ȃ���
//		redirectAttributes.addFlashAttribute("complete", "Registered!");
//		return "/View/loginView.html";
//	}
//	
	
	
	
//	@RequestMapping(value="/menu")
//    public String menu(@ModelAttribute LoginForm loginForm, Model model) {
//		
//		model.addAttribute("loginForm", loginForm);
//		
//		//���O�C������
//		
//        return "/View/menuView.html";
//    }
	
	@RequestMapping(value="/back")
    public String back(@ModelAttribute LoginForm loginForm, Model model) {
		
		model.addAttribute("loginForm", loginForm);
		
		//���O�C������
		
        return "/View/loginView.html";
    }
	
	//�u�\�v
	@RequestMapping(value="/table")
    public String table(@ModelAttribute LoginForm loginForm, Model model) {
		
		model.addAttribute("loginForm", loginForm);
		
////		List<LoginForm> fruits = new ArrayList<LoginForm>() {
////			{
////				add(loginForm);
////			}
////		};
//		
//		List<TableForm> fruits = new ArrayList<TableForm>();
//
//		TableForm apple = new TableForm(1,"���","����");
//	    fruits.add(apple);
//
//	    TableForm lemon = new TableForm(2, "������", "������");
//	    fruits.add(lemon);
//
//	    TableForm kiwi = new TableForm(3, "�L�E�C", "�݂ǂ�");
//	    fruits.add(kiwi);
//
//	    TableForm orange = new TableForm(4, "�݂���", "�I�����W");
//	    fruits.add(orange);
//
//	    model.addAttribute("fruits", fruits);
//	    
	    
	    String sql = "SELECT id, name, email "
				+ "FROM inquiry WHERE id = 1";
		Map<String, Object> map = jdbcTemplate.queryForMap(sql);

		//���K1-1 sql2�̕ϐ�����id2�̂��₢���킹���擾����SQL�����`����
		String sql2 = "SELECT id, name, email "
				+ "FROM inquiry WHERE id = 2";
		//���K1-2 Map<String,Object���^��map2�̕ϐ�����queryForMap��sql2��n�������ʂ��i�[����
		Map<String, Object> map2 = jdbcTemplate.queryForMap(sql2);
		//���K1-3 model.addAttribute��name2,email2�Ƃ������O��map2��name,email��ݒ肷��
		model.addAttribute("name2", map2.get("name"));
		model.addAttribute("email2", map2.get("email"));

		model.addAttribute("name", map.get("name"));
		model.addAttribute("email", map.get("email"));
		model.addAttribute("title", "Inquiry Form");
//		return "test";
		
		List<TableForm> fruits = new ArrayList<TableForm>();
		TableForm apple = new TableForm(1,"���", (String)map.get("name"));
	    fruits.add(apple);

	    TableForm lemon = new TableForm(2, "������", (String)map2.get("name"));
	    fruits.add(lemon);

	    TableForm kiwi = new TableForm(3, "�L�E�C", "�݂ǂ�");
	    fruits.add(kiwi);

	    TableForm orange = new TableForm(4, "�݂���", "�I�����W");
	    fruits.add(orange);

	    model.addAttribute("fruits", fruits);
		
        return "/View/tableView.html";
    }
	
}



















