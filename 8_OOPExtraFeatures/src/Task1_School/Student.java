package Task1_School;

public class Student extends Class {
    public Student(String nameClass, String name, int number) {
        super(nameClass);
        this.setName(name);
        this.setNumber(number);
    }

    String name;
    int number;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
