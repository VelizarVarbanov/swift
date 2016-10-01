import java.util.Scanner;

public class InchesConvertor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int distance = sc.nextInt();
        double result = distance * 2.54;
        System.out.println(result);
    }
}
