/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentoopt;

/**
 *
 * @author User
 */
public class Staff extends Person {
    private String staffID;
    private String position;
    private String password;
    private static int staffCounter=0;
    private final static String STAFF_PREFIX = "S";

    public Staff(String name, int age,char gender,String password) {
        super(name, age,gender);
        this.password =password;
        this.staffID = STAFF_PREFIX+String.format("%04d", ++staffCounter); 
        this.position = "cashier";
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPassword() {
        return password;
    }

    public static int getStaffCounter() {
        return staffCounter;
    }
    
    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    @Override
    public String toString() {
        return super.toString()+"\nStaff ID : " + staffID +"\n"
                + "===========================================================";
    }
}
