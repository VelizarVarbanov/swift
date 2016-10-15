package task1_PeoplePresentation;

public class Student extends Person {
    public Student(String firstName, String lastName, String fac, int lectureCount, int exerciseCount) {
        super(firstName, lastName);
        this.setFacultyNumber(fac);
        this.setLectureCount(lectureCount);
        this.setExerciseCount(exerciseCount);
    }

    String facultyNumber;
    int lectureCount;
    int exerciseCount;

    public int getLectureCount() {
        return this.lectureCount;
    }

    public void setLectureCount(int lectureCount) {
        if (lectureCount < 0) {
            throw  new IllegalArgumentException("Expected positive number for lectureCount. ");
        }
        if (lectureCount % 1 != 0) {
            throw  new IllegalArgumentException("Expected integer for lectureCount. ");
        }
        else this.lectureCount = lectureCount;
    }

    public int getExerciseCount() {
        return this.exerciseCount;
    }

    public void setExerciseCount(int exerciseCount) {
        if (exerciseCount < 0) {
            throw  new IllegalArgumentException("Expected positive number for exerciseCount.");
        }
        if (exerciseCount % 1 != 0) {
            throw  new IllegalArgumentException("Expected integer for exerciseCount. ");
        }
        else this.exerciseCount = exerciseCount;
    }

    public String getFacultyNumber() {
       return this.facultyNumber;
   }
    public void setFacultyNumber(String facultyNumber) {
       if (facultyNumber.length() < 5 || facultyNumber.length() > 10) {
           throw new IllegalArgumentException("Expected length for faculty number is between 5 and 10 symbols.");
       }
       else this.facultyNumber = facultyNumber;
   }
   public void printInfo() {
       System.out.printf("First name: %s \n", this.firstName);
       System.out.printf("Last name: %s \n", this.lastName);
       System.out.println("Occupation: Student");
       System.out.printf("Faculty number: %s \n", this.facultyNumber);
       System.out.printf("Hours per day: %.2f \n", (this.lectureCount * 2 + this.exerciseCount * 1.5 )/ 5.0);
   }
}
