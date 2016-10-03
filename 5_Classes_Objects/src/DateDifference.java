import java.util.Calendar;
import java.util.Scanner;

public class DateDifference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String firstDate = sc.nextLine();
        String secondDate = sc.nextLine();
        int firstYear = Integer.parseInt(firstDate.substring(0, 4));
        int firstMonth = Integer.parseInt(firstDate.substring(5, 7));
        int firstDay = Integer.parseInt(firstDate.substring(8, 9));
        int sectYear = Integer.parseInt(secondDate.substring(0, 4));
        int secMonth = Integer.parseInt(secondDate.substring(5, 7));
        int secDay = Integer.parseInt(secondDate.substring(8, 9));
        SwiftDate tr = new SwiftDate(firstYear, firstMonth, firstDay);
        System.out.println(tr.getDaysDifference(firstYear, firstMonth, firstDay, sectYear, secMonth, secDay));
        tr.printInfo(firstYear, firstMonth, firstDay);
        tr.printInfo(sectYear,secMonth, secDay);

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

        public static boolean isLeapYear(int year) {
            if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
                return true;
            }
            else return false;
        }
        public static int getCentury(int year) {
            int century = year / 100 + 1;
            return century;
        }
        public  static long getDaysDifference (int year, int month, int day, int secYear, int secMonth, int secDay) {
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
        public static void printInfo (int year, int month, int day) {
            int century = year/ 100 + 1;
            if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0))
                System.out.println(year + " " + month + " " + day + " - " + century + " century. It is LEAP year.");
            else
                System.out.println(year + " " + month + " " + day + " - " + century + " century.");
        }
    }
}
