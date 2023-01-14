package chucknorris;
import java.util.Scanner;
public class User {
    private Scanner userIn;
    private String input;

    User(){
        this.userIn = new Scanner(System.in);
        input = "";
    }

    public void getUserInput(){
        System.out.println("Please input operation (encode/decode/exit):");
        input = userIn.nextLine();
    }

    public String getStoredResponse(){
        return this.input;
    }

    public boolean isValidResponse(){
        return input.equals("encode") || input.equals("decode") || input.equals("exit");
    }
}
