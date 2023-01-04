package chucknorris;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;

public class Main {

    public static void encode(char a){
        String d = Integer.toBinaryString(a);
        String dd = String.format("%07d\n", Integer.parseInt(d));
        int len = dd.length(), s = 1;
        char c = dd.charAt(0);
        for(int i = 1; i<len;i++){
            if(c == dd.charAt(i)){
                ++s;
                continue;
            }else{
                if(c == '1'){
                    System.out.print("0 ");
                }else{
                    System.out.print("00 ");
                }
                while(s>0){System.out.print("0");--s;}
                if(i+1!=len)
                    System.out.print(" ");
                c=dd.charAt(i);
                s++;
            }
        }

    }

    static int s = 1;
    public static void connectMatch(char c, String a, int i){
        if(c == a.charAt(i)){
            ++s;
            return;
        }else{
            while(s>0){System.out.print("0");--s;}
            if(i+1 != a.length())
                System.out.print(" ");
            c = a.charAt(i);
            ++s;
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Input string:");
        String u = scan.nextLine();
        int len = u.length();
        System.out.println("\nThe result:");
        ArrayList<String> arr = new ArrayList<>();
        for(int i=0; i < len; i++){
            String d = Integer.toBinaryString(u.charAt(i));
            System.out.printf("%c = %07d :", u.charAt(i), Integer.parseInt(d));
            encode(u.charAt(i));
            arr.add(String.format("%07d\n", Integer.parseInt(d)));
            System.out.println();
        }

        boolean init;
        char prev = '1';
        for(String a: arr){
            len = a.length();
            s = 1;
            char c = a.charAt(0);
            init = false;

            for(int i = 1; i<len;i++){
                if(init && prev == a.charAt(0)){
                    if(c == a.charAt(i)){
                        connectMatch(c,a,i);
                        prev = c;
                        continue;
                    }else{
                        prev = c;
                    }
                }else{
                    init = true;
                }
                if(c == a.charAt(i)){
                    ++s;
                    continue;
                }else{
                    if(c == '1'){
                        System.out.print("0 ");
                    }else{
                        System.out.print("00 ");
                    }
                    while(s>0){System.out.print("0");--s;}
                    if(i+1!=len)
                        System.out.print(" ");
                    c = a.charAt(i);
                    s++;
                }
            }
        }
    }
}