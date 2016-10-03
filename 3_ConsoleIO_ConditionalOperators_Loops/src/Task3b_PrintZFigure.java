import java.util.Scanner;

public class Task3b_PrintZFigure {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1 ; i <= n; i++) {
            if(i == 1 || i == n) {
                for (int j = 0; j < n; j++) {
                    System.out.print('*');
                    System.out.print(' ');
                }
            } else {
                for (int j = 2 * n - 2 * i; j > 0; j--) {
                        System.out.print(' ');
                    }
                    System.out.print('*');

                }
                System.out.println();


        }
    }
}
