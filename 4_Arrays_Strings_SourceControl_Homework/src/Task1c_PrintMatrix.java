import java.util.Scanner;

public class Task1c_PrintMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = 1;
        int row = 0;
        int col = 0;
        int[][] arr = new int[n][n];
//        while (k < n * n) {
//            arr[row][col] = k;
//            k++;
//            col++;
//            arr[row][col] = k;
//            if (row == 0 && col != 0) {
//                while (col != 0) {
//                    col--;
//                    row++;
//                    arr[row][col] = k;
//                    k++;
//                }
//            }
//            if (col == 0 && row != 0) {
//                row++;
//                arr[row][col] = k;
//                while (row != 0) {
//                    col++;
//                    row--;
//                    arr[row][col] = k;
//                    k++;
//                }
//            }
//        }
//        for ( row = 0; row < arr.length; row++) {
//            for ( col = 0; col < arr.length; col++) {
//                System.out.print(arr[row][col]);
//
//            }
//            System.out.println();
//
//        }
// TODO
    }
}
