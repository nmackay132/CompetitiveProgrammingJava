
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/*
*****Solved*****
Book problem p.108 Coin Change (but with different coin values)

Problem Type:
dp Coin Change

Problem Statement:
Given a target amount, what is the minimum amount of coins/dollars used to
represent the target amount?
*/

public class CoinChange {
    
    static int[] dollars = {5,10,20,50,100,200,500,1000};
    static int goal;
    static int[] memo;
    static int INF = 1000000000;

    public static void main(String[] args) throws IOException {
        File f = new File("input.txt");
        Scanner sc = new Scanner(f);
        while(true){
            goal = (int) (sc.nextDouble()*100);
            if(goal == 0) break;
            memo = new int[30001];
            Arrays.fill(memo, -1);
            
            int answer = change(goal);
            Double db = goal/100.0;
            System.out.printf("%.2f%17d%n",db, answer);
        }
            
    }

    private static int change(int value) {
        if(value < 0) return INF;
        if(value == 0) return 0;
        if(memo[value] > -1) return memo[value];
        int min = INF;
        for (int i = 0; i < dollars.length; i++) {
            int temp = change(value - dollars[i]);
            if(temp < min) min = temp;
        }
        return memo[value] = 1 + min;
    }
}
