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
public class AttendanceModel {
   
    private String EmpId;
    private String CDate;
    private String Time;
  
    private int month;
    private int year;

    public AttendanceModel(int month) {
        this.month = month;
       
    }
    
   
      public AttendanceModel() {
    }

    public AttendanceModel(String EmpId, String CDate, String Time) {
        this.EmpId = EmpId;
        this.CDate= CDate;
        this.Time = Time;
    }

    /**
     * @return the EmpId
     */
    public String getEmpId() {
        return EmpId;
    }

    /**
     * @param EmpId the EmpId to set
     */
    public void setEmpId(String EmpId) {
        this.EmpId = EmpId;
    }

    /**
     * @return the CDate
     */
    public String getCDate() {
        return CDate;
    }

    /**
     * @param CDate the CDate to set
     */
    public void setCDate(String CDate) {
        this.CDate = CDate;
    }

    /**
     * @return the TimeIn
     */
    public String getTime() {
        return Time;
    }

    /**
     * @param TimeIn the TimeIn to set
     */
    public void setTime(String Time) {
        this.Time = Time;
    }

    /**
     * @return the month
     */
    public int getMonth() {
        return month;
    }

    /**
     * @param month the month to set
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * @return the TimeIn
     */
 
       @Override
    public String toString() {
        return "AttendanceModel{" + "EmpId=" + EmpId + ", CDate=" + CDate + ", Time=" + Time + ", month=" + month + ", year=" + year + '}';
    }
  
 
}
