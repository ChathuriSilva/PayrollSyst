/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.PayrollSystem.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import lk.ijse.PayrollSystem.Model.LoanModel;
import lk.ijse.PayrollSystem.db.DBConnection;

/**
 *
 * @author chathu
 */
public class LoanController {

    public static boolean addLoan(LoanModel loan) throws ClassNotFoundException, SQLException {
          Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("Insert into Loan Values(?,?,?,?,?,?)");
        
        stm.setObject(1, loan.getEmployeeid());
        stm.setObject(2, loan.getAmount());
        stm.setObject(3,loan.getReason());
        stm.setObject(4, loan.getIssuedDate());
        stm.setObject(5, loan.getDueDate());
        stm.setObject(6,loan.getSettled());
       
        
        return stm.executeUpdate() > 0;
    }

    public static boolean updateLoan(LoanModel loan) throws ClassNotFoundException, SQLException {
           Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("update loan set Amount=? , Reason=? ,IssuedDate=? , DueDate=? where EmployeeID=?");
        
        stm.setObject(1, loan.getAmount());
        stm.setObject(2,loan.getReason());
        stm.setObject(3, loan.getIssuedDate());
        stm.setObject(4, loan.getDueDate());
       stm.setObject(5, loan.getEmployeeid());
        
        return stm.executeUpdate() > 0;
    }

    public static boolean settleLoan(LoanModel loan) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("update loan set settled=?  where EmployeeID=? and Reason=? and IssuedDate=? and DueDate=?");
        stm.setObject(1,loan.getSettled());
        stm.setObject(2, loan.getEmployeeid());
        stm.setObject(3,loan.getReason());
        stm.setObject(4, loan.getIssuedDate());
        stm.setObject(5, loan.getDueDate());
       
        
        return stm.executeUpdate() > 0;
    }

    public boolean deleteLoan(LoanModel loan) throws ClassNotFoundException, SQLException {
         Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("delete from  loan where EmployeeId=? and Reason=? and IssuedDate=? and DueDate=?");
        stm.setObject(1, loan.getEmployeeid());
        stm.setObject(2,loan.getReason());
        stm.setObject(3, loan.getIssuedDate());
        stm.setObject(4, loan.getDueDate());
       
        
        return stm.executeUpdate() > 0;
    }
    
}
