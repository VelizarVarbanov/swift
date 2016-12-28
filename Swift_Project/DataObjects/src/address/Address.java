package address;

import java.util.Objects;

public class Address {

    public String country;
    public String city;
    public String municipality;
    public String postalCode;
    public String street;
    public String number;
    public Integer floor;
    public Integer apartmentNo;

    public Address(String country, String city, String municipality, String postalCode,
            String street, String number, Integer floor, Integer apartmentNo) {

        if (country.isEmpty()) {
            throw new IllegalArgumentException("Country field cannot be empty.");
        }
        if (city.isEmpty()) {
            throw new IllegalArgumentException("City field cannot be empty.");
        }
        if (postalCode.isEmpty()) {
            throw new IllegalArgumentException("Postal code field cannot be empty.");
        }
        if (street.isEmpty()) {
            throw new IllegalArgumentException("Street field cannot be empty.");
        }
        if (number.isEmpty()) {
            throw new IllegalArgumentException("Number field cannot be empty.");
        }
        if (this.floor != null && this.floor < 0) {
            throw new IllegalArgumentException("Floor field cannot be negative.");
        }
        if (this.apartmentNo != null && this.apartmentNo <= 0) {
            throw new IllegalArgumentException("Apartment number field must be positive.");
        }

        this.country = country;
        this.city = city;
        this.municipality = municipality;
        this.postalCode = postalCode;
        this.street = street;
        this.number = number;
        this.floor = floor;
        this.apartmentNo = apartmentNo;
    }

    public Address(String country, String city, String municipality, String postalCode,
            String street, String number) {
        this(country, city, municipality, postalCode, street, number, null, null);
    }

    @Override
    public String toString() {
        String result = String.format("%s %s Street%n", number, street);
        if (floor != null && apartmentNo != null) {
            result += String.format("fl. %d, ap. %d%n", floor, apartmentNo);
        }
        result += String.format("%s %s%n", postalCode, municipality);
        result += String.format("%s, %s", city, country);

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Address) {
            Address other = (Address) obj;
            if (!this.country.equalsIgnoreCase(other.country)) {
                return false;
            }
            if (!this.city.equalsIgnoreCase(other.city)) {
                return false;
            }
            if (!this.municipality.equalsIgnoreCase(other.municipality)) {
                return false;
            }
            if (!this.postalCode.equalsIgnoreCase(other.postalCode)) {
                return false;
            }
            if (!this.street.equalsIgnoreCase(other.street)) {
                return false;
            }
            if (!this.number.equalsIgnoreCase(other.number)) {
                return false;
            }
            if (!Objects.equals(this.floor, other.floor)) {
                return false;
            }
            if (!Objects.equals(this.apartmentNo, other.apartmentNo)) {
                return false;
            }

            return true;
        }

        return false;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getMunicipality() {
        return municipality;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getStreet() {
        return street;
    }

    public Integer getFloor() {
        return floor;
    }

    public Integer getApartmentNo() {
        return apartmentNo;
    }

    public String getNumber() {
        return number;
    }

}
