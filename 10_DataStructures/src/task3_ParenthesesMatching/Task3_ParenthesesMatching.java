package task3_ParenthesesMatching;


import java.util.Scanner;
import java.util.Stack;

public class Task3_ParenthesesMatching {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sentence = sc.nextLine();
        System.out.println(balancedParenthensies(sentence));

    }

    private static boolean balancedParenthensies(String s) {
        Stack<Character> input = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                input.push(c);
            }
            else if (c == ')') {
                if(input.isEmpty()) return false;
                if (input.pop()!= '(')  return false;
            }
            else if (c == '}') {
                if(input.isEmpty()) return false;
                if (input.pop()!= '{')  return false;

            }
            else if (c == ']') {
                if(input.isEmpty()) return false;
                if (input.pop()!= '[')  return false;

            }
        }
        return input.isEmpty();
    }
}
