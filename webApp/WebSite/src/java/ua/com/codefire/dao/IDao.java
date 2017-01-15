/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.dao;

import ua.com.codefire.dao.entity.WebPageOld;
import ua.com.codefire.dao.entity.Webpage;

/**
 *
 * @author CodeFire
 */
public interface IDao {
    
    WebPageOld getPageByNameOld(String name);
    Webpage getPageByName(String name);
}
