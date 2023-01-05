import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scan = new Scanner(System.in);
        StringBuilder uinput = new StringBuilder();
        uinput.append(scan.nextLine());
        char c = ' ';
        for(int i=0; i<uinput.length(); i++){
            c = uinput.charAt(i);
            uinput.insert(i++,c);
        }
        System.out.print(uinput);

    }
}