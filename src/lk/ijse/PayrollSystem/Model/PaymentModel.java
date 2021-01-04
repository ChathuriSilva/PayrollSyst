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
public class PaymentModel {
    private String EmployeeID;
    private int HourlySalary;
    private int HoursWorked;
    private int SalEarned;
    private int DueLoans;
    private int Deductions;
    private int TotPayment;
    private String date;
    private String month;
    private String year;
    private int bonus;

    public PaymentModel() {
    }


    public PaymentModel(String EmployeeID, int HourlySalary, int HoursWorked, int SalEarned, int DueLoans, int Deductions, int TotPayment, String date) {
        this.EmployeeID = EmployeeID;
        this.HourlySalary = HourlySalary;
        this.HoursWorked = HoursWorked;
        this.SalEarned = SalEarned;
        this.DueLoans = DueLoans;
        this.Deductions = Deductions;
        this.TotPayment = TotPayment;
        this.date = date;
    }

    public PaymentModel(String empID, String month, String year, int salEarn, int bonus, int loan, int ded) {
          this.EmployeeID = empID;
          this.month=month;
          this.year=year;
          this.SalEarned = salEarn;
          this.bonus=bonus;
          this.DueLoans=loan;
          this.Deductions=ded;
                  
    }


    public PaymentModel(String id, String date) {
        EmployeeID=id;
        this.date=date;
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
     * @return the HourlySalary
     */
    public int getHourlySalary() {
        return HourlySalary;
    }

    /**
     * @param HourlySalary the HourlySalary to set
     */
    public void setHourlySalary(int HourlySalary) {
        this.HourlySalary = HourlySalary;
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
     * @return the SalEarned
     */
    public int getSalEarned() {
        return SalEarned;
    }

    /**
     * @param SalEarned the SalEarned to set
     */
    public void setSalEarned(int SalEarned) {
        this.SalEarned = SalEarned;
    }

    /**
     * @return the DueLoans
     */
    public int getDueLoans() {
        return DueLoans;
    }

    /**
     * @param DueLoans the DueLoans to set
     */
    public void setDueLoans(int DueLoans) {
        this.DueLoans = DueLoans;
    }

    /**
     * @return the Deductions
     */
    public int getDeductions() {
        return Deductions;
    }

    /**
     * @param Deductions the Deductions to set
     */
    public void setDeductions(int Deductions) {
        this.Deductions = Deductions;
    }

    /**
     * @return the TotPayment
     */
    public int getTotPayment() {
        return TotPayment;
    }

    /**
     * @param TotPayment the TotPayment to set
     */
    public void setTotPayment(int TotPayment) {
        this.TotPayment = TotPayment;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
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

    /**
     * @return the bonus
     */
    public int getBonus() {
        return bonus;
    }

    /**
     * @param bonus the bonus to set
     */
    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return "PaymentModel{" + "EmployeeID=" + EmployeeID + ", HourlySalary=" + HourlySalary + ", HoursWorked=" + HoursWorked + ", SalEarned=" + SalEarned + ", DueLoans=" + DueLoans + ", Deductions=" + Deductions + ", TotPayment=" + TotPayment + ", date=" + date + ", month=" + month + ", year=" + year + ", bonus=" + bonus + '}';
    }

   
}
