
import java.util.Arrays;
import java.util.Scanner;

/*
*****Solved*****
UVA 11450 - Wedding Shopping (and p.95 in book, intro to DP)

Problem Type:
bottom up dp solution (easy)
knapsack problem

Abridged problem statement:
Given different options for each garment and a certain limited budget, the task
is to buy one model of each garment. We cannot spend more money than the given 
budget, but we want to spend the maximum possible amount.
*/

public class WeddingShopping2 {

    static int M,C;
    static int[][] price;
    static int maxModels = 21;
    static boolean reachable[][];
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        while(N-- > 0){
            M = scan.nextInt(); // amount of money
            C = scan.nextInt(); // number of garments
            price = new int[C][maxModels];
            reachable = new boolean[C][M+1];
            scan.nextLine();
            for (int i = 0; i < C; i++) {
                //input price of each model or garment into matrix
                String[] line = scan.nextLine().split(" ");
                for (int j = 0; j < line.length; j++) {
                    price[i][j] = Integer.parseInt(line[j]);
                }
            }
            
            for (int i = 0; i < price[0].length; i++) {
                if(M-price[0][i] >= 0)
                    reachable[0][M-price[0][i]] = true;
            }
            
            int money = M;
            for (int g = 1; g < C; g++) {
                for (int m = 0; m < M; m++) {
                    if(reachable[g-1][m])
                        for (int k = 1; k <= price[g][0]; k++) {
                            if(m - price[g][k] >= 0) reachable[g][m-price[g][k]] = true;
                        }
                }
            }
            
            int m;
            for (m = 0; m <= M && !reachable[C-1][m]; m++);
            
            if(m == M+1) System.out.println("no solution");
            else System.out.printf("%d\n", M-m);
            
        }

    }
}
