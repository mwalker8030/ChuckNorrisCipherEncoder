package chucknorris;
import java.util.Scanner;

public class Main {
    public enum Process{
        ENCODE, DECODE
    }
    public static class Chuck{
        StringBuilder code, encryption, bits, decryption;
        Process process;
        char tempChar;

        String tempString;
        int index, len, sequence;
        public Chuck(){
            process = Process.DECODE;
            code = new StringBuilder();
            encryption = new StringBuilder();
            bits = new StringBuilder();
            decryption = new StringBuilder();
            if (process == Process.ENCODE)
                System.out.println("Input string:");
            else
                System.out.println("Input encoded string:");
            tempChar = ' ';
            tempString = "";
            index = 0;
            sequence = 0;
        }

    }

    public static void main(String[] args) {

        Chuck obj = new Chuck();
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        obj.len = input.length();
        if(obj.process == Process.ENCODE) {
            for (obj.index = 0; obj.index < obj.len; obj.index++) {
                obj.tempString = Integer.toBinaryString(input.charAt(obj.index));
                obj.code.append(String.format("%07d", Integer.parseInt(obj.tempString)));
            }
            chuckIt(obj);
            System.out.print("\nThe result:\n" + obj.encryption);
        }
        else {
            obj.code.append(input);
            unChuckIt(obj);
            makeChar(obj);
            System.out.print("\nThe result:\n" + obj.decryption);
        }
    }

    private static void chuckIt(Chuck obj){
        obj.sequence = 0;
        obj.tempChar = obj.code.charAt(0);
        obj.len = obj.code.length();
        for (obj.index = 0; obj.index <= obj.len; obj.index++) {
            while (obj.index < obj.len && obj.tempChar == obj.code.charAt(obj.index)) {
                ++obj.sequence;
                ++obj.index;
            }
            encode(obj);
        }
    }
    private static void encode (Chuck obj) {
        obj.encryption.append(obj.tempChar == '1' ? "0 " : "00 ");

        if(obj.index < obj.code.length()) obj.tempChar = obj.code.charAt(obj.index);

        while (obj.sequence > 0) {
            obj.encryption.append("0");
            --obj.sequence;
        }
        obj.sequence =1;
        if (obj.index < obj.code.length())
            obj.encryption.append(" ");
    }

    private static int findWhitespace(Chuck obj){
        StringBuilder temp = (obj.process == Process.ENCODE ? obj.encryption : obj.code);
        if(Character.isWhitespace(temp.charAt(obj.index))){++obj.index;}
        int counter = 0;
        obj.len = temp.length();
        while(obj.index < obj.len && !Character.isWhitespace(temp.charAt(obj.index))){
            ++counter;
            ++obj.index;
        }
        return counter;
    }
    @SuppressWarnings("StringConcatenationInLoop")
    private static void unChuckIt(Chuck obj){
        //debug information
            //System.out.println("decoding " + obj.enc + " to ");

        obj.tempString = "";
        StringBuilder temp = (obj.process == Process.ENCODE ? obj.encryption : obj.code);
        obj.tempChar = ' ';
        obj.sequence = 0;
        obj.len = temp.length();
        for (obj.index = 0; obj.index < obj.len; obj.index++)
        {
            //find the value of the character
            obj.sequence = findWhitespace(obj);

            //hit a ws and identify symbol as one or zero
            obj.tempChar = (obj.sequence == 2 ? '0' : '1');

            //count zeros until another ws
            obj.sequence = findWhitespace(obj);

            //append to string the appropriate amount of symbols
            for (;obj.sequence > 0; --obj.sequence){
                obj.tempString += obj.tempChar;
            }
        }
        //print decrypted value if needed for debug purposes
            //System.out.println("decrypted code is : " + obj.tempString);
        obj.bits.append(obj.tempString);
    }

    private static void makeChar(Chuck obj){
        //create string variable to hold the converted characters
        obj.tempString = "";
        obj.index = 0;
        int counter = 0;

        //read a string of bits up until the 7th bit
        while (obj.index < obj.bits.length()){
            //noinspection StringConcatenationInLoop
            obj.tempString += obj.bits.charAt(obj.index);
            ++counter;
            if(counter >= 7){
                //convert to character symbol
                obj.decryption.append(bitToChar(obj.tempString));
                obj.tempString = "";
                counter = 0;
            }

            ++obj.index;
        }
        //debug information
            //System.out.println(obj.dec);
    }

    private static char bitToChar(String output){
        int sum =0;
        for (int i = 0; i < output.length() ; ++i){
            sum += (output.charAt(i) == '1' ? Math.pow(2,(output.length() - 1) - i) : 0);
        }
        return (char) sum;
    }
}
