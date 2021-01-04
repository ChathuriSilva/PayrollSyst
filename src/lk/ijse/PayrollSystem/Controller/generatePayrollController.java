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
import lk.ijse.PayrollSystem.Model.generatePayrollModel;
import lk.ijse.PayrollSystem.db.DBConnection;

/**
 *
 * @author chathu
 */
public class generatePayrollController {

    public static int getPresent(generatePayrollModel payroll) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("select count(EmployeeID) from attendance where year(CurrentDate)=? and month(CurrentDate)=? and EmployeeID=?");
        stm.setObject(1, payroll.getYear());
        stm.setObject(2, payroll.getMonth());
        stm.setObject(3, payroll.getEmpId());
        ResultSet rs = stm.executeQuery();
        int k = 0;
        while (rs.next()) {
            k = rs.getInt(1);
        }
        return k;
    }
    
    
    /////loan table eke aluth feild ekak danna settled kyala,ekata danna checkbox, settled nm correct eka watenna
    //due date eka meh aurudde meh mase nm eka payroll eken adu wenna oni.,payroll eke loans gatta ganata current month ekata due loans dannna
    //eke nama wenas karanna, total no od due loans for this month kyala.

        public static int getHrsWorked(generatePayrollModel payroll) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("select sum((HoursWorked)) from amountearned where EmployeeID=? and month(WorkDate)=? and year(WorkDate)=? ");
        stm.setObject(1, payroll.getEmpId());
        stm.setObject(2, payroll.getMonth());
        stm.setObject(3, payroll.getYear());
        

        ResultSet rs = stm.executeQuery();
        int k = 0;
        while (rs.next()) {
            k = rs.getInt(1);
        }
        return k;
    }

    public static int getTotLoans(generatePayrollModel payroll) throws ClassNotFoundException, SQLException {
      Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("select count((EmployeeID)) from loan where EmployeeID=? and month(DueDate)=? and year(DueDate)=? ");
        stm.setObject(1, payroll.getEmpId());
        stm.setObject(2, payroll.getMonth());
        stm.setObject(3, payroll.getYear());
        

        ResultSet rs = stm.executeQuery();
        int k = 0;
        while (rs.next()) {
            k = rs.getInt(1);
        }
        return k;  
    }

    public static int getAbsentDays(generatePayrollModel payroll) throws ClassNotFoundException, SQLException {
         Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("select count((EmployeeID)) from attendance where EmployeeID=? and month(Currentdate)=? and year(CurrentDate)=? ");
        stm.setObject(1, payroll.getEmpId());
        stm.setObject(2, payroll.getMonth());
        stm.setObject(3, payroll.getYear());
        

        ResultSet rs = stm.executeQuery();
        int k = 0;
        while (rs.next()) {
            k = rs.getInt(1);
        }
        return k;  
    }

    public static int getTotLoansDue(generatePayrollModel payroll) throws ClassNotFoundException, SQLException {
          Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("select sum((amount)) from loan where EmployeeID=? and month(Duedate)=? and year(DueDate)=? ");
        stm.setObject(1, payroll.getEmpId());
        stm.setObject(2, payroll.getMonth());
        stm.setObject(3, payroll.getYear());
        

        ResultSet rs = stm.executeQuery();
        int k = 0;
        while (rs.next()) {
            k = rs.getInt(1);
        }
        return k;  
    }

    public static int getNoOfDeductions(generatePayrollModel payroll) throws ClassNotFoundException, SQLException {
             Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("select count((EmployeeID)) from deduction where EmployeeID=? and month(DeductedDate)=? and year(DeductedDate)=? ");
        stm.setObject(1, payroll.getEmpId());
        stm.setObject(2, payroll.getMonth());
        stm.setObject(3, payroll.getYear());
        

        ResultSet rs = stm.executeQuery();
        int k = 0;
        while (rs.next()) {
            k = rs.getInt(1);
        }
        return k;
    }

    public static int getTotDeductions(generatePayrollModel payroll) throws ClassNotFoundException, SQLException {
              Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("select sum((amount)) from deduction where EmployeeID=? and month(DeductedDate)=? and year(DeductedDate)=? ");
        stm.setObject(1, payroll.getEmpId());
        stm.setObject(2, payroll.getMonth());
        stm.setObject(3, payroll.getYear());
        

        ResultSet rs = stm.executeQuery();
        int k = 0;
        while (rs.next()) {
            k = rs.getInt(1);
        }
        return k;
    }

    public static int getTotBonus(generatePayrollModel payroll) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("select sum(amount) from bonus where monthGiven=? and yearGiven=? ");
        
        stm.setObject(1, payroll.getMonth());
        stm.setObject(2, payroll.getYear());
        

        ResultSet rs = stm.executeQuery();
        int k = 0;
        while (rs.next()) {
            k = rs.getInt(1);
        }
        return k; 
    }

    public static int getSalary(generatePayrollModel payroll) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("select sum((amountEarned)) from amountEarned where EmployeeID=? and month(WorkDate)=? and year(WorkDate)=? ");
        
        stm.setObject(1, payroll.getEmpId());
        stm.setObject(2, payroll.getMonth());
        stm.setObject(3, payroll.getYear());

        ResultSet rs = stm.executeQuery();
        int k = 0;
        while (rs.next()) {
            k = rs.getInt(1);
        }
        return k;
    }

    public static int getFinalSalary(generatePayrollModel payroll) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("select sum((amountEarned)) from amountEarned where EmployeeID=? and month(WorkDate)=? and year(WorkDate)=? ");
        
        stm.setObject(1, payroll.getEmpId());
        stm.setObject(2, payroll.getMonth());
        stm.setObject(3, payroll.getYear());

        ResultSet rs = stm.executeQuery();
        int k = 0;
        while (rs.next()) {
            k = rs.getInt(1);
        }
        return k;
    }
    
    
}
