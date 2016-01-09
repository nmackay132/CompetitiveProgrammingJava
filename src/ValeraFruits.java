import java.util.Scanner;

/*
**Solved**
http://codeforces.com/problemset/problem/441/B
Codeforces Round #252 (Div. 2)
B. Valera and Friuts
Calculates maximum number of fruits collected with certain criteria
*/

public class ValeraFruits {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number of fruit trees and fruit collected per day: ");
        int numTrees = scan.nextInt();
        int maxFpd = scan.nextInt();
        
        System.out.println("Enter day fruit ripen and number of fruits on tree");
        int[] frOnDay = new int[numTrees+2];
        int maxDay = 0;
        for (int i = 1; i <= numTrees; i++) {
            int day = scan.nextInt();
            if(day > maxDay){
                maxDay = day;
            }
            int numFruit = scan.nextInt();
            frOnDay[day] += numFruit;
        }
        
        int prev = 0;
        int total = 0;
        for (int i = 1; i <= maxDay + 1; i++) {
            int fpd = maxFpd;
            if (prev >= fpd){
                total += fpd;
                prev = frOnDay[i];
                fpd = 0;
            }
            else if (prev < fpd){
                total += prev;
                fpd -= prev;
            }
            if (frOnDay[i] >= fpd){
                total += fpd;
                prev = frOnDay[i] - fpd;
            }
        }
        System.out.println("Total = " + total);
    }
}
