
import java.util.Scanner;

/*
*****Solved*****
UVa 10038
Easy
*/

public class JollyJumpers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int N = sc.nextInt();
            boolean jolly = true;
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            
            boolean[] arr2 = new boolean[N];
            for (int i = 1; i < N; i++) {
                int diff = Math.abs(arr[i] - arr[i-1]);
                if(diff > 0 && diff < N)
                    arr2[diff] = true;
            }
            
            for (int i = 1; i < arr2.length; i++) {
                if(!arr2[i])
                    jolly = false;
            }
            
            if(jolly)
                System.out.println("Jolly");
            else
                System.out.println("Not jolly");
        }
    }
}

/*
4 1 4 2 3 
5 1 4 2 -1 6
*/