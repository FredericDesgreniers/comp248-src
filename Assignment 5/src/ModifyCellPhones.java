
import javafx.scene.control.Cell;

import java.text.DecimalFormat;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author f_desgr
 */
public class ModifyCellPhones {

    public static void main(String[] args){
        Random r = new Random(System.currentTimeMillis());//Random object used for info generation
        String[] brands = {"Google","Nokia","Samsung","Microsoft","Android","Apple"}; //list of possible brands
        CellPhone[][] phones = new CellPhone[10][10];   //create blank cellphone array
        for(int i=0;i<phones.length;i++){
            for(int j=0;j<phones[i].length;j++){
                boolean copy = r.nextInt(2)==0 && i>0 && j>0; //checks if it should be a copy
                if(copy){
                    int ri = r.nextInt(i);
                    int rj = r.nextInt(j);
                    phones[i][j] = new CellPhone(phones[ri][rj]); //copies a already generated cellphone
                }else{
                    String brand = brands[r.nextInt(brands.length)]; //gets a random brand from the list
                    double price = r.nextDouble()*500;
                    long serial = 0;
                    for(int s1=0;s1<9;s1++){  //generate 8 digit long serial
                        int rs = r.nextInt(10);
                        if(serial==0 && rs==0){
                            rs++;
                        }
                        serial = (serial*10)+rs;
                    }
                    phones[i][j] = new CellPhone(brand,serial,price);
                }
                

            }
        }
        System.out.println("Original Random Array"); //print the original prices, before any modification
        printPriceFormated(phones);

        modifyCellPhones(phones); //modify the prices to all be within 100 - 299

        System.out.println("Modified Array");  //print modified cellphones
        printPriceFormated(phones);

        int i = r.nextInt(phones.length);
        int j = r.nextInt(phones[i].length);
        double price = phones[i][j].getPrice(); //get the random price of a cellphone
        System.out.println("Changing all phones of price "+String.format("%.2f",price)+" to price 999.");
        modifyPhonePrices(phones,price,999); //use random price for replacement
        printPriceFormated(phones);
        
    }
    public static void modifyCellPhones(CellPhone[][] phones){ //modifies any cellphone not within 100-299$ to a price in that range

        Random r = new Random(System.currentTimeMillis());
        for(int i=0;i<phones.length;i++){
            for(int j=0;j<phones[i].length;j++){
                CellPhone p = phones[i][j];
                if(p.getPrice()<100 || p.getPrice()>=300){
                    p.setPrice(r.nextInt(200)+100);
                }

            }
        }
    }
    public static void printPriceFormated(CellPhone[][] phones){ //print a formated view of the array

        int i=0;
        System.out.print("i j\t");
        for(int j=0;j<phones[0].length;j++){
            System.out.print(j+"\t\t\t"); //print the 'j' column number
        }
        System.out.println();
        for(CellPhone[] pa1:phones){
            System.out.print(i+"\t"); //prints the 'i' row number

            for(CellPhone p:pa1){

                    double price = p.getPrice();
                    System.out.print(String.format("%5.2f",price) + "\t\t"); //print formated price so it uses the same ammount of space

            }
            System.out.println();
            i++;
        }
    }
    public static int modifyPhonePrices(CellPhone[][] phones, double d1, double d2){ 
        int n = 0;
        for(int i=0;i<phones.length;i++){
            for(int j=0;j<phones[i].length;j++){
                CellPhone c = phones[i][j];
                if(c.getPrice()==d1){
                    c.setPrice(d2);
                    n++;
                    System.out.println("CellPhone at ("+i+","+j+") has been changed");
                }
            }
        }
        return n;
    }
}
