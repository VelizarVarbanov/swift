package credentialsManager;
import java.util.Scanner;

public class CredentialsManager {
    public static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = "";
        Credentials cr = new Credentials();
        do {
            input = sc.nextLine();
            count++;
            cr.CredentialsManager(input);
        } while (!input.equals("END"));
    }
    static class Credentials {
        public String[][] oldPasses = new String[100][100];
        private static String[] _username = new String[100];
        private static String[] _password = new String[100];

        public  Credentials(String[] newUsername, String[] newPassword) {
            this._password = newPassword;
            this._username = newUsername;
        }
        public static int i = 0;
        public static int k = 0;
        public Credentials() {

        }
        public  void CredentialsManager(String input) {
            boolean contains = false;// for old password
            String[] split = input.split(" ");
            if (split[0].equals("ENROLL")) {
                _username[i] = split[1];
                _password[i] = split[2];
                oldPasses[i][k] = split[2];
                System.out.println(oldPasses[i][k]);
                i++;
                System.out.println("ENROLL success");
            }
            System.out.println(oldPasses[i-1][k]);

            if (split[0].equals("CHPASS")) {
                int index = -1;
                for (int j=0; j <_username.length; j++) {
                    if (_username[j].equals(split[1])) {
                        index = j;
                        break;
                    }
                }
                int countSec = 0;
                for (int j = 0; j < oldPasses[index].length; j++) {
                    if(oldPasses[index][j] != null){
                        countSec++;
                    }

                }
                for (int j = 0; j < countSec; j++) {

                    if (oldPasses[index][j].equals(split[3])) {
                        contains = true;
                    }

                }
                if (_password[index].equals(split[2]) && !split[2].equals(split[3]) && contains == false)  {
                    _password[index] = split[3];
                    k++;
                    oldPasses[i][k] = split[2];
                    System.out.println("CHPASS success");
                }
                else System.out.println("CHPASS failed");
            }
            if (split[0].equals("AUTH")) {
                int index = -1;
                for (int j=0; j <_username.length; j++) {
                    if (_username[j].equals(split[1])) {
                        index = j;
                        break;
                    }
                }
                if (_password[index].equals(split[2])) {
                    System.out.println("AUTH success");
                }
                else System.out.println("AUTH failed");
            }
        }

        public static String[] get_username() {
            return _username;
        }
        public static String[] get_password() {
            return _password;
        }
        private void set_username(String[] new_username) {
            _username = new_username;
        }
        public  static  void set_password (String[] new_password) {
            _password = new_password;
        }
    }
}
