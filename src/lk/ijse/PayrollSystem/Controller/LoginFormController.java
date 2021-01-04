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
public class LoginFormController {
    public boolean LoginAdmin(AdministratorModel login) throws SQLException, ClassNotFoundException {
int count=0;
        Connection con = DBConnection.getInstance().getConnection();
       
        String sql = "select * from Administrator where Username=? and Password=?";
        PreparedStatement stm = con.prepareStatement(sql);
         
        stm.setString(1, login.getUsername());
        stm.setString(2,  login.getPassword());
        ResultSet rs= stm.executeQuery();
        while(rs.next()){
            count=count+1;
        }
        if(count==1){
            return true;
        }else{
        return false;
        }
    }
}
