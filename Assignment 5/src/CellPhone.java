/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author f_desgr
 */
public class CellPhone {
    private String brand;
    private long serial;
    private double price;
    
    public CellPhone(String brand, long serial, double price){
        this.brand = brand;
        this.serial = serial;
        this.price = price;
    }
    
    public CellPhone(CellPhone cell){
        this.brand = cell.brand;
        this.serial = cell.serial;
        this.price = cell.price;
    }
    
    public String getBrand(){
        return brand;
    }
    public void setBrand(String brand){
        this.brand = brand;
    }
    
    public long getSerial(){
        return serial;
    }
    public void setSerial(long serial){
        this.serial = serial;
    }
    
    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price = price; 
    }
    
    @Override
    public String toString(){
        String s = "";
        s+="Brand: "+brand;
        s+="\nSerial: "+serial;
        s+="\nPrice: "+price;
        return s;
    }
    
}