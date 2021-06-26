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
public class Order {
    private Product product;
    private String name;
    private int qty;
    private double price;
    private double totalPrice;
    private double amtPaid;
    private static int orderCounter = 0;
    
    public Order(Product product, String name, int qty, double price, double totalPrice) {
        this.product = product;
        this.name = name;
        this.qty = qty;
        this.price = price;
        this.totalPrice = totalPrice;
        //this.amtPaid = amtPaid;
        orderCounter++;
        

    }

    public Order(double amtPaid) {
        this.amtPaid = amtPaid;
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    

    public static int getOrderCounter() {
        return orderCounter;
    }

    public double getTotal() {
        return qty * product.getProdPrice();
    }

    @Override
    public String toString() {
        return "Order{" + "product=" + product.getProdName() + ", qty=" + qty + ", price=" + price + "}\n";
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getAmtPaid() {
        return amtPaid;
    }

    public void setAmtPaid(double amtPaid) {
        this.amtPaid = amtPaid;
    }

    public double calcTotal() {
        return totalPrice = price * qty;
    }

    public double calcTotalOfAll() {
        return totalPrice += totalPrice;
    }

}

