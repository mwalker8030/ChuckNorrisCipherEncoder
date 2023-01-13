package chucknorris;

public class Operate{

    public enum Operations {
        ENCODE,
        DECODE,
        EXIT,
        CONTINUE;
    }


    public void Operate(){

    }

    public String pickOperation(String choice) {
        Message msg = new Message();
        if (choice.equals(Operations.ENCODE.name().toLowerCase())) {
            Encode enc = new Encode();
        } else if(choice.equals(Operations.DECODE.name().toLowerCase())) {
            Decode dec = new Decode();
        } else {
            return Operations.EXIT.name().toLowerCase();
        }
        return Operations.CONTINUE.name();
    }
}
