package task1_School;

import java.util.Scanner;

public class Task1_School {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] split = input.split(",");
        MySqlSchoolData msql = new MySqlSchoolData();
//      msql.insertTeacher(split[0], split[1], Double.parseDouble(split[2]));
//      msql.getTeacher(Integer.parseInt(input));
//      msql.getTeachers(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
//      msql.insertStudent(split[0], split[1]); DateFormat - "20000101"
//      msql.getStudent(Integer.parseInt(input));
//      msql.getStudents(input);
//      msql.getTeachersAndDisciplines(Integer.parseInt(input));
        msql.getDisciplinesAndTeachers(input);
    }
}
