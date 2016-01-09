
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
*****Solved*****
Even Up Solitaire
2013 ACM North American Qualifier

Problem Type:
matching parentheses
*/

public class EvenUpSolitaire {
    
    void start()throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long start = System.currentTimeMillis();
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> stk = new Stack<Integer>();
        while(N-- > 0){
            int num = Integer.parseInt(st.nextToken());
            if(num % 2 == 0){
                if(!stk.isEmpty()){
                    if(stk.peek() == 0) stk.pop();
                    else stk.push(0);
                }
                else{
                    stk.push(0);
                }
            }
            else{ // num is odd
                if(!stk.isEmpty()){
                    if(stk.peek() == 1) stk.pop();
                    else stk.push(1);
                }
                else{ //sk is empty
                    stk.push(1);
                }
            }
        }
        
        System.out.println(stk.size());
        long time = System.currentTimeMillis() - start;
        System.out.println(time + " millisec");
    }
    
    public static void main(String[] args) throws IOException{
        new EvenUpSolitaire().start();
    }
    
    
    

}
