/*
Google Foobar Contest Level 3
Square Supplies

dp, coin change
*/

import java.util.ArrayList;
import java.util.Arrays;

public class SquareSupplies {
    
    static ArrayList<Integer> squares;
    static int[] memo;
    
    public static void main(String[] args) {
        int n = 10000;
        squares = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            squares.add(i*i);
        }
        memo = new int[n+1];
        Arrays.fill(memo, -1);
        
        int ans = calc(0, 5555);
        System.out.println(ans);
    }
    
    static int calc(int val, int goal){
        if(val > goal) return Integer.MAX_VALUE/2;
        if(val == goal) return 0;
        
        if(memo[val] != -1) return memo[val];
        
        int min = Integer.MAX_VALUE/2;
        for (int i = squares.size()-1; i >= 0; i--) {
            min = Math.min(min, calc(val + squares.get(i), goal) + 1);
        }
        
        return memo[val] = min;
    }

}
