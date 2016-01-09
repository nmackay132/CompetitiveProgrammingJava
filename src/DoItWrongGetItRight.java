
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;



public class DoItWrongGetItRight {
    
    static int B,N;
    static ArrayList<Fraction> frac;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            B = sc.nextInt();
            N = sc.nextInt();
            if(B==0 && N==0) break;
            
            frac = new ArrayList<>();
            frac.add(new Fraction(0,2*N));
            
            for (int a = 1; a < B; a++) {
                double p1 = Math.sqrt(B*B - a*B);
                double m = B*N + N*p1 ;
                double m1 = 0, m2 = 0;
                if(m % B == 0){
                    m1 = m/B;
                    m2 = (B*N - N*p1)/B;
                    frac.add(new Fraction(a,(int)m1));
                    frac.add(new Fraction(a,(int)m2));
                }
            }
            Collections.sort(frac);
            for (Fraction f : frac) {
                System.out.print(f + " ");
            }
            System.out.println();
        }
    }
    
    static class Fraction implements Comparable<Fraction>{
        int num;
        int denom;
        double value;
        Fraction(int n, int d){
            num = n;
            denom = d;
            value = ((double) n)/d;
        }
        
        
        
        public String toString(){
            return num+"/"+denom;
        }

        public int compareTo(Fraction o) {
            if( this.value > o.value)
                return 1;
            else 
                return -1;
        }
    }

}

/*
9 12
12 14
4 12
0 0
*/