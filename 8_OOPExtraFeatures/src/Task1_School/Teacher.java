package Task1_School;

public class Teacher extends Class {

    public Teacher(String nameClass, String nameTeacher) {
        super(nameClass);
        this.setNameTeacher(nameTeacher);
    }

    public String getNameTeacher() {
        return nameTeacher;
    }

    public void setNameTeacher(String nameTeacher) {
        this.nameTeacher = nameTeacher;
    }

    String nameTeacher;

}
