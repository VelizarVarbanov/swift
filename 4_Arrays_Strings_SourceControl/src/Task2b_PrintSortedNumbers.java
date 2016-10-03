import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;


public class Task2b_PrintSortedNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] digits = new int[n];
        for (int i = 0; i < n; i++) {
            digits[i] = sc.nextInt();

        }
        Arrays.sort(digits);
        System.out.print(Arrays.toString(digits));
    }
}
