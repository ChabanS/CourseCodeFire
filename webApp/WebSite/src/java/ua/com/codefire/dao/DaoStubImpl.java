/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.dao;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import ua.com.codefire.dao.entity.WebPageOld;
import ua.com.codefire.dao.entity.Webpage;

/**
 *
 * @author CodeFire
 */
public class DaoStubImpl implements IDao{
    
    private final Map<String, WebPageOld> holder = new HashMap<>();
    
    {
        holder.put("index", new WebPageOld("index", "Default page", "Hello on my site..."));
        holder.put("about", new WebPageOld("about", "About page", "This is about page"));
        holder.put("service", new WebPageOld("service", "Service page", "Service and prices"));
        holder.put("contacts", new WebPageOld("contacts", "Contacts page", "Phone: 111-22-33"));
    }
    
    private final EntityManagerFactory factory = Persistence.createEntityManagerFactory("WebSitePU");
    
    private EntityManager getEntityManager(){
        return factory.createEntityManager();
    }

    @Override
    public WebPageOld getPageByNameOld(String name) {
        return holder.get(name);
    }

    @Override
    public Webpage getPageByName(String name) {
       EntityManager manager = getEntityManager();
       Webpage webpage = (Webpage) manager.createNamedQuery("Webpage.findByName").setParameter("name", name).getSingleResult();
       return webpage;
    }
    
    
}
