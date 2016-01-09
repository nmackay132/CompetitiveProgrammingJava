
import java.util.Arrays;
import java.util.Scanner;

/*
*****Solved*****
UVA 11450 - Wedding Shopping (and p.95 in book, intro to DP)

Problem Type:
topdown dp solution (easy)
knapsack problem

Abridged problem statement:
Given different options for each garment and a certain limited budget, the task
is to buy one model of each garment. We cannot spend more money than the given 
budget, but we want to spend the maximum possible amount.
*/

public class WeddingShopping {
    
    static int[][] price;
    static int maxModels = 25;
    static int M,C;
    static int[][] memo;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        while(N-- > 0){
            M = scan.nextInt(); // amount of money
            C = scan.nextInt(); // number of garments
            price = new int[C][maxModels];
            memo  = new int[M+1][C];
            scan.nextLine();
            for (int i = 0; i < C; i++) {
                //input price of each model or garment into matrix
                String[] line = scan.nextLine().split(" ");
                for (int j = 0; j < line.length; j++) {
                    price[i][j] = Integer.parseInt(line[j]);
                }
            }
            
            fill(memo);
            int score = shop(M, 0);
            if(score < 0)
                System.out.println("no solution");
            else
                System.out.println(score);
        }
        
        
    }
    
    static int shop(int money, int g){
        if(money < 0)
            return Integer.MIN_VALUE;
        if(g == C)
            return M - money;
        if(memo[money][g] != -1)
            return memo[money][g];
        int ans = -1;
        for (int model = 1; model <= price[g][0]; model++) { //price[g][0] = num of models of g
            ans = Math.max(ans, shop(money - price[g][model], g+1));
        }
        return memo[money][g] = ans;
    }

    private static void fill(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = -1;
            }
        }
    }
}

/*
3
100 4
3 8 6 4
2 5 10
4 1 3 3 7
4 50 14 23 8
20 3
3 4 6 8
2 5 10
4 1 3 5 5
5 3
3 6 4 8
2 10 6
4 7 3 1 7
*/