/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.controllers;

import java.util.List;
import ua.com.codefire.dao.PhonesDao;
import ua.com.codefire.dao.PhonesDaoImpl;
import ua.com.codefire.dao.entity.Contact;

/**
 *
 * @author codefire
 */
public class PhonesControllerImpl implements PhonesController {

    private final PhonesDao dao;

    public PhonesControllerImpl(String database) {
        this.dao = new PhonesDaoImpl(database);
    }

    @Override
    public List<Contact> getAllContacts() {
        return dao.getAll();
    }

    @Override
    public Contact getContactById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
