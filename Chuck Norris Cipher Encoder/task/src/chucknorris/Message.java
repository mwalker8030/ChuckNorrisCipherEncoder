package chucknorris;

public class Message {
    protected StringBuilder code;
    protected StringBuilder bits;
    protected char tempChar;
    protected String tempString;
    protected int index;
    protected int len;
    protected int sequence;
    protected Message(){
        code = new StringBuilder();
        bits = new StringBuilder();
        tempChar = ' ';
        tempString = "";
        index = 0;
        len = 0;
        sequence = 0;
    }
}
