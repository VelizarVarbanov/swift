import java.util.Scanner;

public class Task2f_LargestSumOfKSubSeq {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        int maxSum = 0;
        int start = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        for(int i = 0; i < arr.length; i++){
            if (i <= arr.length - k) {
                for (int j = i; j < i + k; j++) {
                    sum += arr[j];
                }
                if (sum > maxSum) {
                    maxSum = sum;
                    start = i;
                    sum = 0;
                }
                else if (sum < maxSum) {
                    sum = 0;
                }
            }
            else break;
        }
        for(int j = start; j < k + start; j++) {
            System.out.println(arr[j]);
        }
    }
}
