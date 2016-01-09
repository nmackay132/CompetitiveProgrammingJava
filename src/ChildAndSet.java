
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
http://codeforces.com/problemset/problem/437/B
Codeforces #250 (Div. 2)
B. The Child and Set
Involves calculating the lowest bit
Bit manipulation
*/

public class ChildAndSet {
    
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int sum = in.nextInt();
        int limit = in.nextInt();
        
        int tSum = sum;
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for (int i = 17; i >= 0; i--) { //2^17 is larger than 10^5
            if(Math.pow(2, i) <= tSum && Math.pow(2, i) <= limit && tSum > 0){
                tSum -= Math.pow(2,i);
                nums.add((int) Math.pow(2, i));
                System.out.print("c" + (int) Math.pow(2,i) + " ");
            }
        }
        
        for (int i = 3; i <= limit && tSum > 0; i++) {
            if(i%2 == 1){
                nums.add(i);
                System.out.print("c" + i + " ");
                tSum--;
            }
//            else{
//                int diff = 0;
//                while(diff > )
//            }
        }
        if(tSum > 0){
            System.out.println(-1);
        }
        else{
            System.out.println(nums.size());
            for (int i = 0; i < nums.size(); i++) {
                System.out.print(nums.get(i) + " ");
            }
        }
    }
}
