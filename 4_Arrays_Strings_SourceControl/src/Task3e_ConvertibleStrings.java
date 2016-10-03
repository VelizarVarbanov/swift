import java.util.Scanner;

public class Task3e_ConvertibleStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String firstString = sc.nextLine();
        String secondString = sc.nextLine();
        int countLetters = 0;
        for (int i = 0; i < secondString.length(); i++) {
            if (firstString.contains(secondString.substring(i, i+1))){
                countLetters++;
            }
        }
        if (countLetters == secondString.length()) {
            System.out.println(true);
        }
        else {
            System.out.println(false);
        }
    }
}
