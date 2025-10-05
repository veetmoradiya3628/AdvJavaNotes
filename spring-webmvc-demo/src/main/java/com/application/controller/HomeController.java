package com.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	 @GetMapping("/")
	    public String home(Model model) {
	        model.addAttribute("message", "Hello Spring MVC!");
	        return "home";
	 }
	 
	 @GetMapping("/about")
	 public String about(Model model) {
	        model.addAttribute("info", "This is a learning project for Spring Web MVC.");
	        return "about"; 
	 }
	 
	 @GetMapping("/hello")
	    public String hello(@RequestParam(name="name", required=false, defaultValue="Guest") String name,
	                        Model model) {
	        model.addAttribute("name", name);
	        return "hello"; 
	 }
	 
	 @GetMapping("/greet/{name}")
	    public String greet(@PathVariable("name") String name, Model model) {
	        model.addAttribute("name", name);
	        return "greet";
	 }
}