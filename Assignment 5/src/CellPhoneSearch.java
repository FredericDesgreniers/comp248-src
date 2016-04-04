
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author f_desgr
 */
public class CellPhoneSearch {
    
    
    
    public static void main(String[] args){
        
        CellPhone[] cellphones = new CellPhone[10];
        cellphones[0] = new CellPhone("Motorola",123456789,12.54);
        cellphones[1] = new CellPhone("Apple",123456789,12.54);
        cellphones[2] = new CellPhone("Samsung",234517543,12.54);
        cellphones[3] = new CellPhone("Google",958673945,12.54);
        cellphones[4] = new CellPhone(cellphones[3]);
        cellphones[5] = new CellPhone("Sony",984658341,12.54);
        cellphones[6] = new CellPhone("Nokia",456464234,12.54);
        cellphones[7] = new CellPhone("Microsoft",625465468,12.54);
        cellphones[8] = new CellPhone("Nexus",789756746,12.54);
        cellphones[9] = new CellPhone(cellphones[1]);
        
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter a brand: ");
        String brand = kb.nextLine();
        
        System.out.println("Enter a price: ");
        double price = -1;
        boolean error = false;
        do{
            if(error)
                System.out.println("invalid value, price must be over 0$");
            error = true;
            try{
           
            price = kb.nextDouble();
            
            
            }catch(Exception e){
                price = -1;
                kb.nextLine();
            }
        }while(price<0);
        kb.nextLine();
        System.out.println("Allow seach combination? (Yes/No)");
        String ans = "";
        error = false;
        
        boolean combination = false;

        ans = kb.nextLine();
        if(ans.equalsIgnoreCase("Yes"))combination = true;
        
        int matches = 0;
        for(CellPhone c:cellphones){
            int score = 0;
            if(c.brand.equalsIgnoreCase(brand))
                score++;
            if(c.price == price)
                score++;
            
            if(score == (combination?2:1)){
                matches++;
                System.out.println("MATCH "+matches);
                System.out.println(c);
                System.out.println();
            }
            
        }
        if(matches==0)
            System.out.println("Could not find any matches!");
        
    }
    
    
    
    
    public static class CellPhone {
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

}
