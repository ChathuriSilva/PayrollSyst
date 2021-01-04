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
public class generatePayrollModel {

    private String empId;
    private String year;
    private String month;
    
    
    public generatePayrollModel(){
        
    }
    
    public generatePayrollModel(String empID, String month, String year) {
        this.empId=empID;
        this.month=month;
        this.year=year;  
    }



    /**
     * @return the empId
     */
    public String getEmpId() {
        return empId;
    }

    /**
     * @param empId the empId to set
     */
    public void setEmpId(String empId) {
        this.empId = empId;
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

    @Override
    public String toString() {
        return "generatePayrollModel{" + "empId=" + empId + ", year=" + year + ", month=" + month + '}';
    }

 
    
}
