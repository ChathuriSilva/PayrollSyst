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
public class LoanModel {
    private String Employeeid;
    private double amount;
    private String issuedDate;
     private String dueDate;
     private String Reason;
     private String settled;

    public LoanModel() {
    }

    public LoanModel(String id, Double amount,String reason, String IssuedDate, String DueDate) {
        Employeeid=id;
        this.amount=amount;
        issuedDate=IssuedDate;
        dueDate=DueDate;
        Reason=reason;
    }

   
    public LoanModel(String s, String u, String v, String w) {
          Employeeid=s;
        Reason=u;
        issuedDate=v;
        dueDate=w;
      
    }

    public LoanModel(String Reason, Double amount, String month, String year) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public LoanModel(String id, Double amount, String Reason, String sue, String due, String settled) {
         Employeeid=id;
        this.amount=amount;
        issuedDate=sue;
        dueDate=due;
        this.Reason=Reason;
        this.settled=settled;
    }

   
     
    /**
     * @return the Employeeid
     */
    public String getEmployeeid() {
        return Employeeid;
    }

    /**
     * @param Employeeid the Employeeid to set
     */
    public void setEmployeeid(String Employeeid) {
        this.Employeeid = Employeeid;
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
     * @return the issuedDate
     */
    public String getIssuedDate() {
        return issuedDate;
    }

    /**
     * @param issuedDate the issuedDate to set
     */
    public void setIssuedDate(String issuedDate) {
        this.issuedDate = issuedDate;
    }

    /**
     * @return the dueDate
     */
    public String getDueDate() {
        return dueDate;
    }

    /**
     * @param dueDate the dueDate to set
     */
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
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
     * @return the settled
     */
    public String getSettled() {
        return settled;
    }

    /**
     * @param settled the settled to set
     */
    public void setSettled(String settled) {
        this.settled = settled;
    }
    
                @Override
    public String toString() {
        return "LoanModel{" + "Employeeid=" + Employeeid + ", amount=" + amount + ", issuedDate=" + issuedDate + ", dueDate=" + dueDate + ",Reason=" +Reason+  ",settled=" +settled+'}';
    }

   
    
}
