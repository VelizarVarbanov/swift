import java.util.Scanner;

public class Task3c_PrintChristmasTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n-2; i++) {
            for (int k = 0; k < n - i - 3; k++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i * 2 + 1; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }

        for (int i = 0; i < 1; i++) {
            for (int k = 0; k < n-3; k++) {
                System.out.print(" ");
            }
            System.out.println('*');
            for (int j = 0; j < n-4; j++) {
                    System.out.print(' ');
                }
                System.out.println("***");

        }
    }
}

