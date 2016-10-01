import java.util.Scanner;

public class Task1e_IsPrim {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long num = sc.nextInt();
        int count = 0;
        for (int i = 1; i < num / 2; i++) {
            if (num % i == 0) {
                count++;
            }
        }
        if (count <= 1)
            System.out.print("true");
        else
            System.out.print("false");
    }
}
