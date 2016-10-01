
public class SwitchPlaces {
    public static void main(String[] args) {
        int num = 1;
        int num2 = 999;
        int change = 0;
        System.out.println("Before: " + num + " " + num2);
        change = num;
        num = num2;
        num2 = change;
        System.out.println("After: " + num + " " + num2);
        System.out.println(" And another way to change");
        int x = 1;
        int y = 999;
        System.out.println("Before: "+x + " " + y);
        x = x + y;
        y = x - y;
        x = x - y;
        System.out.println("After: " + x + " " + y);
    }
}
