
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
        Random r = new Random(System.currentTimeMillis());
        String[] brands = {"Google","Nokia","Samsung","Microsoft","Android","Apple"};
        CellPhone[][] phones = new CellPhone[10][10];
        for(int i=0;i<phones.length;i++){
            for(int j=0;j<phones[i].length;j++){
                boolean copy = r.nextInt(2)==0;
                if(copy){
                    
                }
                
                String brand = brands[r.nextInt(brands.length)];
            }
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
