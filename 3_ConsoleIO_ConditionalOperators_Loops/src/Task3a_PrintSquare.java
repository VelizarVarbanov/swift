
import java.util.Arrays;
import java.util.Scanner;


public class Task3a_PrintSquare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            if (i == 1 || i == n) {
                for (int j = 1; j <= n; j++) {
                    System.out.print("* ");
                }
            } else {
                for (int j = 1; j <= 2 * n; j++) {
                    if (j == 1 || j == 2 * n)
                        System.out.print('*');
                    else if(j > 1 && j < 2 *n - 1)
                        System.out.print(' ');

                }

            }
            System.out.println();
        }
    }
}
