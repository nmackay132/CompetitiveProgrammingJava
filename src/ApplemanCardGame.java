import java.util.Arrays;
import java.util.Scanner;

/*
**Solved**
http://codeforces.com/problemset/problem/462/B
Codeforces #263 (Div.2)
B. Appleman and Card Game
*/

public class ApplemanCardGame {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n  = in.nextInt();
        int k = in.nextInt();
        String cardsStr = in.next();
        char[] cards = new char[n];
        int[] cardsNum = new int[26];
        for (int i = 0; i < n; i++) {
            cards[i] = cardsStr.charAt(i);
            cardsNum[Character.getNumericValue(cards[i])-10]++; //subtract 10 so 'A' is at 0 and 'Z' is at 25
        }
        
        long sum= 0;
        long coins = 0;
        int position = -1;
        while(sum < k){
            long max = 0;
            for (int i = 0; i < cardsNum.length; i++) {
                if(cardsNum[i] > max){
                    max = cardsNum[i];
                    position = i;
                }
            }
                cardsNum[position] = 0;
                long diff = (sum + max) - k; // how much the max puts the sum over k
                if (diff <= 0){
                    coins += max*max;
                    sum += max;
                }
                else{
                    long part = k - sum;
                    coins += part * part;
                    sum += part;
                }
        }
        System.out.println(coins);
    }
}
