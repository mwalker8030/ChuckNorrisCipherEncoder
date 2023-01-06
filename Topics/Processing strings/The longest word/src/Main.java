import java.util.Scanner;
import java.lang.Character;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scan = new Scanner(System.in);
        StringBuilder userInput = new StringBuilder(scan.nextLine());
        StringBuilder word = new StringBuilder();
        StringBuilder longest = new StringBuilder();
        int i = 0;
        while (i < userInput.length()) {
            if(!Character.isWhitespace(userInput.charAt(i))) {
                word.append(userInput.charAt(i));
            }

            if (word.length() > longest.length()) {
                longest.setLength(0);
                longest.append(word);
            }

            if (Character.isWhitespace(userInput.charAt(i))) {
                word.setLength(0);
            }

            i++;
        }
        System.out.print(longest);
    }
}
