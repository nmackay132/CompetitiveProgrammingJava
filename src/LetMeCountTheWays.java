
import java.util.Scanner;

/*
*****Solved*****
UVa 357 - Let Me Count the Ways
Problem Type:
DP, Coin Change

Problem Statement:
How many different combinations of coins can make correct change for a value.
*/

public class LetMeCountTheWays {
    
    static int N;
    static int M; //number of possible ways
    static int[] coins = {50,25,10,5,1};    
    static long memo[][] = new long[5][30001];
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[0].length; j++) {
                memo[i][j] = -1;
            }
        }
        
        while(sc.hasNext()){
            N = sc.nextInt();
            
            long answer = ways(0,N);
            
            if(answer == 1)
                System.out.printf("There is only 1 way to produce %d cents change.\n", N);
            else
                System.out.printf("There are %d ways to produce %d cents change.\n", answer, N);
        }
    }

    static long ways(int type, int value){
        if(value == 0) return 1;
        else if(value < 0) return 0;
	else if(type >= 5) return 0;
        else if(memo[type][value] >= 0)
            return memo[type][value];
        else
            return memo[type][value] = ways(type, value - coins[type]) + ways(type + 1, value);
    }
}

/*
17
11
4
0
88
456
6454
20000
30000
*/

