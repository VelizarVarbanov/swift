package Task1_School;

public abstract class Class {
    String nameClass;

    public Class (String nameClass) {
        this.setNameClass(nameClass);
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }
    public String getNameClass() {
        return this.nameClass;
    }
}
