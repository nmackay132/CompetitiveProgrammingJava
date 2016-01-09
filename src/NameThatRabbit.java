
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/*
Google FooBar Contest
Level 2

Sorting
*/

public class NameThatRabbit {
    
    public enum State {COOL, BUY, SELL}

    static class Name implements Comparable<Name>{
        String str;
        int val;
        
        Name(String s){
            this.str = s;
            val = calc(s);
        }
        
        int calc(String s){
            int num = 0;
            for (int i = 0; i < s.length(); i++) {
                num += ((s.charAt(i) - 'a') + 1);
            }
            return num;
        }

        @Override
        public int compareTo(Name o) {
            if(this.val == o.val){
                return this.str.compareTo(o.str);
            }
            return this.val - o.val;
        }
    }
    
    public static void main(String[] args) {
        /*
        annie bonnie liz
        abcdefg vi
        */
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] nStr = line.split(" ");
        Name[] nameObjs = new Name[nStr.length];
        for (int i = 0; i < nStr.length; i++) {
            nameObjs[i] = new Name(nStr[i]);
        }
        Arrays.sort(nameObjs, Collections.reverseOrder());
        
        String[] result = new String[nameObjs.length];
        for (int i = 0; i < nameObjs.length; i++) {
            result[i] = nameObjs[i].str;
        }
    }
}
