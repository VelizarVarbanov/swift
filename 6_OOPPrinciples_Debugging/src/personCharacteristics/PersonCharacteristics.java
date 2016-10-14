package personCharacteristics;

import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class PersonCharacteristics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String empty = sc.nextLine();
        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            String[] split = input.split(";");



            DateTimeFormatter graduatedFormat = DateTimeFormatter.ofPattern("d.M.yyyy");
            LocalDate graduated = LocalDate.parse(split[7], graduatedFormat);
            if (graduated.getYear() < Year.now().getValue()) {
                SecondaryEducation.graduated = true;
            }
            else SecondaryEducation.graduated = false;

            if (SecondaryEducation.graduated == true) {
                SecondaryEducation secondaryEducation = new SecondaryEducation(split[5], split[6], split[7], split[8]);
                Person student = new Person(split[0], split[1], split[2], Short.parseShort(split[3]), split[4], secondaryEducation);
                System.out.println(student.getInfo());
            }
            if (SecondaryEducation.graduated == false) {
                SecondaryEducation secondaryEducation = new SecondaryEducation(split[5], split[6], split[7]);
                Person student = new Person(split[0], split[1], split[2], Short.parseShort(split[3]), split[4], secondaryEducation);
                System.out.println(student.getInfo());
            }
        }

    }
}
