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
public class DeductionModel {
      private String Empid ;
      
       private double amount ;
       private String Reason;
       private String Date;

       DeductionModel(){
           
       }

    public DeductionModel(String id, String Reason, Double amount, String date) {
        Empid=id;
     
        this.Reason=Reason;
        this.amount=amount;
        Date=date;
                
    }

    public DeductionModel(String id, String Reason, Double amount) {
         Empid=id;
     
        this.Reason=Reason;
        this.amount=amount;
    }

    public DeductionModel(String s, String a, String z) {
         Empid=s;
     Date=a;
        this.Reason=z;
    }



  

  
    /**
     * @return the Empid
     */
    public String getEmpid() {
        return Empid;
    }

    /**
     * @param Empid the Empid to set
     */
    public void setEmpid(String Empid) {
        this.Empid = Empid;
    }



    /**
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(double amount) {
        this.amount = amount;
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
    
        @Override
    public String toString() {
        return "DeductionModel{" + "Empid=" + Empid + ", amount=" + amount + ", Reason=" + Reason + ", Date=" + Date + '}';
    }
  
    
}
