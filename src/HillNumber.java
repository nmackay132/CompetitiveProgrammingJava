    
import java.util.Arrays;
import java.util.Scanner;

/*
*****Solved*****
Hill Number Problem E
2014 ACM Southeast Regional

Problem Type:
dp
*/

public class HillNumber {

    static long[][][][] memo;
    static int NUM;
    static int arr[];
    static String str;
            
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        NUM = sc.nextInt();
        
        str = NUM +"";
        arr = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i) - '0';
        }
        
        if(!isHill())
            System.out.println(-1);
        
        memo = new long[2][2][10][19];
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[i].length; j++) {
                for (int k = 0; k < memo[i][j].length; k++) {
                    Arrays.fill(memo[i][j][k],-1);
                }
            }
        }
        
        System.out.println(compute(0,1,0,0)-1); //don't want to count 0 since it's not positive
    }
    
 /**
     * Count the number of hill numbers.
     * 
     * @param u 0 if the digits are going up, 1 if they've started going down
     * @param c 1 if we have to constrain the digits, 0 if not
     * @param d the previous digit
     * @param p the position in the number, from left to right
     * @return Count of hill numbers under the above conditions
     */
    private static long compute(int u, int c, int d, int p) {
        if(p == arr.length) return 1;
        if(memo[u][c][d][p] != -1) return memo[u][c][d][p];
        long sum = 0;
        if(c == 0){
            if(u==0){
                for (int i = 0; i <= 9; i++) {
                    if(i >= d) sum += compute(u,c,i,p+1);
                    else sum += compute(1,c,i,p+1);
                }
            }
            else{ //u==1
                for (int i = d; i >= 0; i--) 
                    sum += compute(1,c,i,p+1);
            }
        }
        else{ //c==1
            if(u==0){
                for (int i = 0; i <= arr[p]; i++) {
                    int newc = i==arr[p] ? 1:0;
                    if(i >= d)
                        sum += compute(u,newc,i,p+1);
                    else
                        sum += compute(1,newc,i,p+1);
                }
            }
            else{ //u==1
                int upper = arr[p] < d ? arr[p] : d; 
                for (int i = upper; i >= 0; i--) {
                    int newc = i==arr[p] ? 1:0;
                    sum += compute(u,newc,i,p+1);
                }
            }
        }
        return memo[u][c][d][p] = sum;
    }

    private static boolean isHill() {
        boolean down = false;
        int prev = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] >= prev && down) return false;
            if(arr[i] < prev) down = true;
            prev = arr[i];
        }
        return true;
    }
}
