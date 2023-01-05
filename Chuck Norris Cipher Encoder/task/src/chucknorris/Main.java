package chucknorris;
import java.util.Scanner;

public class Main {
    public static class Chuck{
        StringBuilder code, enc;
        char c;
        public Chuck(){
            code = new StringBuilder();
            enc = new StringBuilder("The result:\n");
            System.out.println("Input string:");
            c = ' ';
        }

    }

    static int s = 1;
    static boolean DEBUG = false;
    public static void main(String[] args) {

        /*
        StringBuilder enc = new StringBuilder();
        enc.append("Input string:\n\nThe result:\n");


         */
        Chuck obj = new Chuck();
        Scanner scan = new Scanner(System.in);
        //StringBuilder code = new StringBuilder();
        String input = scan.nextLine();
        int len = input.length();

        for (int i = 0; i < len; i++) {
            String d = Integer.toBinaryString(input.charAt(i));
            obj.code.append(String.format("%07d", Integer.parseInt(d)));
            if(DEBUG){
                //deprecated
            }
        }

        s = 0;
        obj.c = obj.code.charAt(0);
        len = obj.code.length();
        for (int i = 0; i <= len; i++) {
            while (i<len && obj.c == obj.code.charAt(i)) {
                ++s;
                ++i;
            }

            chuckIt(obj, i);
        }

        System.out.print(obj.enc);
    }

    private static void chuckIt(Chuck obj, int i) {
        obj.enc.append(obj.c == '1' ? "0 " : "00 ");

        if(i < obj.code.length()) obj.c = obj.code.charAt(i);

        while (s > 0) {
            obj.enc.append("0");
            --s;
        }
        s=1;
        if (i < obj.code.length())
            obj.enc.append(" ");
    }
}
