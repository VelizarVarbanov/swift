package task1_PeoplePresentation;
public class Worker extends Person {
    public Worker (String firstName, String lastName, double valueSalary, double workHoursPerDay) {
        super(firstName, lastName);
        this.setWeekSalary(valueSalary);
        this.setWorkHoursPerDay(workHoursPerDay);
    }

    double weekSalary;
    double workHoursPerDay;

    public double getWeekSalary() {
        return weekSalary;
    }

    public void setWeekSalary(double weekSalary) {
        if (weekSalary < 0) {
            throw  new IllegalArgumentException("Expected positive number for week salary.");
        }
        else this.weekSalary = weekSalary;
    }

    public double getWorkHoursPerDay() {
        return workHoursPerDay;
    }

    public void setWorkHoursPerDay(double workHoursPerDay) {
        if (workHoursPerDay < 0) {
            throw  new IllegalArgumentException("Expected positive number for workHoursPerDay.");
        }
        this.workHoursPerDay = workHoursPerDay;
    }
     public void printInfo() {
        System.out.printf("First name: %s \n", this.firstName);
        System.out.printf("Last name: %s \n", this.lastName);
        System.out.println("Occupation: Worker");
        System.out.printf("Week salary: %.2f \n", this.weekSalary);
        System.out.printf("Hours per day: %f \n", this.workHoursPerDay);
        System.out.printf("Salary per hour: %.2f \n", this.weekSalary / (this.workHoursPerDay * 5.0));
    }
}
