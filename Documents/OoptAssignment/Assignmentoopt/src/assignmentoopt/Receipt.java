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
public class Receipt {
    private String pizza;
    private int quantity;
    private double price;
    private double amount;
    private int receiptNo;
    private static int count = 0;
    private double paid;
    
    
    public Receipt(String pizza, int quantity, double price, double amount) {    //String pizza, int quatity, double price
        this.pizza = pizza;
        this.quantity = quantity;
        this.price = price;
        this.amount = amount;
        this.receiptNo = receiptNo;
        this.paid = paid;
        count++;
    }
    
    public void setPizza(String pizza) {
        this.pizza = pizza;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setReceiptNo(int receiptNo) {
        this.receiptNo = receiptNo;
    }

    

    public double getPaid() {
        return paid;
    }

    public void setPaid(double paid) {
        this.paid = paid;
    }

    public String getPizza() {
        return pizza;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public double getAmount() {
        return amount;
    }

    public int getReceiptNo() {
        return receiptNo;
    }

    public static int getCount() {
        return count;
    }
    
    public void calAmount(){
        amount = price*quantity;
    }
    
    /*public void countOrder(){
        count++;
    }*/
    
    @Override
    public String toString() {
        return String.format("%d\t%s\t\t%.2f\t\t%.2f", quantity, pizza, price, amount);
    }
}
