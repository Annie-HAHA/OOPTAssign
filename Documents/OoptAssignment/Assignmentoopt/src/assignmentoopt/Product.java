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
public class Product {
    private String prodName;
    private double prodPrice;
    private static int prodCounter=0;
    private static int removeProd=0;
    private int prodID;

    public Product(String prodName, double prodPrice) {
        this.prodName = prodName;
        this.prodPrice = prodPrice;
        prodCounter++;
        prodID = prodCounter;
    }

    public static int getProdCounter() {
        return prodCounter;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public double getProdPrice() {
        return prodPrice;
    }

    public void setProdPrice(double prodPrice) {
        this.prodPrice = prodPrice;
    }

    public int getProdID() {
        return prodID;
    }

    public static int getRemoveProd() {
        return removeProd;
    }
     
    public static void incRemoveProd(){
        removeProd++;
    }
}
