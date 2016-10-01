import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task1b_PrintMirrorNumber {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        long num = Integer.parseInt(bf.readLine());
        long result = 0;
        while (num > 0) {
            result = num % 10;
            System.out.print(result);
            num = num / 10;
        }
    }
}
