import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class FlipFive2 {
    
    static int[] flips = {0b000001011, 0b000010111, 0b000100110, 0b001011001, 0b010111010, 0b100110100, 0b011001000, 0b111010000, 0b111010000, 0b110100000};

    public static void main(String[] args) {
        int[] distance = new int[2<<9];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;
        
        LinkedList<Integer> bfs = new LinkedList<Integer>();
        bfs.addLast(0);
        while(!bfs.isEmpty()){
            int at = bfs.removeFirst();
            for (int i = 0; i < 9; i++) {
                int to = at ^ flips[i];
                if(distance[to] == Integer.MAX_VALUE){
                    distance[to] = distance[at] + 1;
                    bfs.addLast(to);
                }
            }
        }
        
        Scanner in = new Scanner(System.in);
        int p = Integer.parseInt(in.nextLine());
        while(p-- > 0){
            int to = 0;
            for (int i = 0; i < 3; i++) {
                String line = in.nextLine();
                for (int j = 0; j < 3; j++) {
                    if(line.charAt(j) == '*'){
                        to += 1 << (3*i+j);
                    }
                }
            }
            System.out.println(distance[to]);
        }
    }
}
