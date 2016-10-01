import java.util.Scanner;

public class Task1f_ToBinaryAndHexa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer num = sc.nextInt();
//        String resB = Integer.toBinaryString(num);
//        String resH = Integer.toHexString(num);
        String hex = "";
        int newNum = num;
        String result = "";
        char[] hexDec = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F'};
        while (newNum > 0) {
            int i = newNum % 2;
            result = i + result;
            newNum = newNum / 2;
        }
        System.out.println(result);
        while (num != 0) {
            int i = num % 16;
            hex = hexDec[i] + hex;
            num = num / 16;
        }
        System.out.println(hex);

    }
}
