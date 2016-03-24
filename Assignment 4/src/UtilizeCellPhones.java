import java.text.NumberFormat;

/**
 * Created by frede on 2016-03-20.
 */
public class UtilizeCellPhones {

    public static void main(String[] args){
        CellPhone phone1 = new CellPhone("Samsung",123456789,299.99);
        CellPhone phone2 = new CellPhone("Apple",918238491,699.99);
        CellPhone phone3 = new CellPhone("Motorola",819375921,449.99);

        System.out.print("phone 1\n"+phone1+"\n");
        System.out.print("phone 2\n"+phone2+"\n");
        System.out.print("phone 3\n"+phone3+"\n");

        phone1.setPrice(198.23);

        phone2.setPrice(449.99);
        phone2.setBrand("Motorola");

        phone3.setSerialNumber(327348239);

        NumberFormat moneyFormatter = NumberFormat.getCurrencyInstance();

        System.out.println("Phone 1 price: "+moneyFormatter.format(phone1.getPrice()));

        System.out.println("Phone 2 brand: "+phone2.getBrand());
        System.out.println("Phone 2 price: "+moneyFormatter.format(phone2.getPrice()));

        System.out.println("Phone 3 serial: "+phone3.getSerialNumber());

        System.out.println();

        System.out.println("Phone 1 equals 2? "+phone1.equals(phone2));
        System.out.println("Phone 1 equals 3? "+phone1.equals(phone3));
        System.out.println("Phone 2 equals 3? "+phone2.equals(phone3));

    }
}
