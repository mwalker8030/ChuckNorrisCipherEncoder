package chucknorris;

import java.util.Scanner;

public class Decode extends Message{

    StringBuilder decryption;
    boolean flagged;
    String input;
    char prevBit;

    Decode(){
        super();
        flagged = false;
        decryption = new StringBuilder();
        input = "";
        prevBit = '\0';
        System.out.println("Input encoded string:");
        Scanner scan = new Scanner(System.in);
        try{
            this.input = scan.nextLine();
            if(!isValidEncryption()){
                throw new UserInputException("Encoded string is not valid." + "\n");
            }
            super.len = input.length();
            super.code.append(input);
            unChuckIt();
            if(flagged){ throw new UserInputException("Encoded string is not valid.\n");}
            makeChar();
            if(flagged){ throw new UserInputException("Encoded string is not valid.\n");}
            System.out.println("Decoded string:\n" + decryption + "\n");

        }catch (UserInputException ex){
            System.out.println(ex.getMessage());
        }
    }

    private void unChuckIt(){
        //System.out.println("decoding " + obj.enc + " to ");

        super.tempString = "";
        StringBuilder temp = super.code;
        super.tempChar = ' ';
        super.sequence = 0;
        super.len = temp.length();


        for (super.index = 0; super.index < super.len; super.index++)
        {
            //find the value of the character
            super.sequence = findWhitespace();

            //hit a ws and identify symbol as one or zero
            super.tempChar = (super.sequence == 2 ? '0' : '1');

            //check if this is valid bit
            if(checkLastBit()){
                return;
            }

            //update last bit
            storeLastBit();

            //count zeros until another ws
            super.sequence = findWhitespace();

            //append to string the appropriate amount of symbols
            for (;super.sequence > 0; --super.sequence){
                super.tempString += super.tempChar;
            }

            if(flagged){return;}
        }
        //print decrypted value if needed for debug purposes
        //System.out.println("decrypted code is : " + obj.tempString);
            super.bits.append(super.tempString);
    }

    private boolean checkLastBit(){
        //if the last bit is null
        if(prevBit == '\0' ){
            prevBit = super.tempChar;
            return false; //store it
        }

        //get the last bit in the string
        //check if the last bit is the same as the current bit
        if(prevBit == super.tempChar || super.sequence > 2){
            //if the last bit is the same as the current bit
            //throw encoded string is not valid
            flagged = true;
            return true;
        }

        //bit is valid
        return false;
    }

    private void storeLastBit(){
        //store the last bit read in the string.
        prevBit = super.tempChar;
    }

    private int findWhitespace(){
        StringBuilder temp = super.code;
        if(Character.isWhitespace(temp.charAt(super.index))){++super.index;}
        int counter = 0;
        super.len = temp.length();
        while(super.index < super.len && !Character.isWhitespace(temp.charAt(super.index))){
            if(temp.charAt(super.index) != '0'){flagged = true;}
            ++counter;
            ++super.index;
        }
        return counter;
    }

    private void makeChar(){
        //create string variable to hold the converted characters
        super.tempString = "";
        super.index = 0;
        int counter = 0;

        //read a string of bits up until the 7th bit
        while (super.index < super.bits.length()){
            //noinspection StringConcatenationInLoop
            super.tempString += super.bits.charAt(super.index);
            ++counter;
            if(counter >= 7){
                //convert to character symbol
                decryption.append(bitToChar(super.tempString));
                super.tempString = "";
                counter = 0;
            }

            ++super.index;
        }

        if(counter != 0){ flagged = true; }
        //System.out.println(obj.dec);
        //decode it into a character symbol
    }

    private static char bitToChar(String output){
        int sum = 0;
        for (int i = 0; i < output.length() ; ++i){
            sum += (output.charAt(i) == '1' ? Math.pow(2,(output.length() - 1) - i) : 0);
        }
        return (char) sum;
    }

    public boolean isValidEncryption(){
        for(char ch : input.toCharArray())
            if( ch != '0' && ch != ' ')
                return false;
        return true;
    }
}
