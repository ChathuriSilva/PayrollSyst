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
public class AdministratorModel {
    private String id;
    private String Fullname;
    private int Contact;
    private String Username;
    private String Password;

    public AdministratorModel() {
    }
    public AdministratorModel(String Username,String Password){
        this.Username=Username;
        this.Password=Password;
    }

     public AdministratorModel(String id,String Fullname,int Contact,String Username, String Password){
        this.id=id;
        this.Fullname=Fullname;
        this.Contact=Contact;
        this.Username=Username;
        this.Password=Password;
    }

    public AdministratorModel(String id, String fullname, int contact, String username) {
         this.id=id;
        this.Fullname=fullname;
        this.Contact=contact;
        this.Username=username;
    }

    public AdministratorModel(String s) {
        this.id=s;
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
     * @return the Fullname
     */
    public String getFullname() {
        return Fullname;
    }

    /**
     * @param Fullname the Fullname to set
     */
    public void setFullname(String Fullname) {
        this.Fullname = Fullname;
    }

    /**
     * @return the Contact
     */
    public int getContact() {
        return Contact;
    }

    /**
     * @param Contact the Contact to set
     */
    public void setContact(int Contact) {
        this.Contact = Contact;
    }

    /**
     * @return the Username
     */
    public String getUsername() {
        return Username;
    }

    /**
     * @param Username the Username to set
     */
    public void setUsername(String Username) {
        this.Username = Username;
    }

    /**
     * @return the Password
     */
    public String getPassword() {
        return Password;
    }

    /**
     * @param Password the Password to set
     */
    public void setPassword(String Password) {
        this.Password = Password;
    }

    @Override
    public String toString() {
        return "AdministratorModel{" + "id=" + id + ", Fullname=" + Fullname + ", Contact=" + Contact + ", Username=" + Username + ", Password=" + Password + '}';
    }

}
