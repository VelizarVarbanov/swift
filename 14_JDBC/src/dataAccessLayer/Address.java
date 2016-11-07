package dataAccessLayer;


public class Address {

    String country;
    String city;
    String manucipality;
    String postal_code;
    String street;
    String number;
    int floor;
    int apartmentNo;

    public Address(String country, String city, String manucipality, String postal_code, String street, String number, int floor, int apartmentNo) {
        this.country = country;
        this.city = city;
        this.manucipality = manucipality;
        this.postal_code = postal_code;
        this.street = street;
        this.number = number;
        this.floor = floor;
        this.apartmentNo = apartmentNo;
    }

}
