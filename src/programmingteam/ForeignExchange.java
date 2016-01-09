package programmingteam;

import java.util.Scanner;

public class ForeignExchange {
    
    int end, count;
    public ForeignExchange(int end){
        this.end = end;
        this.count = 1;
    }
    
    public static void main(String[] args) {
        String name = "Nathan Mackay";
        String[] letters = name.split("");
        for (int i = 0; i < letters.length; i++) {
            System.out.println(letters[i]);
        }
//        Scanner in = new Scanner(System.in);
//        while(true){
//            
//        }
        
    }
}
