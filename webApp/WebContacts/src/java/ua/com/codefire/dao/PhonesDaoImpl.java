/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ua.com.codefire.dao.entity.Contact;

/**
 *
 * @author codefire
 */
public class PhonesDaoImpl implements PhonesDao {

    private static final String SELECT_QUERY = "SELECT * FROM main.phones";
    
    private final String database;

    public PhonesDaoImpl(String database) {
        this.database = database;
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PhonesDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private Connection getConnection() throws SQLException{
        return DriverManager.getConnection("jdbc:sqlite:" + database);
    }

    @Override
    public List<Contact> getAll() {
        List<Contact> list = new ArrayList<>();
        try (Connection connect = getConnection()) {
            Statement state = connect.createStatement();
            ResultSet result = state.executeQuery(SELECT_QUERY);
            while (result.next()) {                
                list.add(new Contact(
                        result.getInt("id"),
                        result.getString("name"),
                        result.getString("phone"))
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhonesDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public Contact find(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(Contact contact) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
