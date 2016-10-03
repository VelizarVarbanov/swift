
public class TimeProgramm {
    public static void main(String[] args) {
        int inputSeconds = 1234567;
        int days;
        int hours;
        int minutes;
        int seconds;
        days = inputSeconds / (3600 * 24);
        inputSeconds -= days * (3600 * 24);
        hours = inputSeconds / 3600;
        inputSeconds -= hours * 3600;
        minutes = inputSeconds / 60;
        seconds = inputSeconds - (minutes * 60);

        System.out.printf("%d дни, %d часа, %d минути, %d секунди", days, hours, minutes, seconds);
    }
}
