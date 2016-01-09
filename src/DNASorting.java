import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
**Solved**
DNA Sorting
Sorting strings, compareTo
*/

public class DNASorting {

    public static void main(String[] args) {
        String name = "Nathan Mackay";
        String[] letters = name.split("");
        for (int i = 0; i < letters.length; i++) {
            System.out.println(letters[i]);
        }
        Scanner in = new Scanner(System.in);
        int ds = in.nextInt(); //ds is number of data sets
        for (int i = 0; i < ds; i++) {
            int n = in.nextInt();
            int m = in.nextInt();
            ArrayList<DNAString> dnaStrings = new ArrayList<DNAString>();
            for (int j = 0; j < m; j++) {
                String str = in.next();
                dnaStrings.add(new DNAString(str, j) );
            }
            Collections.sort(dnaStrings);
            System.out.println();
            for(DNAString s : dnaStrings){
                System.out.println(s);
            }
        }
    }
}
