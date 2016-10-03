import java.util.Scanner;
public class Task1c_PrintSumOfDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();
        long changed = 0l;
        long sum = 0l;
        for (int i = 0; i < num.length(); i++) {
            changed = Character.getNumericValue(num.charAt(i));
            sum = sum + changed;
        }
        System.out.print(sum);
    }
}
