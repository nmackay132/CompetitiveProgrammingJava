import java.util.Arrays;
import java.util.Scanner;

/*
$$$$$Solved$$$$$ (Too slow, but same speed as posted solution...which weren't
accepted either)
You Win!
2013 ACM Southeast Regional
Problem J

Problem Type:
dp
*/

public class YouWin {
    
    static int memo[][];
    static String word;
    static int INF = 2000000000;
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        while(true){
            word = sc.next();
            if(word.equals("0")) break;
            
            memo = new int[1<<word.length()][word.length()+1];
            for (int i = 0; i < memo.length; i++) {
                Arrays.fill(memo[i],-1);
            }
            
            int min = INF;
            for (int i = 0; i < word.length(); i++) {
                min = Math.min( moves(( 1<<word.length())-1, i), min);
            }
            System.out.println(min-1);
            
        }
    }

    private static int moves(int bit, int last) {
        if(bit == 0) return seperation(last, word.length());
        if(memo[bit][last] != -1) return memo[bit][last];
        
        int min = INF;
        for (int i = 0; i < word.length(); i++) {
            if(( (1<<i) & bit) != 0){
                int count = count(bit,last,i);
                int sep = seperation(last, i);
                int temp = 1 + count + sep + moves( ( (~(1<<i) )& bit), i);
                min = Math.min(min,temp);
            }
        }
        return memo[bit][last] = min;
    }

    private static int count(int bit, int last, int curr) {
        int count = 0;
        if(last > curr){
            for (int i = last-1; i > curr; i--) {
                if( ((1<<i)&bit) != 0) count++;
            }
        }
        else{ //last < curr
            for (int i = last; i <= curr; i++) {
                if( ((1<<i)&bit) != 0) count++;
            }
        }
        return count;
    }

    private static int seperation(int last, int curr) {
        char first = word.charAt(last);
        char sec = ( curr == word.length() ) ? 'A' : word.charAt(curr);
        if(first < sec){
            int forw = sec - first;
            int back = 1 + ('Z'-sec) + (first - 'A');
            return Math.min(forw,back);
        }
        else{ //sec <= forw
            int forw = first - sec;
            int back = 1 + ('Z'-first) + (sec - 'A');
            return Math.min(forw, back);
        }
    }

}

/*
ALMA
YES
0
*/
