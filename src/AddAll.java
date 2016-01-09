
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
**Solved**
Utilizes PriorityQue
*/

public class AddAll {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(true){
            int n = in.nextInt();
            if(n == 0)
                break;
            PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
            for (int i = 0; i < n; i++) {
                pq.add(in.nextInt());
            }
            
            int cost = 0;
            while(pq.size() > 1){
                int value = pq.poll() + pq.poll();
                cost += value;
                pq.add(value);
            }
            System.out.println(cost);
        }
    }
}
