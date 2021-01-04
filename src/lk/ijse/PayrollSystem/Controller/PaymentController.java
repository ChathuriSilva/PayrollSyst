/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.PayrollSystem.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import lk.ijse.PayrollSystem.Model.PaymentModel;
import lk.ijse.PayrollSystem.db.DBConnection;

/**
 *
 * @author chathu
 */
public class PaymentController {

    public static boolean addPayment(PaymentModel payment) throws ClassNotFoundException, SQLException {
         Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("Insert into Payments values (?,(select BasicSalary from employee where EmployeeID=?),(select count(HoursWorked) from amountEarned where EmployeeID=? and month(WorkDate)=? and year(WorkDate)=?),?,?,?,?,?,CURDATE()  )");
        
        stm.setObject(1, payment.getEmployeeID());
        stm.setObject(2,payment.getEmployeeID());
        stm.setObject(3,payment.getEmployeeID());
        stm.setObject(4,payment.getMonth());
         stm.setObject(5,payment.getYear()); 
       stm.setObject(6, payment.getSalEarned());
        stm.setObject(7,payment.getDueLoans());
        stm.setObject(8,payment.getDeductions());
         stm.setObject(9,payment.getBonus());
        int PayAmount=(payment.getSalEarned()+payment.getBonus())-(payment.getDeductions()+payment.getDueLoans());
      stm.setObject(10, PayAmount);
        return stm.executeUpdate() > 0;
    }

    public boolean deletePayment(PaymentModel payment) throws ClassNotFoundException, SQLException {
           Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("delete from Payments where EmployeeID=? and Paymentdate=?");
        
        stm.setObject(1, payment.getEmployeeID());
        stm.setObject(2,payment.getDate());

        return stm.executeUpdate() > 0;
    }
    
}
