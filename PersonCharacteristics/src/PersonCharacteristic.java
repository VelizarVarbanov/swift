import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PersonCharacteristic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String name = null;
        Pattern pattern = Pattern.compile("[a-zA-Z]+");
        for (int i = 0; i < n; i++) {
            System.out.println("Enter your name: ");
            do {
                name = sc.nextLine();
            }
            while (!pattern.matcher(name).matches());
        }
        String lastName = null;
        Pattern patternLast = Pattern.compile("[a-zA-Z]+");
        for (int i = 0; i < n; i++) {
            System.out.println("Enter your last name: ");
            do {
                lastName = sc.nextLine();
            }
            while (!patternLast.matcher(lastName).matches());
        }
        int yearOfBirth = 0;
        for (int j = 0; j < n; j++) {
            System.out.println("Enter your year of birth");
            do {
                yearOfBirth = sc.nextInt();
            }
            while (yearOfBirth <= 1900);
            if (yearOfBirth >= 1998) {
                System.out.println("Sorry not old enough");
            } else System.out.println("You can enter");
        }

        float weight = 0.0f;
        for (int i = 0; i < n; i++) {
            System.out.println("Enter your weight: ");
            do {
                weight = sc.nextFloat();
            }
            while (weight <= 20.0);
        }


        float height = 0.0f;
        for (int i = 0; i < n; i++) {
            System.out.println("Enter your height: ");
            do {
                height = sc.nextFloat();
            }
            while (height <= 0.0);
        }
        String jobTitle = null;
        Pattern jobPattern = Pattern.compile("[a-zA-z]+");
        for (int i = 0; i < n; i++) {
            System.out.println("Enter your profession: ");
            do {
                jobTitle = sc.nextLine();
            }
            while (!jobPattern.matcher(jobTitle).matches());
        }
    }
}
