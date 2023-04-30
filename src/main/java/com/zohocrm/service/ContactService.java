package com.zohocrm.service;

import java.util.List;

import com.zohocrm.entities.Contact;

public interface ContactService {

	public void saveContact(Contact contact);

	public List<Contact> getAllLeads();

	public void deleteContactById(long id);

	public Contact getContactById(long id);
	
	public void saveOneBill(Contact contact);

	public List<Contact> getAllContacts();
}
