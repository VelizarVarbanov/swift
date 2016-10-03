import java.util.Scanner;

public class PersonCharacteristics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = "";
        Person per = new Person();
        for (int i = 0; i < n; i++) {
            str = sc.next();
            per.printData(n, str);
        }
    }
public static class Person {

        public void printData(int n, String str) {
            double[][] grades = new double[n][4];
            double[] average = new double[n];
            String[] split = new String[11];
            String[] name = new String[n];
            String[] lastName = new String[n];
            char[] gender = new char[n];
            int[] yearOfBirth = new int[n];
            int[] age = new int[n];
            double[] weight = new double[n];
            int[] height = new int[n];
            String[] jobTitle = new String[n];
            for (int i = 0; i < n; i++) {
                split = str.split(",");
                name[i] = split[0];
                lastName[i] = split[1];
                gender[i] = split[2].charAt(0);
                yearOfBirth[i] = Integer.parseInt(split[3]);
                age[i] = 2016 - yearOfBirth[i];
                weight[i] = Double.parseDouble(split[4]);
                height[i] = Integer.parseInt(split[5]);
                jobTitle[i] = split[6];
                grades[i][0] = Double.parseDouble(split[7]);
                grades[i][1] = Double.parseDouble(split[8]);
                grades[i][2] = Double.parseDouble(split[9]);
                grades[i][3] = Double.parseDouble(split[10]);
                average[i] = (grades[i][0] + grades[i][1] + grades[i][2] + grades[i][3]) / 4.0;
            }
            for (int i = 0; i < 1; i++) {
                if (gender[i] == 'M') {
                    if (yearOfBirth[i] >= 1999)
                        System.out.printf("%s %s is %d years old. He was born in %d. His weight is %.1f and he is %d cm tall. He is a %s with an average grade of %.3f. %s %s is under-aged.", name[i], lastName[i], age[i], yearOfBirth[i], weight[i], height[i], jobTitle[i], average[i], name[i], lastName[i]);
                    if (yearOfBirth[i] < 1999)
                        System.out.printf("%s %s is %d years old. He was born in %d. His weight is %.1f and he is %d cm tall. He is a %s with an average grade of %.3f.", name[i], lastName[i], age[i], yearOfBirth[i], weight[i], height[i], jobTitle[i], average[i], name[i], lastName[i]);
                }
                if (gender[i] == 'F') {
                    if (yearOfBirth[i] >= 1999)
                        System.out.printf("%s %s is %d years old. She was born in %d. Her weight is %.1f and she is %d cm tall. She is a %s with an average grade of %.3f. %s %s is under-aged.", name[i], lastName[i], age[i], yearOfBirth[i], weight[i], height[i], jobTitle[i], average[i], name[i], lastName[i]);
                    if (yearOfBirth[i] < 1999)
                        System.out.printf("%s %s is %d years old. She was born in %d. Her weight is %.1f and she is %d cm tall. She is a %s with an average grade of %.3f.", name[i], lastName[i], age[i], yearOfBirth[i], weight[i], height[i], jobTitle[i], average[i], name[i], lastName[i]);

                }
                System.out.println();
            }

        }
    }
}



