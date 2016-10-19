package Task1_NumberNotANumber;

import java.util.Scanner;

public class Task1_NumberNotANumber {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = "";
        do {
            input = sc.nextLine();
            if (input.equalsIgnoreCase("END")) break;
            try {
                Integer.parseInt(input);
                System.out.println("Number");

            }catch (Exception ex) {
                System.out.println("Not a number");
            }

        } while (!input.equalsIgnoreCase("END"));
    }
}
