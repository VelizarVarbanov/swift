package task4_PersonCharacteristics;

import task4_PersonCharacteristics.education.Education;
import task4_PersonCharacteristics.education.HigherEducation;
import task4_PersonCharacteristics.education.PrimaryEducation;
import task4_PersonCharacteristics.education.SecondaryEducation;

import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class PersonCharacteristics {
    public static String code;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String empty = sc.nextLine();
        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            String[] split = input.split(";");

            DateTimeFormatter graduatedFormat = DateTimeFormatter.ofPattern("d.M.yyyy");
            LocalDate graduated = LocalDate.parse(split[8], graduatedFormat);
            if (graduated.getYear() < Year.now().getValue()) {
                Education.graduated = "true";
            } else Education.graduated = "false";
            code = split[5];
            //Peter;Petrov;M;184;9.9.1985;S;SOU Pushkin;15.9.2000;20.5.2005;5.11
            // Ivan;Ivanov;M;177;29.2.2000;S;SOU Chintulov;16.9.2015;22.5.2020
            if (code.equals("S")) {
                if (Education.graduated.equals("true")) {
                    SecondaryEducation secondaryEducation = new SecondaryEducation(Education.graduated, split[7], split[8], split[6], Float.parseFloat(split[9]));
                    Person student = new Person(split[0], split[1], split[2], split[4]);
                    System.out.println(SecondaryEducation.getInfo());
                } else if (Education.graduated.equals("false")) {
                    SecondaryEducation secondaryEducation = new SecondaryEducation(Education.graduated, split[7], split[8], split[6]);
                    Person student = new Person(split[0], split[1], split[2], split[4]);
                    System.out.println(SecondaryEducation.getInfo());
                }
            } else if (code.equals("B") || code.equals("M") || code.equals("D")) {
                if (Education.graduated.equals("true")) {
                    HigherEducation higherEducation = new HigherEducation(Education.graduated, split[7], split[8], split[6], Float.parseFloat(split[9]));
                    Person student = new Person(split[0], split[1], split[2], split[4]);
                    System.out.println(HigherEducation.getInfo());
                } else if (Education.graduated.equals("false")) {
                    HigherEducation higherEducation = new HigherEducation(Education.graduated, split[7], split[8], split[6]);
                    Person student = new Person(split[0], split[1], split[2], split[4]);
                    System.out.println(HigherEducation.getInfo());
                } else if (code.equals("P")) {
                    PrimaryEducation primaryEducation = new PrimaryEducation(Education.graduated, split[7], split[8], split[6]);
                    Person student = new Person(split[0], split[1], split[2], split[4]);
                    System.out.println(PrimaryEducation.getInfo());
                }
            }
        }
    }
}