package chucknorris;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Init fields needed for program
        User user = new User();
        String choice = "", result = "";
        Operate ops = new Operate();
        //Loop until user wishes to exit
        do{
            try{
            //Ask user what they want to do (encode/decode/exit)
                user.getUserInput();
                if(!user.isValidResponse()){
                    throw new UserInputException("There is no '" + user.getStoredResponse() + "' operation");
                }
                result = ops.pickOperation(user.getStoredResponse());
            } catch(UserInputException ex){
                System.out.println(ex.getMessage());
            }
        }while(!result.equals(Operate.Operations.EXIT.name().toLowerCase()));
        System.out.print("Bye!");
    }
}
