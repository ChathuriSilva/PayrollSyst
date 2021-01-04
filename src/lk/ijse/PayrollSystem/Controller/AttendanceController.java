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
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.ijse.PayrollSystem.Model.AttendanceModel;
import lk.ijse.PayrollSystem.db.DBConnection;

/**
 *
 * @author chathu
 */
public class AttendanceController {

    public static int getCount(AttendanceModel attendance) throws ClassNotFoundException, SQLException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "select count(EmployeeID)  from attendance where month(CurrentDate)=? and year(CurrentDate)=year(now())";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setInt(1, attendance.getMonth());

        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            return rs.getInt(1);
        } else {
            return 0;
        }
    }

    public boolean markAttendanceIn(AttendanceModel attendance) throws SQLException, ClassNotFoundException {

        Connection con = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO Attendance (EmployeeID,CurrentDate,TimeIn)VALUES(?,?,?)";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, attendance.getEmpId());
        stm.setString(2, attendance.getCDate());
        stm.setString(3, attendance.getTime());
        return stm.executeUpdate() > 0;
    }

    public boolean markAttendanceOut(AttendanceModel attendance) {
        Connection con = null;
        try {
            con = DBConnection.getInstance().getConnection();
            con.setAutoCommit(false);
            String sql = "update attendance set TimeOut=? WHERE EmployeeID=? and CurrentDate=?";

            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, attendance.getTime());
            stm.setString(2, attendance.getEmpId());
            stm.setString(3, attendance.getCDate());
            boolean isSaved = stm.executeUpdate() > 0;
            if (isSaved) {
                boolean insertAmountEarned = insertAmountEarned(attendance.getTime(), attendance.getEmpId(), attendance.getCDate());
                if (!insertAmountEarned) {
                    con.rollback();
                    return false;
                }
            }
            con.commit();
            return isSaved;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AttendanceController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(AttendanceController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    private boolean insertAmountEarned(String timeOut, String empId, String CDate) throws ClassNotFoundException, SQLException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "Insert into  amountearned values(?,?,(select timediff(attendance.TimeOut,attendance.TimeIn) as HoursWork from attendance where attendance.EmployeeID=? and CurrentDate=?),(select BasicSalary as BasicSalary from Employee where EmployeeID=?),(Select employee.BasicSalary * (time_to_sec(TimeDiff(attendance.TimeOut, attendance.TimeIn))/60)/60 From attendance Inner Join employee On attendance.EmployeeID = employee.EmployeeID where attendance.EmployeeID=? AND attendance.CurrentDate=date(now())))";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, empId);
        stm.setString(2, CDate);
        stm.setString(3, empId);
        stm.setString(4, CDate);
        stm.setString(5, empId);
        stm.setString(6, empId);

        return stm.executeUpdate() > 0;

    }

    public int getAttendanceCount() throws ClassNotFoundException, SQLException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "select count(*) from Attendance where 'TimeIn' and CurrentDate=CURDATE()";

        ResultSet rs = con.prepareStatement(sql).executeQuery();
        if (rs.next()) {
            return rs.getInt(1);
        } else {
            return 0;
        }
    }

    public boolean checkValidity(String EmpNic) throws ClassNotFoundException, SQLException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "select * from Employee where EmployeeID = ?";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, EmpNic);

        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            return true;
        } else {
            return false;
        }
    }

    public int markAttendanceIn(int click) throws ClassNotFoundException, SQLException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "delete  from attendance where AttendanceID=?";

        PreparedStatement stm = con.prepareStatement(sql);
        stm.setInt(1, click);
        int rs = stm.executeUpdate();
        if (rs > 0) {
            return 1;
        } else {
            return 0;
        }

    }

 /*   public int getMPE() throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("select EmployeeID from Attendance where MAX(count(EmployeeID)) and month(CurrentDate)=month(CURDATE)");
        
          ResultSet rs = stm.executeQuery();
        String Fullname="" ;
        while (rs.next()) {
            Fullname = rs.getString(1);
        }
        return Fullname;
    }*/

}
