import java.util.Scanner;
public class Task3c_CaesarCipher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sentence = sc.nextLine();
        String mode = sc.nextLine();
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        if (mode.equals("encode")) {
            for (int i = 0; i < sentence.length(); i++) {
                if (sentence.charAt(i) == 'z') {
                    System.out.print(sentence.replace(sentence.charAt(i), 'a').substring(i, i + 1));
                } else if (sentence.charAt(i) == 'Z') {
                    System.out.print(sentence.replace(sentence.charAt(i), 'A').substring(i, i + 1));
                } else if (sentence.charAt(i) == ' ' || sentence.charAt(i) == '\n') {
                    System.out.print(sentence.replace(sentence.charAt(i), ' ').substring(i, i + 1));
                } else {
                    System.out.print(sentence.replace(sentence.charAt(i), alphabet.charAt(alphabet.indexOf(sentence.charAt(i) + 1))).substring(i, i + 1));
                }
            }
        }
        if (mode.equals("decode")) {
            for (int i = 0; i < sentence.length(); i++) {
                if (sentence.charAt(i) == 'a') {
                    System.out.print(sentence.replace(sentence.charAt(i), 'z').substring(i, i + 1));
                } else if (sentence.charAt(i) == 'A') {
                    System.out.print(sentence.replace(sentence.charAt(i), 'Z').substring(i, i + 1));
                } else if (sentence.charAt(i) == ' ' || sentence.charAt(i) == '\n') {
                    System.out.print(sentence.replace(sentence.charAt(i), ' ').substring(i, i + 1));
                } else {
                    System.out.print(sentence.replace(sentence.charAt(i), alphabet.charAt(alphabet.indexOf(sentence.charAt(i) - 1))).substring(i, i + 1));
                }
            }
        }
    }
}
