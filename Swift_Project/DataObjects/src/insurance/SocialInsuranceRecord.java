package insurance;


public class SocialInsuranceRecord {

    public final int year;

    public final int month;

    public final double amount;


    public SocialInsuranceRecord(int year, int month, double amount) {

        this.year = year;

        this.month = month;

        this.amount = amount;

    }
    
    
public double getAmount(){

        return amount;

    }


    public int getMonth() {

        return month;

    }


    public int getYear() {

        return year;

    }


}
