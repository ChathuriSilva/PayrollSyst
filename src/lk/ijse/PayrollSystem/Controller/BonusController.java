/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.PayrollSystem.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import lk.ijse.PayrollSystem.Model.BonusModel;
import lk.ijse.PayrollSystem.db.DBConnection;

/**
 *
 * @author chathu
 */
public class BonusController {

    public static boolean addBonus(BonusModel bonus) throws ClassNotFoundException, SQLException {
         Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("Insert into Bonus (Reason,Amount,MonthGiven,YearGiven) values(?,?,?,?)");
        
        stm.setObject(1, bonus.getReason());
        stm.setObject(2, bonus.getAmount());
        stm.setObject(3, bonus.getMonthGiven());
        stm.setObject(4, bonus.getYearGiven()
        );
        return stm.executeUpdate() > 0;
    }

    public static boolean updateBonus(BonusModel bonus) throws ClassNotFoundException, SQLException {
             Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("UPDATE bonus set Reason=? , Amount=? , MonthGiven=? , YearGiven=? where BonusID=? ");
        
        stm.setObject(1, bonus.getReason());
        stm.setObject(2, bonus.getAmount());
        stm.setObject(3, bonus.getMonthGiven());
        stm.setObject(4, bonus.getYearGiven());
        stm.setObject(5, bonus.getId());
        return stm.executeUpdate() > 0;
    }

    public boolean deleteBonus(BonusModel bonus) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("Delete from  Bonus Where BonusID=?");
        
        stm.setObject(1, bonus.getId());
       
        return stm.executeUpdate() > 0;

    }
    
}
