
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/*
*****Solved******* (Exact ouput as other correct answers but not accepted!!)

Problem Type:
DP Coin Exchange

Problem Statement:
Currency consists of $100, $50, $20, $10, and $5 notes and $2, $1, 50c, 20c, 
10c and 5c coins. Determine, for any given amount, in how many ways that 
amount may be made up. Changing the order of listing does not increase the 
count. Thus 20c may be made up in 4 ways:
*/

public class Dollars {
    
    static int[] dollars = {5,10,20,50,100,200,500,1000,2000,5000,10000};
    static int goal;
    static long[][] memo;

    public static void main(String[] args)  {
        
        memo = new long[30001][dollars.length];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i],-1);
        }
        ways(30000, 0);
        
        Scanner sc = new Scanner(System.in);
//        File f = new File("input.txt");
//        Scanner sc = new Scanner(f);
        while(true){
            goal = (int) (sc.nextDouble()*100);
            if(goal == 0) break;
            
            Double db = goal/100.0;
            long answer = memo[goal][0];
            System.out.printf("%6.2f%17d%n",db, answer);
        }
    }

    private static long ways(int value, int dollar){
        if(value < 0) return 0;
        if(dollar == dollars.length) return 0;
        if(value == 0) return 1;
        if(memo[value][dollar] > -1) return memo[value][dollar];
        return memo[value][dollar] = ways(value-dollars[dollar], dollar) + ways(value, dollar + 1);
    }
}
