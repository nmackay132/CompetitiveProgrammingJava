import java.util.ArrayList;
import java.util.Scanner;

/*
**Solved**
2013 FIU Qualifer Competition
Finding maximum subsequence in a list
*/

public class Profits {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> answers = new ArrayList<Integer>();
        while(true){
            int n = in.nextInt();
            if(n == 0) 
                    break;
            int[] days = new int[n];
            int profit = 0;
            for (int i = 0; i < n; i++) {
                profit = in.nextInt();
                days[i] = profit;
            }
            
            int sum = 0, maxSum = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                sum += days[i];
                if (sum > maxSum)
                    maxSum = sum;
                if (sum < 0)
                    sum = 0;
            }
            answers.add(maxSum);
        }
        
        for (int i = 0; i < answers.size(); i++) {
            System.out.println(answers.get(i));
        }
    }
}
