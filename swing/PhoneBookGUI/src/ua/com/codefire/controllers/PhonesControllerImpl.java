/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.controllers;

import java.io.ByteArrayOutputStream;
import java.util.List;
import ua.com.codefire.dao.PhonesDao;
import ua.com.codefire.dao.PhonesDaoImpl;
import ua.com.codefire.dao.entity.Contact;

/**
 *
 * @author codefire
 */
public class PhonesControllerImpl implements PhonesController{
    
    private final PhonesDao dao;
    
    {
        dao = new PhonesDaoImpl("database.db"); // or load from resources
    }

    @Override
    public List<Contact> getAllContacts() {
        return dao.getAll();
    }

    @Override
    public Contact getContactById(int id) {
        return dao.find(id);
    }

    @Override
    public void addContact(Contact contact) {
        dao.add(contact);
    }

    @Override
    public void deleteContactById(int id) {
        dao.delete(id);
    }
    

    
}
