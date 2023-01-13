package chucknorris;

import java.util.Scanner;

public class Encode extends Message {
    StringBuilder encryption;
    String input;
    public Encode(){
        super();
        encryption = new StringBuilder();
            System.out.println("Input string:");
        Scanner scan = new Scanner(System.in);
        this.input = scan.nextLine();
        super.len = input.length();
        generateDataToEncrypt();
        chuckIt();
        System.out.println("\nEncoded string:\n" + encryption + "\n");
    }

    private void generateDataToEncrypt(){
        for(super.index = 0; super.index < super.len; super.index++){
            super.tempString = Integer.toBinaryString(this.input.charAt(super.index));
            super.code.append(String.format("%07d", Integer.parseInt(super.tempString)));
        }
    }

    private void chuckIt(){
        super.sequence = 0;
        super.tempChar = super.code.charAt(0);
        super.len = super.code.length();
        for (super.index = 0; super.index <= super.len; super.index++) {
            while (super.index < super.len && super.tempChar == super.code.charAt(super.index)) {
                ++super.sequence;
                ++super.index;
            }
            encode();
        }
    }

    private void encode() {
        encryption.append(super.tempChar == '1' ? "0 " : "00 ");

        if(super.index < super.code.length()) super.tempChar = super.code.charAt(super.index);

        while (super.sequence > 0) {
            encryption.append("0");
            --super.sequence;
        }
        super.sequence =1;
        if (super.index < super.code.length())
            encryption.append(" ");
    }
}
