import java.util.Arrays;
import java.util.Scanner;
// Have no idea how to put this thing in a class...

public class EmployeeSalarySort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[][] EmployerData = new String[n][];
        String sentence = "";
        String[] split = null;
        double[] salaries = new double[n];
        for (int i = 0; i < n; i++) {
            sentence = sc.next();
            split = sentence.split(",");
            EmployerData[i] = new String[split.length];
            for (int j = 0; j < split.length; j++) {
                EmployerData[i][j] = split[j];
            }

            salaries[i] = Double.parseDouble(EmployerData[i][1]);

        }
        Arrays.sort(salaries);
        for (int i = 0; i < n; i++) {
            if (Double.parseDouble(EmployerData[i][1]) == salaries[n-1]) {
                for (int j = 0; j < EmployerData[i].length; j++) {
                    if (j==0) System.out.print( EmployerData[i][j]);
                    if(EmployerData[i][j]!= null && EmployerData[i][j] != "" &&j!=0)System.out.print(", " + EmployerData[i][j]);
                }

            }
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            if (Double.parseDouble(EmployerData[i][1]) == salaries[n-2]) {
                for (int j = 0; j < EmployerData[i].length; j++) {
                    if (j==0) System.out.print( EmployerData[i][j]);
                    if(EmployerData[i][j]!= null && EmployerData[i][j] != ""&& j!=0)System.out.print(", " + EmployerData[i][j]);
                }

            }
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            if (Double.parseDouble(EmployerData[i][1]) == salaries[n-3]) {
                for (int j = 0; j < EmployerData[i].length; j++) {
                    if (j==0) System.out.print( EmployerData[i][j]);
                    if(EmployerData[i][j]!= null && EmployerData[i][j] != ""&& j!=0)System.out.print(", " + EmployerData[i][j]);
                }

            }
        }
        System.out.println();
    }
}