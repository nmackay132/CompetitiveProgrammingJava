/*
Google FooBar Contest
Level 2
Math
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PeculiarBalance {  
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        String[] str = answer(x);
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);
        }
    }
    
    static List<Integer> powsOf3;
    static List<String> results;
    
    public static String[] answer(int x) { 

        powsOf3 = new ArrayList<>();
        results = new ArrayList<>();
        for (int i = 0; i <= 21; i++) {
            int pow = (int) Math.pow(3, i);
            powsOf3.add(pow);
            if(pow > x) break;
        }
        
        getWeights(powsOf3.size()-1, x, false);

        if(results.get(0) == "-") results.remove(0);
        
        String[] str = new String[results.size()];
        int j = 0;
        for (int i = results.size()-1; i >= 0; i--) {
            str[j++] = results.get(i);
        }
        return str;
    } 
    
    static void getWeights(int pos, int weight, boolean onLeft){
        
        if(pos < 0) return;
        
        int pow = powsOf3.get(pos);
        boolean take = false;
        boolean change = false;
        if(weight > pow){
            take = true;
            weight = weight - pow;
        }
        if(weight > pow/2){
            take = true;
            change = true;
            weight = pow - weight;
        }
        
        if(take){
            if(onLeft) 
                results.add("L");
            else
                results.add("R");
            if(change)
                onLeft = !onLeft;
        }
        else
            results.add("-");
        
        getWeights(pos-1, weight, onLeft);
    }
}