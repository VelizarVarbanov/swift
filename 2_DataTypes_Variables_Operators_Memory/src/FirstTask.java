
public class FirstTask {
    public static void main(String[] args) {
        int x = 5;
        int y = 10;
        int z = ++x * y--;
        System.out.println(z);
        // B)
        System.out.println("1 + 2 = " + 1 + 2);
        System.out.println("1 + 2 = " + (1 + 2));
        // C)
        System.out.println(1 + 2 + "abc");
        System.out.println("abc" + 1 + 2);
        //D)
        int a = 7;
        float b = 5.6f;
        float c = a * b;
        System.out.println(c + " " + (a * b));
    }
}
