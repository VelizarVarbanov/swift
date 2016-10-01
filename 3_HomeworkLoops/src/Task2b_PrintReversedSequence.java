import java.util.Arrays;
import java.util.Scanner;

public class Task2b_PrintReversedSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] result = new int[n];
        for (int i = result.length - 1; i >= 0; i--) {
            int num = sc.nextInt();
            result[i] = num;
        }
        System.out.print(Arrays.toString(result));
    }
}
