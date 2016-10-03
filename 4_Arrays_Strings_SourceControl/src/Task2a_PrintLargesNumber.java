import java.util.Scanner;
public class Task2a_PrintLargesNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] digits = new int[n];
        int biggest = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            digits[i] = sc.nextInt();
            if (digits[i] > biggest) {
                biggest = digits[i];
            }
        }
        System.out.println(biggest);
    }
}
