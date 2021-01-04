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
public class EmployeeModel {
     private String id ;
       private String fullname;
       private int contact ;
       private String role;
       private double BasicSalary;

    public EmployeeModel() {
    }
    
    public EmployeeModel(String id ,String fullname, int contact,String role,double BasicSalary) {
        this.id=id;
        this.fullname=fullname;
        this.contact=contact;
        this.role=role;
        this.BasicSalary=BasicSalary;
    }

    public EmployeeModel(String s) {
        id=s;
    }

   
         
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the fullname
     */
    public String getFullname() {
        return fullname;
    }

    /**
     * @param fullname the fullname to set
     */
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    /**
     * @return the contact
     */
    public int getContact() {
        return contact;
    }

    /**
     * @param contact the contact to set
     */
    public void setContact(int contact) {
        this.contact = contact;
    }

    /**
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * @return the BasicSalary
     */
    public double getBasicSalary() {
        return BasicSalary;
    }

    /**
     * @param BasicSalary the BasicSalary to set
     */
    public void setBasicSalary(double BasicSalary) {
        this.BasicSalary = BasicSalary;
    }
    
            @Override
    public String toString() {
        return "EmployeeModel{" + "id=" + id + ", fullname=" + fullname + ", contact=" + contact + ", role=" + role + ",BasicSalary=" +BasicSalary+ '}';
    }
  
    
}
   