/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tsmith
 */
abstract public class Product {
    
    //Declared variables
    private int item_number;
    public static int item_num;
    private String product_name = " ";
    private int unit_amount;
    private double unit_price;
    private String product_status = " ";


    //Default constructor with no parameters
    public Product() {
        this.item_number = ++item_num;
        this.product_name = product_name;
        this.unit_amount = unit_amount;
        this.unit_price = unit_price;
        this.product_status = product_status;
    }


    //Overloaded constructor with paprmeters that initialize the instance variables
    public Product(String product_name, int unit_amount, double unit_price, String product_status) {
        this.item_number = ++item_num;
        this.product_name = product_name;
        this.unit_amount = unit_amount;
        this.unit_price = unit_price;
        this.product_status = product_status;
    }


    //Getter/accessor and setter/mutator methods
    /**
     * @return the item_number
     */
    public int getItem_number() {
        return item_number;
    }

    /**
     * @param item_number the item_number to set
     */
    public void setItem_number(int item_number) {
        this.item_number = item_number;
    }

    /**
     * @return the product_name
     */
    public String getProduct_name() {
        return product_name;
    }

    /**
     * @param product_name the product_name to set
     */
    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    /**
     * @return the unit_amount
     */
    public int getUnit_amount() {
        return unit_amount;
    }

    /**
     * @param unit_amount the unit_amount to set
     */
    public void setUnit_amount(int unit_amount) {
        this.unit_amount = unit_amount;
    }

    /**
     * @return the unit_price
     */
    public double getUnit_price() {
        return unit_price;
    }

    /**
     * @param unit_price the unit_price to set
     */
    public void setUnit_price(double unit_price) {
        this.unit_price = unit_price;
    }
    
        /**
     * @return the product_status
     */
    public String getProduct_status() {
        return product_status;
    }

    /**
     * @param product_status the product_status to set
     */
    public void setProduct_status(String product_status) {
        this.product_status = product_status;
    }


    /* toString method overrided from the object class
    showing description of each object including variable values
    printed in String.format for price (2 decimal places) and ln*/
    @Override
    public String toString() {
        //return "Item number: " + item_number + "\n" + "Name of product: " + product_name + "\n" + "Number of units in stock: " + unit_amount + "\n" + "Price of each unit: " + "$" + unit_price + "\n";     
        return String.format("Item number: %d \nName of product: %s \nNumber of units in stock: %d \nPrice of each unit: $%.2f \nProduct Status: %s \n", item_number, product_name, unit_amount, unit_price, status());
    }
    

    //Abstract Method for calculating the vale of each inventory item using quantity on hand and price 
    public abstract double stockValue(); //No argument accepted
    

    //Equals method checks to see if two objects are equal if their item number is the same
    public boolean equals(Product i){
        return i.item_number == this.item_number;
    }
    

    //Method to add to the number of units in stock
    public void addUnits(int units){
         unit_amount = getUnit_amount() + units;
    }
    

    /*Method to deduct the number of units in stock
    If Statement used to ensure that units don't become negative
    */
    public void deductUnits(int units){
        if (units <= getUnit_amount()){
            unit_amount = getUnit_amount() - units;
            
        }
        else {
            System.out.println("Not enough units in stock!");
        }
        
    }
    
    //Product status method indicating availability
    public String status(){
        this.product_status = " ";
        if(getUnit_amount() > 0){
            this.product_status = "Product is available";
        }
        else{
            this.product_status = "Product is unavailable";
        }
        return this.product_status;
    }
  
}
