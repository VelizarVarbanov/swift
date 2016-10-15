package task1_PeoplePresentation;

import java.util.Scanner;

public class Task1_PeoplePresentation {
    public static void main(String[] args) {
        String input;
        Scanner sc = new Scanner(System.in);
        String[] split;

        do {
            input = sc.nextLine();
            if (input.equals("END")) break;
            split = input.split(" ");
            String firstName = split[0];
            String lastName = split[1];
            switch(split.length) {
                case 5:
                    String facultyNumber = split[2];
                    int lectureCount = Integer.parseInt(split[3]);
                    int exerciseCount = Integer.parseInt(split[4]);
                    Student student = new Student(firstName, lastName, facultyNumber, lectureCount, exerciseCount);
                    student.printInfo();
                    break;
                case 4:
                    double weekSalary = Double.parseDouble(split[2]);
                    double workHoursPerDay = Double.parseDouble(split[3]);
                    Worker worker = new Worker(firstName, lastName, weekSalary, workHoursPerDay);
                    worker.printInfo();
                    break;
            }
        }while (!input.equals("END"));


    }
}
