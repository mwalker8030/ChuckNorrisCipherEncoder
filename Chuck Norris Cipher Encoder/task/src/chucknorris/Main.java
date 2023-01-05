package chucknorris;
import java.util.Scanner;

public class Main {

    public static void encode(char a) {
        String d = Integer.toBinaryString(a);
        String dd = String.format("%07d\n", Integer.parseInt(d));
        int len = dd.length(), s = 1;
        char c = dd.charAt(0);
        for (int i = 1; i < len; i++) {
            if (c == dd.charAt(i)) {
                ++s;
            } else {
                if (c == '1') {
                    System.out.print("0 ");
                } else {
                    System.out.print("00 ");
                }
                while (s > 0) {
                    System.out.print("0");
                    --s;
                }
                if (i + 1 != len)
                    System.out.print(" ");
                c = dd.charAt(i);
                s++;
            }
        }

    }

    static int s = 1;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Input string:");
        String u = scan.nextLine();
        int len = u.length();
        System.out.println("\nThe result:");
        //ArrayList<String> arr = new ArrayList<>();
        StringBuilder con = new StringBuilder();
        for (int i = 0; i < len; i++) {
            String d = Integer.toBinaryString(u.charAt(i));
            System.out.printf("%c = %07d :", u.charAt(i), Integer.parseInt(d));
            encode(u.charAt(i));
            con.append(String.format("%07d", Integer.parseInt(d)));
            System.out.println();
        }

        System.out.println(con);
        s = 1;
        char c = con.charAt(0);
        len = con.length();
        for (int i = 1; i < len; i++) {
            while (c == con.charAt(i)) {
                ++s;
                if (i + 1 < len) {
                    c = con.charAt(i);
                    ++i;
                    continue;
                }
                break;
            }

            if (c == '1') {
                System.out.print("0 ");
            } else {
                System.out.print("00 ");
            }
            while (s > 0) {
                System.out.print("0");
                --s;
            }
            if (i + 1 != len)
                System.out.print(" ");
        }

    }
}
