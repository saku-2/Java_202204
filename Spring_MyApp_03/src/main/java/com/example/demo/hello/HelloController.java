package com.example.demo.hello;
//import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

@RequestMapping(value="/hello")
private String hello(Model model){
	
	model.addAttribute("msg", "Hello Spring!");
return "/helloFolder/helloIndex.html";
}
}