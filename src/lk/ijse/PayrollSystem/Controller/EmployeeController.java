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
import lk.ijse.PayrollSystem.Model.EmployeeModel;
import lk.ijse.PayrollSystem.db.DBConnection;

/**
 *
 * @author chathu
 */
public class EmployeeController {
    public static boolean addEmployee(EmployeeModel employee) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("Insert into Employee Values(?,?,?,?,?)");
        
        stm.setObject(1, employee.getId());
        stm.setObject(2, employee.getFullname());
        stm.setObject(3, employee.getContact());
        stm.setObject(4, employee.getRole());
        stm.setObject(5, employee.getBasicSalary());
        return stm.executeUpdate() > 0;
    }
        public static boolean updateEmployee(EmployeeModel employee) throws ClassNotFoundException, SQLException {
         Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("update Employee  set Fullname= ? ,Contact=? , Role= ? , BasicSalary =? where EmployeeID = ?");
         
        stm.setObject(1, employee.getFullname());
        stm.setObject(2, employee.getContact());
        stm.setObject(3, employee.getRole());
        stm.setObject(4, employee.getBasicSalary());
        stm.setObject(5, employee.getId());
        return stm.executeUpdate() > 0;
    }

    public static String getFullname(EmployeeModel employee) throws ClassNotFoundException, SQLException {
          Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("select Fullname from Employee where EmployeeID=?");
        stm.setObject(1, employee.getId());
         
          ResultSet rs = stm.executeQuery();
        String Fullname="" ;
        while (rs.next()) {
            Fullname = rs.getString(1);
        }
        return Fullname;
    }

    public static String getRole(EmployeeModel employee) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("select Role from Employee where EmployeeID=?");
        stm.setObject(1, employee.getId());
         
          ResultSet rs = stm.executeQuery();
        String Role="" ;
        while (rs.next()) {
            Role = rs.getString(1);
        }
        return Role; 
    }

        public static String getHourlyRate(EmployeeModel employee) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("select BasicSalary from Employee where EmployeeID=?");
        stm.setObject(1, employee.getId());
         
          ResultSet rs = stm.executeQuery();
        String BasicSalary="" ;
        while (rs.next()) {
            BasicSalary = rs.getString(1);
        }
        return BasicSalary; 
    }
    
    public boolean deleteEmployee(EmployeeModel employee) throws ClassNotFoundException, SQLException {
         Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("Delete from  Employee where EmployeeID=?");
        stm.setObject(1, employee.getId());
         return stm.executeUpdate() > 0;
    }

   
}
