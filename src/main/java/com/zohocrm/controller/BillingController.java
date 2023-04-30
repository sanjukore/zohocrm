package com.zohocrm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zohocrm.entities.Billing;
import com.zohocrm.entities.Contact;
import com.zohocrm.service.BillingService;
import com.zohocrm.service.ContactService;

@Controller
public class BillingController {

	@Autowired
	private BillingService billingService;
	
	@Autowired
	private ContactService contactService;
	
	
	@PostMapping("/saveBill")
	public String saveBill(@ModelAttribute("bill") Billing bill,Model model) {
		billingService.saveBill(bill);

		List<Contact> contacts = contactService.getAllContacts();
		model.addAttribute("contacts", contacts);
		return "list_contacts";
	}
	
	@RequestMapping("/generateBill")
	public String viewBillingPage(@RequestParam("id") long id,Model model) {
		Contact contact=contactService.getContactById(id);
		model.addAttribute("contact", contact);
		return "generate_bill";
	}
}
