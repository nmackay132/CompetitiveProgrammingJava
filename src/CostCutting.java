
import java.util.Arrays;
import java.util.Scanner;

/*
*****Solved*****
UVa 11727
Easy
*/

public class CostCutting {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int caseNo = 0;
        while(caseNo++ < N){
            int[] arr = new int[3];
            for (int i = 0; i < 3; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            
            System.out.printf("Case %d: %d\n",caseNo, arr[1]);
        }
    }

}

/*
3 1000 2000 3000 3000 2500 1500 1500 1200 1800
*/
