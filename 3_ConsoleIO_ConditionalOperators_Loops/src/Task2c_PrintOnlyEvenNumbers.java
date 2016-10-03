import java.util.Arrays;
import java.util.Scanner;

public class Task2c_PrintOnlyEvenNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if (num % 2 == 0) {
                System.out.print(num + " ");
            }

        }

    }
}
