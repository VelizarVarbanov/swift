import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task1d_PrintAllDivisor {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long num = Integer.parseInt(br.readLine());
        for (long i = 1; i <= num; i++) {
            if (num % i == 0) {
                System.out.print(i + " ");
            }

        }
    }
}
