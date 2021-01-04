/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.PayrollSystem.Model;

/**
 *
 * @author chathu
 */
public class AmountEarnedModel {
    private String Date;
    private String EmployeeID;
    private int HoursWorked;
    private int BasicSalary;
    private int AmountEarned;
    private String month;
    private String year;
    public AmountEarnedModel(){
        
    }

    public AmountEarnedModel(String empID, String date) {
        EmployeeID=empID;
        Date=date;
    }

    public AmountEarnedModel(String empID, String month, String year) {
         EmployeeID=empID;
         this.month=month;
         this.year=year;
    }

    /**
     * @return the Date
     */
    public String getDate() {
        return Date;
    }

    /**
     * @param Date the Date to set
     */
    public void setDate(String Date) {
        this.Date = Date;
    }

    /**
     * @return the EmployeeID
     */
    public String getEmployeeID() {
        return EmployeeID;
    }

    /**
     * @param EmployeeID the EmployeeID to set
     */
    public void setEmployeeID(String EmployeeID) {
        this.EmployeeID = EmployeeID;
    }

    /**
     * @return the HoursWorked
     */
    public int getHoursWorked() {
        return HoursWorked;
    }

    /**
     * @param HoursWorked the HoursWorked to set
     */
    public void setHoursWorked(int HoursWorked) {
        this.HoursWorked = HoursWorked;
    }

    /**
     * @return the BasicSalary
     */
    public int getBasicSalary() {
        return BasicSalary;
    }

    /**
     * @param BasicSalary the BasicSalary to set
     */
    public void setBasicSalary(int BasicSalary) {
        this.BasicSalary = BasicSalary;
    }

    /**
     * @return the AmountEarned
     */
    public int getAmountEarned() {
        return AmountEarned;
    }

    /**
     * @param AmountEarned the AmountEarned to set
     */
    public void setAmountEarned(int AmountEarned) {
        this.AmountEarned = AmountEarned;
    }

    /**
     * @return the month
     */
    public String getMonth() {
        return month;
    }

    /**
     * @param month the month to set
     */
    public void setMonth(String month) {
        this.month = month;
    }

    /**
     * @return the year
     */
    public String getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "AmountEarnedModel{" + "Date=" + Date + ", EmployeeID=" + EmployeeID + ", HoursWorked=" + HoursWorked + ", BasicSalary=" + BasicSalary + ", AmountEarned=" + AmountEarned + ", month=" + month + ", year=" + year + '}';
    }

  
   
}
 
