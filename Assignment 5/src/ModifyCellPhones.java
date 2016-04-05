
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
                    int ri = r.nextInt(i);
                    int rj = r.nextInt(j);
                    phones[i][j] = new CellPhone(phones[ri][rj]);
                }else{
                    String brand = brands[r.nextInt(brands.length)];
                    double price = r.nextDouble()*500;
                    long serial = 0;
                    for(int s1=0;s1<9;s1++){
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
