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
public class BonusModel {
    private int Id;
    private String Reason;
    private double Amount;
    private String MonthGiven;
    private String YearGiven;

    BonusModel(){
        
    }

    public BonusModel(String Reason, Double amount, String month, String year) {
        this.Reason=Reason;
        Amount=amount;
        MonthGiven=month;
        YearGiven=year;
    }

    public BonusModel(String reason, String month, String year) {
        Reason=reason;
        MonthGiven=month;
        YearGiven=year;
    }

    public BonusModel(int id, String Reason, double amount, String Month, String Year) {
        Id=id;
        this.Reason=Reason;
        Amount=amount;
        MonthGiven=Month;
        YearGiven=Year;
    }

    public BonusModel(int id) {
         Id=id;
    }

    public BonusModel(int id, String Reason, double amount, int Month, String Year) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * @return the Reason
     */
    public String getReason() {
        return Reason;
    }

    /**
     * @param Reason the Reason to set
     */
    public void setReason(String Reason) {
        this.Reason = Reason;
    }

    /**
     * @return the Amount
     */
    public double getAmount() {
        return Amount;
    }

    /**
     * @param Amount the Amount to set
     */
    public void setAmount(double Amount) {
        this.Amount = Amount;
    }

    /**
     * @return the MonthGiven
     */
    public String getMonthGiven() {
        return MonthGiven;
    }

    /**
     * @param MonthGiven the MonthGiven to set
     */
    public void setMonthGiven(String MonthGiven) {
        this.MonthGiven = MonthGiven;
    }

    /**
     * @return the YearGiven
     */
    public String getYearGiven() {
        return YearGiven;
    }

    /**
     * @param YearGiven the YearGiven to set
     */
    public void setYearGiven(String YearGiven) {
        this.YearGiven = YearGiven;
    }

    /**
     * @return the Id
     */
    public int getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(int Id) {
        this.Id = Id;
    }
    
        @Override
    public String toString() {
        return "BonusModel{" + "Id=" + Id + ", Reason=" + Reason + ", Amount=" + Amount + ", MonthGiven=" + MonthGiven + ", YearGiven=" + YearGiven + '}';
    }
}
 