import java.util.Scanner;

public class Task4d_SumOfNumbersInString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] result = str.split("\\D+");
        long sum = 0;
        for (int i = 1; i < result.length; i++) {
                sum = sum + Integer.parseInt(result[i]);
        }
        System.out.println(sum);
    }
}
