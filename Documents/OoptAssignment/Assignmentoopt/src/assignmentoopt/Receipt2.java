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
public class Receipt2 {
    private double subtotal;
    private static int receiptNo = 20200000;
    private int count = 0;
    private double paid;
    private double balance;

    public Receipt2() {
        this.subtotal = subtotal;
        this.paid=paid;
        this.balance=balance;
        receiptNo++;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getPaid() {
        return paid;
    }

    public void setPaid(double paid) {
        this.paid = paid;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    public static int getReceiptNo() {
        return receiptNo;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double calSubtotal(double amount){
        subtotal += amount;
        return subtotal;
        
    }

    public void countOrder(){
        count++;
    }
    
    public void countBalance(){
        balance = paid - subtotal;
    }
    
    
}
