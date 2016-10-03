import java.util.Arrays;
import java.util.Scanner;

public class Task2c_PrintClusterCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 1;
        int result = 1;
        int[] digits = new int[n];
        for (int i = 0; i < n; i++) {
            digits[i] = sc.nextInt();
        }
        Arrays.sort(digits);
        for (int i = 0; i < digits.length + 1; i++) {
            if (i == digits.length - 1) break;
            if(digits[i] ==  digits[i+1]) {
                count++;
            }
            else count = 1;
            if(count > result) {
                result = count;
            }
        }
        System.out.println(result);
    }
}
