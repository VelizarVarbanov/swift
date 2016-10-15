package task1_PeoplePresentation;

import java.util.regex.Pattern;

public class Person {
    String firstName;
    String lastName;

    public Person (String valueName, String valueLastName) {
        this.setFirstName(valueName);
        this.setLastName(valueLastName);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName.length()<2 || lastName.length()>30) {
            throw new IllegalArgumentException("Expected length for lastName is between 2 and 30 symbols.");
        }
        Pattern pattern = Pattern.compile("[a-zA-Z]+");
        if (!pattern.matcher(lastName).matches()){
            throw new IllegalArgumentException("Expected only Latin letters in lastName.");
        }
        if(!Character.isUpperCase( lastName.codePointAt(0))){
            throw new IllegalArgumentException("Expected upper case letter at first position of firstName.");
        }
        else this.lastName = lastName;
    }


    public String getFirstName(){
        return this.firstName;
    }
    public void setFirstName(String value) {
        if (value.length()<2 || value.length()>30) {
            throw new IllegalArgumentException("Expected length for firstName is between 2 and 30 symbols.");
        }
        Pattern pattern = Pattern.compile("[a-zA-Z]+");
        if (!pattern.matcher(value).matches()){
            throw new IllegalArgumentException("Expected only Latin letters in firstName.");
        }
        if(!Character.isUpperCase( value.codePointAt(0))){
            throw new IllegalArgumentException("Expected upper case letter at first position of firstName.");
        }
        else this.firstName = value;
    }
}
