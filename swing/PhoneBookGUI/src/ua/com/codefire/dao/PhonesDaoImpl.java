/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.dao;

import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import ua.com.codefire.dao.entity.Contact;

/**
 *
 * @author codefire
 */
public class PhonesDaoImpl implements PhonesDao {

    private static final String SELECT_QUERY = "SELECT * FROM main.phones";
    private static final String SELECT_QUERY_WHERE_ID = "SELECT * FROM main.phones WHERE id = ";
    private final String database;

    public PhonesDaoImpl(String database) {
        this.database = database;
    }

    private Connection getConnection() throws SQLException {
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
        Contact contact = null;
        try (Connection connect = getConnection()) {
            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_QUERY_WHERE_ID + id);
            contact = new Contact(resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("phone"));
        } catch (SQLException ex) {
            Logger.getLogger(PhonesDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contact;
    }

    @Override
    public void add(Contact contact) {
        try (Connection connect = getConnection()) {
            Statement statement = connect.createStatement();
            statement.executeUpdate("INSERT INTO main.phones (`name`, `phone`) VALUES ('"
                    + contact.getName() + "', '"
                    + contact.getPhone() + "')");

            String sql = "UPDATE main.phones SET `foto`=? where `phone`='" + contact.getPhone() + "'";
            PreparedStatement preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setBytes(1, readFile(contact.getFile()));
            preparedStatement.executeUpdate();
            //updateBlob(contact, connect);
        } catch (SQLException ex) {
            Logger.getLogger(PhonesDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PhonesDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PhonesDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//    public void add(Contact contact) {
//        try (Connection connect = getConnection()) {
//            Statement statement = connect.createStatement();
//            String sql = "INSERT INTO main.phones (`name`, `phone`, `foto`) VALUES ('?','?',?)";
//            PreparedStatement preparedStatement = connect.prepareStatement(sql);
//            preparedStatement.setString(1, contact.getName());
//            preparedStatement.setString(2, contact.getPhone());
//            preparedStatement.setBytes(3, readFile(contact.getFile()));
//            preparedStatement.executeUpdate();
//
//        } catch (SQLException ex) {
//            Logger.getLogger(PhonesDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(PhonesDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(PhonesDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

    @Override
    public void delete(int id) {
        try (Connection connect = getConnection()) {
            Statement statement = connect.createStatement();
            statement.executeUpdate("DELETE FROM main.phones WHERE id = " + id);
        } catch (SQLException ex) {
            Logger.getLogger(PhonesDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateBlob(Contact contact, final Connection connect) throws FileNotFoundException, SQLException, IOException {
        String sql = "UPDATE main.phones SET `foto`=? where `phone`='" + contact.getPhone() + "'";
        PreparedStatement preparedStatement = connect.prepareStatement(sql);
        preparedStatement.setBytes(1, readFile(contact.getFile()));
        preparedStatement.executeUpdate();
    }

    private byte[] readFile(File file) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] buffer = new byte[1024];
            byteArrayOutputStream = new ByteArrayOutputStream();
            for (int len; (len = fileInputStream.read(buffer)) != -1;) {
                byteArrayOutputStream.write(buffer, 0, len);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PhonesDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PhonesDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return byteArrayOutputStream != null ? byteArrayOutputStream.toByteArray() : null;
    }

    public Image readBlob(int phonesId) {
        String selectSQL = "SELECT `foto` FROM phones WHERE id=?";
        ResultSet resultSet;
        PreparedStatement preparedStatement;
        Image image = null;
        try (Connection connect = getConnection()){
            preparedStatement = connect.prepareStatement(selectSQL);
            preparedStatement.setInt(1, phonesId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                image = ImageIO.read(resultSet.getBinaryStream("foto"));
            }
        } catch (SQLException | IOException ex) {
            Logger.getLogger(PhonesDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return image;
    }
}
