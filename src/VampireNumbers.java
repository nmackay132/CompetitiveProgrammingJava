

import java.util.Arrays;
import java.util.Scanner;

/*
****Solved****
2011 ACM  ICPC Southeast USA Regional
Problem J: Vampire Numbers
*/

public class VampireNumbers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(true){
            int n = scan.nextInt();
            if(n == 0) break;
            while(true){
                if(isVampNum(n))
                    break;
                n++;
            }
            System.out.println(n);
        }
    }
    
    public static boolean isVampNum(int num){
        int divisor = (int) Math.sqrt(num);
        while(divisor > 0){
            if(num % divisor == 0){
                int quotient = num / divisor;
                if(isMadeFrom(num, divisor, quotient))
                    return true;
            }
            divisor--;
        }
        return false;
    }
    
    public static boolean isMadeFrom(int product, int fact1, int fact2){
        char[] productArr = (product + "").toCharArray();
        char[] factArr = (fact1 + "" + fact2).toCharArray();
        if(productArr.length == factArr.length){
            Arrays.sort(productArr);
            Arrays.sort(factArr);
            for (int i = 0; i < productArr.length; i++) {
                if(productArr[i] != factArr[i])
                    return false;
            }
            return true;
        }
        return false;
    }
}
