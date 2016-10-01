import java.util.Scanner;

public class Task2d_PrintSplitIndex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sumLeft = 0;
        int sumRight = 0;
        String result = "NO";
        int[] digits = new int[n];
        for (int i = 0; i < n; i++) {
            digits[i] = sc.nextInt();
        }
        for (int i = 0; i < digits.length; i++) {
            for (int j = i; j >= 0; j--) {
                sumLeft += digits[j];
            }
            for (int j = i+1; j < digits.length; j++) {
                sumRight += digits[j];
            }
            if (sumLeft == sumRight) {
               result = i + "";
            }
            else {
                sumLeft=0;
                sumRight=0;
            }
        }
        System.out.println(result);
    }
}
