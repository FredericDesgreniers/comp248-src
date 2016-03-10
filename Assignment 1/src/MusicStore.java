
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author frede
 */
public class MusicStore {
    /**
     * Price per app
     */
    static final double appPrice = 3;
    
    /**
     * price per song
     */
    static final double songPrice = 7;
        
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in); //scanner used for input
        
        //Get prepaid money from user
        System.out.println("\nHow much do you want to prepay?");
        
        double prepayAmmount; 
        
        try{ //prevent crash if user enters something not convertable to double
             prepayAmmount = Double.valueOf(scanner.nextLine()); //Get value from user and convert to String
        }catch(Exception e){
            prepayAmmount = -1; //put ammount to -1 so while loop trigers and user can input again
        } 
        
        while(prepayAmmount<0){ //make sure value is >=0s
            System.out.println("Please enter an ammount of money greater then 0:"); //ask for a correct value
            Double.valueOf(scanner.nextLine());
        }
        scanner.close();
        //Print budjet if you only buy apps
        System.out.println("You have prepaid for $" + prepayAmmount + "!");
        printBudjet("app", appPrice, prepayAmmount);
        
        System.out.println("\n--------------------------------------\n");
        
        //print budjet if you buy both songs and apps
        double moneyLeft  = printBudjet("song", songPrice, prepayAmmount);
        System.out.println("With the money left...");
        printBudjet("app", appPrice, moneyLeft);
    }
    /**
     * Print budjet for an item
     * @param name name of item that can be bought
     * @param price price of item
     * @param money money to spend
     * @return money left after buying maximum num of item
     */
    static double printBudjet(String name,double price,double money){
        int itemNum  = (int)(money / price); //ammount of items that can be bought.
        double moneyLeft = money - (double)itemNum * price; //ammount of money left after buying the item(s)
        System.out.println("You can buy " + itemNum + " " + name + ( itemNum > 1 ? "s" : "" ) + " and you will have $" + moneyLeft + " left!");
        return moneyLeft; 
    }
    
}
