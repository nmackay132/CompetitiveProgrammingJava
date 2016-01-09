import java.util.ArrayList;
import java.util.Scanner;

/*
*****Solved*****
Ping!
2013 ACM Southeast Regional
Problem C
https://ser.cs.fit.edu/ser2013/problems/division_1/SER2013%20Problem%20Set%20-%20Division%20I.pdf#page=10
*/

public class Ping {
    
    static int[] arr;
    static ArrayList<Integer> intervals;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            String line = sc.next();
            if(line.equals("0")) break;
            
            arr = new int[line.length()];
            intervals = new ArrayList<Integer>();
            for (int i = 1; i < line.length(); i++) {
                int num = line.charAt(i) - '0';
                if(num != arr[i]%2){
                    intervals.add(i);
                    for (int j = i; j < arr.length; j++) {
                        if(j%i == 0) arr[j]++;
                    }
                }
            }
            for (int i = 0; i < intervals.size()-1; i++) {
                System.out.print(intervals.get(i) + " ");
            }
            System.out.println(intervals.get(intervals.size()-1));
        }
    }

}

/*
01000101101000
1001000101001000
0
*/