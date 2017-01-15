/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.controllers;

import java.util.List;
import ua.com.codefire.dao.entity.Contact;

/**
 *
 * @author codefire
 */
public interface PhonesController {
    List<Contact> getAllContacts();
    Contact getContactById(int id);
}
