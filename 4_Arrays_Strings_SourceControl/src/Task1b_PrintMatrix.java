import java.util.Scanner;

/**
 * Created by Paulina on 27.9.2016 г..
 */
public class Task1b_PrintMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 1;
        int reminder = count;
        int[][] arr = new int[n][n];
        for (int col = 0; col < n; col++) {
            reminder = count;
            if(col!= 0 && col % 2==0) {
                count +=n;
            }
            for (int row = 0; row < n; row++) {
                if (col % 2 == 0) {

                    arr[row][col] = count;
                    count++;
                }
                else
                    arr[row][col] = reminder + n -1;
                    reminder--;
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

