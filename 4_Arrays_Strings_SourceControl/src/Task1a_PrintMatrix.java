import java.util.Scanner;

public class Task1a_PrintMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 1;
        int[][] arr = new int[n][n];
        for (int col = 0; col < n; col++) {
            for (int row = 0; row < n; row++) {
                arr[row][col] = count;
                count++;
            }
        }
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print(arr[row][col]);
                System.out.print("\t");
            }
            System.out.println();
        }

    }
}
