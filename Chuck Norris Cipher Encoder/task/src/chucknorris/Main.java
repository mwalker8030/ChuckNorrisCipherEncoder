package chucknorris;
import java.util.Scanner;

public class Main {
    public static class Chuck{
        StringBuilder code, enc;
        char c;
        int i;
        public Chuck(){
            code = new StringBuilder();
            enc = new StringBuilder();
            System.out.println("Input string:\n\n\"The result:");
            c = ' ';
            i = 0;
        }

    }

    static int s = 1;
    public static void main(String[] args) {

        Chuck obj = new Chuck();
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int len = input.length();

        for (int i = 0; i < len; i++) {
            String d = Integer.toBinaryString(input.charAt(i));
            obj.code.append(String.format("%07d", Integer.parseInt(d)));

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

        System.out.println(obj.enc);
        System.out.print(unChuckIt(obj));
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

    private static int findWhitespace(Chuck obj){
        if(Character.isWhitespace(obj.enc.charAt(obj.i))){++obj.i;}
        int counter = 0;
        while(obj.i < obj.enc.length() && !Character.isWhitespace(obj.enc.charAt(obj.i))){
            ++counter;
            ++obj.i;
        }
        return counter;
    }
    private static String unChuckIt(Chuck obj){
        System.out.println("decoding " + obj.enc + " to ");
        String dec = "";
        char c = ' ';
        int counter = 0, len = obj.enc.length();
        for (obj.i = 0; obj.i < len; obj.i++)
        {
            //find the value of the character
            counter = findWhitespace(obj);

            //hit a ws and identify symbol as one or zero
            c = (counter == 2 ? '0' : '1');

            //count zeros until another ws
            counter = findWhitespace(obj);

            //append to string the appropriate amount of symbols
            for (;counter > 0; --counter){
                dec += c;
            }
        }
        //print decrypted value
        System.out.println("decrypted code is : " + dec);
        return dec;

    }
}
