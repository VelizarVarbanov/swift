import java.util.Scanner;

public class Task4c_PrintEverySentence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
//        Using Regex;
//        String separator = "\\.|\\?|\\!";
//        String[] result = str.split(separator);
//        for (int i = 0; i < result.length; i++) {
//            System.out.println(result[i]);
//
//        }
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (arr[i] == '.' || arr[i] == '?' || arr[i] == '!') {
                System.out.println();
            }

        }
    }
}
