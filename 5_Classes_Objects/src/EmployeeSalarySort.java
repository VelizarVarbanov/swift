import com.sun.xml.internal.ws.api.model.wsdl.editable.EditableWSDLModel;

import java.util.Arrays;
import java.util.Scanner;

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
            if (Double.parseDouble(EmployerData[i][1]) == salaries[n - 1]) {
                if (EmployerData[i].length > 5) {
                    Employee emp = new Employee();
                    emp.EmployeeSalarySort(EmployerData[i][0], EmployerData[i][3], EmployerData[i][2], EmployerData[i][5]);

                } else if (EmployerData[i].length < 5) {
                    Employee emp = new Employee();
                    emp.EmployeeSalarySort(EmployerData[i][0], EmployerData[i][3], EmployerData[i][2]);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (Double.parseDouble(EmployerData[i][1]) == salaries[n - 2]) {
                if (EmployerData[i].length > 5) {
                    Employee emp = new Employee();
                    emp.EmployeeSalarySort(EmployerData[i][0], EmployerData[i][3], EmployerData[i][2], EmployerData[i][5]);

                } else if (EmployerData[i].length < 5) {
                    Employee emp = new Employee();
                    emp.EmployeeSalarySort(EmployerData[i][0], EmployerData[i][3], EmployerData[i][2]);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (Double.parseDouble(EmployerData[i][1]) == salaries[n-3]) {
                if (EmployerData[i].length > 5) {
                    Employee emp = new Employee();
                    emp.EmployeeSalarySort(EmployerData[i][0], EmployerData[i][3], EmployerData[i][2], EmployerData[i][5]);

                } else if (EmployerData[i].length < 5) {
                    Employee emp = new Employee();
                    emp.EmployeeSalarySort(EmployerData[i][0], EmployerData[i][3], EmployerData[i][2]);
                }
            }
        }



    }
    public static class Employee {

        String name;
        int salary;
        String position;
        String department;
        int age;
        String email;

        public Employee () {


        }
        public static void EmployeeSalarySort(String newName, String newPosition, String newDepartment, String newEmail){
            System.out.println(newName+", "+newDepartment+", "+newPosition+", "+newEmail);
        }
        public static void EmployeeSalarySort(String newName, String newPosition, String newDepartment){
            System.out.println(newName+", "+newDepartment+", "+newPosition);
        }
        public int getSalary() {
            return this.salary;
        }
        public void setSalary(int salary) {
            this.salary = salary;
        }
    }
}
