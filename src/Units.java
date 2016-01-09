
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/*
Units
http://acm.student.cs.uwaterloo.ca/~acm00/140927/problem_statements.pdf
2014 ACM North America Qualifier

Problem Type:
?

Problem Statement:
Given different units and a conversion rate, list the equivalence of all the 
units in the smallest conversion rate.
*/

public class Units {
    
    static int N;
    static Unit[] units;
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        while(true){
            N = sc.nextInt();
            if(N == 0) break;
            units = new Unit[N];
            
            HashMap<String,Unit> hm = new HashMap<String,Unit>();
            for (int i = 0; i < N; i++) { //create units
                String name = sc.next();
                hm.put(name, new Unit(name));
            }
            
            for (int i = 0; i < N-1; i++) {
                String ustr = sc.next();
                sc.next();
                long uval = sc.nextLong();
                String usub = sc.next();
                Unit unit = hm.get(ustr);
                unit.subunits.add(usub);
                unit.values.add(uval);
            }
            
            for (Unit unit : hm.values()) {
                unit.max();
            }
            
            for (Unit unit : hm.values()) {
                if(unit.values.size() > 1){
                    
                    for (int i = 0; i < unit.subunits.size(); i++) {
                        String ustr = unit.subunits.get(i);
                        Unit subunit = hm.get(ustr);
                        subunit.maxValue = unit.maxValue / unit.values.get(i);
                        subunit.maxSubunit = unit.maxSubunit;
                    }
                }
                    
                
            }
        }
        
    }
    
    static class Unit{
       String name;
       ArrayList<Long> values;
       ArrayList<String> subunits;
       long maxValue;
       String maxSubunit;

       Unit(String name){
           values = new ArrayList<>();
           subunits = new ArrayList<>();
           this.name = name;
       }

       void max(){
           maxValue = 0;
           for (int i = 0; i < values.size(); i++) {
               if(values.get(i) > maxValue){
                   maxValue = values.get(i);
                   maxSubunit = subunits.get(i);
               }
           }
       }


   }
}

   

