
import java.util.Arrays;
import java.util.Scanner;


public class DivisibleGroupSums {

    static int setCount = 0;
    static long arr[];
    static long memo[][][];
    static int N,M,D;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while(true){
            setCount++;
            N = sc.nextInt();
            if(N == 0) break;
            int Q = sc.nextInt();
            
            arr = new long[N];
            for (int i = 0; i < N; i++) 
                arr[i] = sc.nextInt();
            
            memo = new long[201][11][21];
            for (int i = 0; i < memo.length; i++) {
                for (int j = 0; j < memo[0].length; j++) {
                    Arrays.fill(memo[i][j], -1);
                }
            }
            
            System.out.println("SET " + setCount + ":");
            for (int i = 1; i <= Q; i++) {
                D = sc.nextInt();
                M = sc.nextInt();
                long answer = ways(0, M, 0);
                System.out.printf("QUERY %d: %d%n", i, answer);
            }

        }
    }
    
    static long ways(int index, int count, int sum){
        if(count == 0){
            if(sum == 0)
                return 1;
            return 0;
        }
        if(index >= N || count <= 0) return 0;
        if(memo[index][count][sum] > -1) return memo[index][count][sum];
        
        return memo[index][count][sum] = ways(index+1, count-1, mod(sum+arr[index],D) ) + ways(index+1, count, sum);
    }
    
    static int mod(long a, long d){
        long c;
        if(a<d)
        {
            a=-a;
            c=a%d;
            c=d-c;
        }
        else
            c=a;
        return (int)(c%d);
    }
}

/*
10 2
1
2
3
4
5
6
7
8
9
10
5 1
5 2
5 1
2
3
4
5
6
6 2
5 3
2
3
4
5
6
7 1
7 2
7 3
3 2
3
3
4
6 2
7 2
4 1
1
2
3
4
10 5
100 10
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1 1
1 2
1 3
1 4
1 5
1 6
1 7
1 8
1 9
1 10
3 1
1
1
1
1 5
5 3
2147483647
2147483647
2147483647
2
-2147483648
5 2
5 3
5 4
10 6
12
14
41
65
34
27
84
26
99
34
2 1
2 2
2 3
3 1
3 2
3 3
0 0
*/  

/*
3 2
3
3
4
6 2
7 2
*/