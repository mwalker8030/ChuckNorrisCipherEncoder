import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scan = new Scanner(System.in);
        StringBuilder uinput = new StringBuilder(scan.nextLine());
        StringBuilder word = new StringBuilder();
        StringBuilder longest = new StringBuilder();
        int i = 0;
        while(i < uinput.length()){
            if(uinput.charAt(i) != ' '){
                word.append(uinput.charAt(i));
            }

            if(word.length() > longest.length()){
                longest.setLength(0);
                longest.append(word);
            }

            if(uinput.charAt(i) == ' '){word.setLength(0);}

            i++;
        }
        System.out.print(longest);
    }
}