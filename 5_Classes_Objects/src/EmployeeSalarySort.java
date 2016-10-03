import java.util.Scanner;

public class EmployeeSalarySort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

//TODO



    }
    public static class Employee {
        public String name;
        public double salary;
        public String position;
        public int age;
        public String email;

        public Employee (String newName, double newSalary, String newPosition, int newAge, String newMail){
            this.name = newName;
            this.salary = newSalary;
            this.position = newPosition;
            this.age = newAge;
            this.email = newMail;
        }

        public static void EmployeeSalarySort(String name, double salary, String position, int age, String email) {

        }

    }
}
