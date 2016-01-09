package AntoneAndLetters;

import java.util.ArrayList;
import java.util.Scanner;

public class A {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numLetters = scan.nextInt();
        String letters[] = new String[numLetters];
        for (int i = 0; i < numLetters; i++){
            letters[i] = scan.next();
        }
        System.out.println(countDistinctLetters(letters));
    }
    
    static int countDistinctLetters(String[] letters){
        ArrayList<String> dletters = new ArrayList<String>();
        for (int i = 0; i < letters.length; i++){
            boolean found = false;
            for (int j = 0; j < dletters.size(); j++){
                if (letters[i].equals(dletters.get(j))){
                    found = true;
                }
            }
            if (!found)
                dletters.add(letters[i]);
        }
        return dletters.size();
    }
}
