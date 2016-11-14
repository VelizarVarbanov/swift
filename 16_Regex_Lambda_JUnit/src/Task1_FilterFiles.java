import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1_FilterFiles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();


        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            if(matching(input)){
                System.out.println(input);
            }
        }
    }
    public static boolean matching(String input) {
        Pattern pattern = Pattern.compile("([^\\s]+(\\.(?i)(jpg|png|gif|bmp))$)");
        Matcher matcher = pattern.matcher(input);
        boolean result = false;
        if(matcher.matches()){
            result = true;
        }
        return result;
    }
}
