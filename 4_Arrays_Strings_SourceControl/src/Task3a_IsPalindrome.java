import java.util.Scanner;

public class Task3a_IsPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String isPalindorme = sc.nextLine();
        StringBuilder leftHalf = new StringBuilder();
        StringBuilder rightHalf = new StringBuilder();
        for (int i = 0; i < isPalindorme.length()/2; i++) {
            leftHalf.append(isPalindorme.charAt(i));
        }
        if(isPalindorme.length() % 2 != 0) {
            for (int i = isPalindorme.length() / 2 + 1; i < isPalindorme.length(); i++) {
                rightHalf.append(isPalindorme.charAt(i));
            }
        }
        else {
            for (int i = isPalindorme.length() / 2; i < isPalindorme.length(); i++) {
                rightHalf.append(isPalindorme.charAt(i));
            }
        }
        if (leftHalf.toString().equals(rightHalf.toString())) {
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }
    }
}
