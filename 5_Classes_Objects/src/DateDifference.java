import java.util.Calendar;
import java.util.Scanner;

public class DateDifference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String firstDate = sc.nextLine();
        String secondDate = sc.nextLine();
        int firstYear = Integer.parseInt(firstDate.substring(0, 4));
        int firstMonth = Integer.parseInt(firstDate.substring(5, 7));
        int firstDay = Integer.parseInt(firstDate.substring(8));
        int sectYear = Integer.parseInt(secondDate.substring(0, 4));
        int secMonth = Integer.parseInt(secondDate.substring(5, 7));
        int secDay = Integer.parseInt(secondDate.substring(8));
        SwiftDate tr = new SwiftDate(firstYear, firstMonth, firstDay);
        System.out.println(SwiftDate.getDaysDifference(firstYear, firstMonth, firstDay, sectYear, secMonth, secDay));
        tr.printInfo();
        SwiftDate sd = new SwiftDate(sectYear, secMonth, secDay);
        sd.printInfo();

    }
    public static class SwiftDate {
        int year = 0;
        int month = 0;
        int day = 0;

        public SwiftDate(int newYear, int newMonth, int newDay) {
            this.year = newYear;
            this.month = newMonth;
            this. day = newDay;
        }

        public boolean isLeapYear() {
            if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
                return true;
            }
            else return false;
        }
        public int getCentury() {
            int century = year / 100 + 1;
            return century;
        }
        public static long getDaysDifference (int year, int month, int day, int secYear, int secMonth, int secDay) {
            Calendar calendar1 = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();
            calendar1.set(year, month, day);
            calendar2.set(secYear, secMonth, secDay);
            long milsecs1= calendar1.getTimeInMillis();
            long milsecs2 = calendar2.getTimeInMillis();
            long diff =  Math.abs(milsecs2 - milsecs1);
            long ddays = diff / (24 * 60 * 60 * 1000);
            return ddays;
        }
        public void printInfo () {
            int century = year/ 100 + 1;
            if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0))
                System.out.println(year + " " + month + " " + day + " - " + century + " century. It is LEAP year.");
            else
                System.out.println(year + " " + month + " " + day + " - " + century + " century.");
        }
        public int getYear() {
            return this.year;
        }
        public void setYear(int year) {
            this.year = year;
        }
        public  int getMonth() {
            return this.month;
        }
        public void setMonth(int month) {
            this.month = month;
        }
        public int getDay() {
            return this.getDay();
        }
        public  void setDay(int day) {
            this.day = day;
        }
    }
}
