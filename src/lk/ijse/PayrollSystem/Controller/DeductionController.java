/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.PayrollSystem.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import lk.ijse.PayrollSystem.Model.DeductionModel;
import lk.ijse.PayrollSystem.Model.LoanModel;
import lk.ijse.PayrollSystem.db.DBConnection;

/**
 *
 * @author chathu
 */
public class DeductionController {

    public static boolean addDeduction(DeductionModel deduction) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("Insert into Deduction Values(?,?,?,?)");
        
        stm.setObject(1, deduction.getEmpid());
        stm.setObject(2, deduction.getAmount());
        stm.setObject(3, deduction.getReason());
        stm.setObject(4, deduction.getDate());
        return stm.executeUpdate() > 0;
    }

    public static boolean updateDeduction(DeductionModel deduction) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("update Deduction  set Amount= ? ,Reason=?  where EmployeeID = ?");
           stm.setObject(1, deduction.getAmount());
        stm.setObject(2, deduction.getReason());
        stm.setObject(3, deduction.getEmpid());
      
        return stm.executeUpdate() > 0;
    }

    public static boolean updateDeduction(LoanModel loan) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean deleteDeduction(DeductionModel deduction) throws SQLException, ClassNotFoundException {
         Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("delete from  Deduction  where EmployeeID=? and Reason=? and DeductedDate=?");
        stm.setObject(1, deduction.getEmpid());
      
        stm.setObject(2, deduction.getReason());
        stm.setObject(3, deduction.getDate());
      
        return stm.executeUpdate() > 0;
    }

   
   
}
