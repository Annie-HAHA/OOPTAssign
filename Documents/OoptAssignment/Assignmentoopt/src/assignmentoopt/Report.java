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
public class Report {
    private String itemName;
    private int qty;
    private double unitPrice;
    private double totalPrice;

    public Report(String itemName, double unitPrice) {
        this.itemName = itemName;
        this.unitPrice = unitPrice;
    }

    public Report(int qty) {
        this.qty = qty;
    }

    public Report(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public boolean equals(Object obj) {
        Report r = (Report)obj; 
        if(this.itemName == r.getItemName()){
            return true;
        }
        return false;
    }
    
    @Override
    public String toString(){
        return itemName + "\t\t" + qty + "\t\t" + unitPrice + "\t\t" + totalPrice;
    }
}
