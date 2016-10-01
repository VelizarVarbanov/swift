
import java.util.Scanner;

public class Task4a_StringWoVowels {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
//        Solution with Regular Expretions;
//        String result = str.replaceAll("[aeyuio]", "");
//        System.out.println(result);
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]!= 'a' && arr[i]!= 'e' && arr[i]!= 'y' && arr[i]!= 'u' && arr[i]!= 'i' && arr[i]!= 'o' && arr[i]!= 'A' && arr[i]!= 'E'
                    && arr[i]!= 'Y' && arr[i]!= 'U' && arr[i]!= 'I' && arr[i]!= 'O') {
                System.out.print(arr[i]);
            }

        }
    }
}
