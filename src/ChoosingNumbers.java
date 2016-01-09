
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
*****Solved*****
Choosing Numbers
ACM-ICPC North American Qualifier 2012
https://open.kattis.com/problems/choosingnumbers

Problem Type:
Greedy

*/

public class ChoosingNumbers {

    static int[] cards;
    static boolean[] badCards;
            
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String line = br.readLine();
            if(line == null || line.equals("")) break;
            StringTokenizer st = new StringTokenizer(line);
            int N = Integer.parseInt(st.nextToken());
            cards = new int[N];
            badCards = new boolean[N];
            for (int i = 0; i < N; i++) {
                cards[i] = Integer.parseInt(st.nextToken());
            }
            
            Arrays.sort(cards);
            int max = -1;
            for (int i = 0; i < cards.length; i++) {
                //if(!badCards[i]){
                    for (int j = i+1; j < cards.length; j++) {
                        if(gcd(cards[i], cards[j]) > 1){
                            badCards[i] = true;
                            badCards[j] = true;
                        }
                    }
                    if(!badCards[i] && cards[i] > max)  max = cards[i];
                //}
            }
            System.out.println(max);
        }
    }
    
    static int gcd(int a, int b){ 
        return b==0 ? a : gcd(b, a%b);
    }
}

/*
2 4 7
4 4 8 15 16
4 2 3 4 8
*/