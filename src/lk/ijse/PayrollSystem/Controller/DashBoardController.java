/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.PayrollSystem.Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import lk.ijse.PayrollSystem.db.DBConnection;

/**
 *
 * @author chathu
 */
public class DashBoardController {

     public int getEmpCount() throws ClassNotFoundException, SQLException {
          Connection con = DBConnection.getInstance().getConnection();
        String sql = "select count(*) from Employee";
        ResultSet rs = con.prepareStatement(sql).executeQuery();
        if(rs.next()){
            return rs.getInt(1);
        }else{
            return 0;
        }
    }

    public int getPresent() throws ClassNotFoundException, SQLException {
           Connection con = DBConnection.getInstance().getConnection();
        String sql = "select count(*) from Attendance where  CurrentDate=CURDATE() ";
        ResultSet rs = con.prepareStatement(sql).executeQuery();
        if(rs.next()){
            return rs.getInt(1);
        }else{
            return 0;
        }
    }



    public int getLateComers() throws ClassNotFoundException, SQLException {
          Connection con = DBConnection.getInstance().getConnection();
        String sql = "select count(*) from Attendance where TimeIn>'08:30:00' ";
        ResultSet rs = con.prepareStatement(sql).executeQuery();
        if(rs.next()){
            return rs.getInt(1);
        }else{
            return 0;
        }
    }

    public int getPayDay() throws ClassNotFoundException, SQLException {
          Connection con = DBConnection.getInstance().getConnection();
        String sql = "SELECT DATEDIFF(LAST_DAY(CURDATE()),now());";
        ResultSet rs = con.prepareStatement(sql).executeQuery();
        if(rs.next()){
            return rs.getInt(1);
        }else{
            return 0;
        }
    }
        public int getAdminCount() throws ClassNotFoundException, SQLException {
          Connection con = DBConnection.getInstance().getConnection();
        String sql = "SELECT count(*) from administrator";
        ResultSet rs = con.prepareStatement(sql).executeQuery();
        if(rs.next()){
            return rs.getInt(1);
        }else{
            return 0;
        }
    }
   
    
}
