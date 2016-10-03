import java.util.Scanner;

public class Task2e_LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        int end = 0;
        int bestEnd=0;
        int len=0;
        int[] digits = new int[n];
        for (int i = 0; i < n; i++) {
            digits[i] = sc.nextInt();
        }
        for (int i = 0; i < digits.length; i++) {
            if (i < digits.length - 1) {
                if (digits[i] < digits[i + 1]) {
                    count++;
                    end = i + 1;
                }
                else if (count > len) {
                    len = count;
                    bestEnd = end;
                }
                if (digits[i] > digits[i + 1]) {
                    count = 0;
                }
            }
        }
        for (int i = bestEnd - len; i <= bestEnd; i++) {
            System.out.println(digits[i]);

        }
    }
}
