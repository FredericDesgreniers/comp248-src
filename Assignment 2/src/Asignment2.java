// -----------------------------------------------------
// Assignment 2
// Question: 1
// Written by:  Frederic Desgreniers 40016777
// -----------------------------------------------------


import java.util.Scanner;

/**
 *
 * @author frede
 */
public class Asignment2 {
    static int error=0;
    static double total=0;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //rounds doubles to ints since the number must be whole
        int itemNum = (int)(getInput(sc,"number of items bought",1,10));
        for(int i=0;i<itemNum;i++){
            total +=getInput(sc,"price of item "+(i+1),1,1000);
        }
        double subTotal = total;
        double gst = getInput(sc,"tax rate of GST in %",0,14);
        double qst = getInput(sc,"tax rate of QST in %",0,17);
        
        double gstTotal = addTax(gst);
        double qstTotal = addTax(qst);
        
        
        System.out.println("You have entered "+error+" invalid inputs.");
        System.out.printf("Sub Total: \t %.2f$ \n", subTotal);
        System.out.printf("GST: \t\t %.2f$ \n", gstTotal);
        System.out.printf("QST: \t\t %.2f$ \n", qstTotal);
        System.out.printf("Total: \t\t %.2f$ \n", total);
    }
    public static double getInput(Scanner sc,String promp,int min, int max){
        double input=-1;
        do{
            error++; //increments error for each try
            try{
                //prints the promp
                System.out.println("Please enter the "+promp+" ["+min+"..."+max+"]");
                input = sc.nextDouble();
            }catch(Exception e){
                sc.nextLine();
                continue;
            }
            }while(input<min || input>max);
        error--; //decrements error to nullifie the increase since the input is valid
        return input;
    }
    public static double addTax(double percent){
        double realTax = percent/100;
        double tax = total*realTax;
        total+=tax;
        return tax;
    }
}
