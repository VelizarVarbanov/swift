import java.util.Scanner;

public class CalculatorClient {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String operation = null;
        do {
            operation = sc.nextLine().toLowerCase();
            String[] split = operation.split(" ");

            if (split[0].equals("sum")){
                System.out.printf("%.3f", Calculator.sum(Double.parseDouble(split[1]), Double.parseDouble(split[2])));
            }
            if (split[0].equals("sub")){
                System.out.printf("%.3f", Calculator.subtract(Double.parseDouble(split[1]), Double.parseDouble(split[2])));
            }
            if (split[0].equals("mul")){
                System.out.printf("%.3f", Calculator.multiply(Double.parseDouble(split[1]), Double.parseDouble(split[2])));
            }
            if (split[0].equals("div")){
                System.out.printf("%.3f", Calculator.divide(Double.parseDouble(split[1]), Double.parseDouble(split[2])));
            }
            if (split[0].equals("per")){
                System.out.printf("%.3f", Calculator.percentage(Double.parseDouble(split[1]), Double.parseDouble(split[2])));
            }
        }
        while  (!operation.contains("end"));


    }
    public static class Calculator {
        public static double sum(double a, double b) {
            double result = a + b;
            return  result;
        }
        public static double subtract(double a, double b) {
            double result = a - b;
            return  result;
        }
        public static double multiply(double a, double b) {
            double result = a * b;
            return  result;
        }
        public static double divide(double a, double b) {
            double result = a / b;
            return  result;
        }
        public static double percentage(double a, double b) {
            double result = b % a;
            return  result;
        }
    }
}

