
import java.util.ArrayList;
import java.util.Scanner;



public class SendingEmail {

    static int N,M,S,T;
    static ArrayList< ArrayList<IntegerPair> > AdjList = new ArrayList< ArrayList<IntegerPair> >();
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        while(A-- > 0){
            N = sc.nextInt();
            M = sc.nextInt();
            S = sc.nextInt();
            T = sc.nextInt();
            
            AdjList.clear();
            for (int i = 0; i < N; i++) {
                ArrayList<IntegerPair> Neighbor = new ArrayList<>();
                AdjList.add(Neighbor);
            }
            
            for (int i = 0; i < M; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                int w = sc.nextInt();
                AdjList.get(u).add(new IntegerPair(v,w));
            }
        }
        
        
        
        

    }
    
    static class IntegerPair{
        
        int L; //dist from source
        int v; //vertex number
        
        IntegerPair(int L, int v){
            this.L = L;
            this.v = v;
        }
    }
}

/*
3
2 1 0 1
0 1 100
3 3 2 0
0 1 100
0 2 200
1 2 50
2 0 0 1
*/