/**
 * Created by frede on 2016-03-20.
 */
public class CellPhone {

    private String brand;
    private long serialNumber;
    private double price;

    public CellPhone(String brand, long serialNumber, double price){

        this.brand = brand;
        this.serialNumber = serialNumber;
        this.price = price;
    }

    public boolean equals(CellPhone phone){
        return (brand.equals(phone.getBrand()) && price == phone.getPrice());
    }

    public String toString(){
        String str = "";
        str+="Brand: "+brand+"\n";
        str+="Serial: "+serialNumber+"\n";
        str+="price: $"+price+"\n";
        return str;
    }



    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public long getSerialNumber(){
        return serialNumber;
    }

    public void setSerialNumber(long serialNumber){
        this.serialNumber = serialNumber;
    }

    public String getBrand(){
        return brand;
    }

    public void setBrand(String brand){
        this.brand = brand;
    }
}
