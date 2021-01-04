/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.PayrollSystem.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import lk.ijse.PayrollSystem.Model.AdministratorModel;
import lk.ijse.PayrollSystem.db.DBConnection;

/**
 *
 * @author chathu
 */
public class AdministratorController {

    public static boolean addAdmin(AdministratorModel admin) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("Insert into Administrator Values(?,?,?,?,md5(?))");
        
        stm.setObject(1, admin.getId());
        stm.setObject(2, admin.getFullname());
        stm.setObject(3, admin.getContact());
        stm.setObject(4, admin.getUsername());
        stm.setObject(5, admin.getPassword());
        return stm.executeUpdate() > 0;
    }

   

    public static boolean updateAdmin(AdministratorModel admin) throws ClassNotFoundException, SQLException {
         Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("update Administrator  set Fullname= ? ,Contact=? , Username= ? where AdminID = ?");
         stm.setObject(1, admin.getFullname());
        stm.setObject(2, admin.getContact());
        stm.setObject(3, admin.getUsername());
         stm.setObject(4, admin.getId());
        return stm.executeUpdate() > 0;
    }

    public static boolean deleteAdmin(AdministratorModel admin) throws ClassNotFoundException, SQLException {
               Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("delete from administrator where AdminID =?");
     
         stm.setObject(1, admin.getId());
       
        return stm.executeUpdate() > 0;
    }
}
    

