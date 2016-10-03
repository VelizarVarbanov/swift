import java.util.Scanner;

public class CalculatorClient {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String operation = null;
        do {
            operation = sc.nextLine().toLowerCase();
            String[] split = operation.split(" ");
            Calculator calc = new Calculator();

            if (split[0].equals("sum")){
                System.out.printf("%.3f", calc.sum(Double.parseDouble(split[1]), Double.parseDouble(split[2])));
            }
            if (split[0].equals("sub")){
                System.out.printf("%.3f", calc.subtract(Double.parseDouble(split[1]), Double.parseDouble(split[2])));
            }
            if (split[0].equals("mul")){
                System.out.printf("%.3f", calc.multiply(Double.parseDouble(split[1]), Double.parseDouble(split[2])));
            }
            if (split[0].equals("div")){
                System.out.printf("%.3f", calc.divide(Double.parseDouble(split[1]), Double.parseDouble(split[2])));
            }
            if (split[0].equals("per")){
                System.out.printf("%.3f", calc.percentage(Double.parseDouble(split[1]), Double.parseDouble(split[2])));
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

