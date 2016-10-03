import java.util.Scanner;

public class Task4b_PrintCountOfWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int count = 0;
        String[] result = str.split("\\s");
        for (String word : result) {
            if (word.matches("[a-zA-z]+")) {
                count++;
            }
        }
        System.out.println(count);
    }

}
