package Task1_School;

public class Discipline extends Teacher {
    String nameDis;
    int countHours;

    public String getNameDis() {
        return nameDis;
    }

    public void setNameDis(String nameDis) {
        this.nameDis = nameDis;
    }

    public int getCountHours() {
        return countHours;
    }

    public void setCountHours(int countHours) {
        this.countHours = countHours;
    }

    public Discipline(String nameClass, String nameTeacher, String nameDis, int countHours) {
        super(nameClass, nameTeacher);

    }
}
