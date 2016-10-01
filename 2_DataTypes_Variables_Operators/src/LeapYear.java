import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        if ((year % 4 ==0)||(year % 100==0 && year % 400 ==0)) {
            System.out.println("It is leap year!!! You have birthday on 29 February");

        }
        else {
            System.out.println("It is not leap Year... celebrate on 28");
        }
    }
}
