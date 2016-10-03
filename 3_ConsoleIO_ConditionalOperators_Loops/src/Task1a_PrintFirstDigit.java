import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task1a_PrintFirstDigit {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        long num = Integer.parseInt(bf.readLine());
        while (num > 10) {
            num = num / 10;
        }

        System.out.print(num);
    }
}
