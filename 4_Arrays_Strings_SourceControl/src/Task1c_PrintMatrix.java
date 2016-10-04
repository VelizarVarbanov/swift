import java.util.Scanner;

public class Task1c_PrintMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = 1;
        int row = 0;
        int col = 0;
        int[][] arr = new int[n][n];
        boolean directioUp = true;
        arr[0][0] = 1;
        while (k < n * n) {
            if(directioUp) {
                if (row == 0 && col < arr.length - 1) {
                    col++;
                    k++;
                    directioUp = false;
                    arr[row][col] = k;
                } else if (col == arr.length - 1) {
                    row++;
                    k++;
                    directioUp = false;
                    arr[row][col] = k;
                } else {
                    col++;
                    row--;
                    k++;
                    arr[row][col] = k;
                }
            }
            else if (!directioUp) {
                if (col ==0 && row < n-1 ) {
                    row++;
                    directioUp = true;
                    k++;
                    arr[row][col] = k;
                }
                else if (row == arr.length - 1) {
                    col++;
                    directioUp = true;
                    k++;
                    arr[row][col] = k;
                }
                else {
                    row++;
                    col--;
                    k++;
                    arr[row][col] = k;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + "\t");

            }
            System.out.println();
        }
    }
}
