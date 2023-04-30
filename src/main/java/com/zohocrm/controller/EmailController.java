package com.zohocrm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zohocrm.dto.Email;
import com.zohocrm.utils.EmailService;

@Controller
public class EmailController {
	
	@Autowired
	private EmailService emailService;
	
	@RequestMapping("/sendEmail")
	public String sendEmail(@ModelAttribute("email") String email,Model model) {
		model.addAttribute("email", email);
		return "compose_email";
	}
	
	@RequestMapping("/triggerEmail")
	public String triggerEmail(Email email,Model model) {
		emailService.sendEmail(email.getEmail(), email.getEmail(), email.getContent());
		model.addAttribute("msg", "email is sent");
		return "compose_email";
	}

}
