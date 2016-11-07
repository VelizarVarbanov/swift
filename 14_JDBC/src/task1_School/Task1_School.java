package task1_School;

import java.util.Scanner;

public class Task1_School {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] split = input.split(",");
        MySqlSchoolData msql = new MySqlSchoolData();
        for (String s :  msql.getDisciplinesAndTeachers(input)) {
            System.out.println(s);
        }

    }
}
