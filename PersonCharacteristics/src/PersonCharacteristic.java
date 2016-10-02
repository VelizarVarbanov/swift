import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PersonCharacteristic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] grades = new double[4];
        String name = null;

        for (int i = 0; i < n; i++) {
            Pattern pattern = Pattern.compile("[a-zA-Z]+");
            System.out.println("Enter your name: ");
            do {
                name = sc.nextLine();
            }
            while (!pattern.matcher(name).matches());

            String lastName = null;
            Pattern patternLast = Pattern.compile("[a-zA-Z]+");

            System.out.println("Enter your last name: ");
            do {
                lastName = sc.nextLine();
            }
            while (!patternLast.matcher(lastName).matches());

            System.out.println("Enter your gender: ");
            char gender;
            do {
                gender = sc.next().charAt(0);
            }
            while (gender != 'F' && gender != 'M');

            System.out.println("Enter your year of birth");
            int yearOfBirth = 0;
            do {
                yearOfBirth = sc.nextInt();
            }
            while (yearOfBirth <= 1900);
            int age = 2016 - yearOfBirth;


            float weight = 0.0f;

            System.out.println("Enter your weight: ");
            do {
                weight = sc.nextFloat();
            }
            while (weight <= 20.0);


            int height = 0;

            System.out.println("Enter your height: ");
            do {
                height = sc.nextInt();
            }
            while (height <= 0);

            String jobTitle = null;
            Pattern jobPattern = Pattern.compile("[a-zA-z]+");

            System.out.println("Enter your profession: ");
            do {
                jobTitle = sc.nextLine();
            }
            while (!jobPattern.matcher(jobTitle).matches());
            System.out.println("Enter the grades");
            double result = 0.0;
            for (int j = 0; j < 4; j++) {
                do {
                    grades[j] = sc.nextDouble();
                }
                while (grades[j] < 2.0 || grades[j] > 6.0);
                result += grades[j];
            }
            result = result / 4.0;
            if (gender == 'M') {
                if (yearOfBirth >= 1999)
                    System.out.printf("%s %s is %d years old. He was born in %d. His weight is %.1f and he is %d cm tall. He is a %s with an average grade of %.3f. %s %s is under-aged.", name, lastName, age, yearOfBirth, weight, height, jobTitle, result, name, lastName);
                if (yearOfBirth < 1999)
                    System.out.printf("%s %s is %d years old. He was born in %d. His weight is %.1f and he is %d cm tall. He is a %s with an average grade of %.3f.", name, lastName, age, yearOfBirth, weight, height, jobTitle, result);
            }
            if (gender == 'F') {
                if (yearOfBirth >= 1999)
                    System.out.printf("%s %s is %d years old. She was born in %d. Her weight is %.1f and she is %d cm tall. She is a %s with an average grade of %.3f. %s %s is under-aged.", name, lastName, age, yearOfBirth, weight, height, jobTitle, result, name, lastName);
                if (yearOfBirth < 1999)
                    System.out.printf("%s %s is %d years old. She was born in %d. Her weight is %.1f and she is %d cm tall. She is a %s with an average grade of %.3f.", name, lastName, age, yearOfBirth, weight, height, jobTitle, result);

            }
            System.out.println();
        }
    }
}

