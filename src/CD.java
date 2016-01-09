
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

/*
*****Solved*****
UVa 11849

Problem Type:
easy, TreeSet
*/

public class CD {
    
    static int N, M;
    static TreeSet<Integer> ts;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String line[] = br.readLine().split(" ");
            N = Integer.parseInt(line[0]);
            M = Integer.parseInt(line[1]);
            if(N==0) break;
            ts = new TreeSet<>();
            for (int i = 0; i < N; i++) 
                ts.add(Integer.parseInt(br.readLine()));
            
            int count = 0;
            for (int i = 0; i < M; i++) 
                if(ts.contains(Integer.parseInt(br.readLine()) ) ) 
                    count++;
            
            System.out.println(count);
        }
    }

}

/*
3 3
1
2
3
1
2
4
0 0
*/