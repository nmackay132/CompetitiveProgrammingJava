import java.util.Scanner;


public class EuclidProblem {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            long a = sc.nextLong();
            long b = sc.nextLong();
            
            long px = 1;
            long py = 0;
            long x = 0;
            long y = 1;
            long r;
            
            while(true){
                long q = a/b;
                r = a%b;
                
                if(r == 0) break;
                
                long tempx = x;
                long tempy = y;
                x = px - x*q;
                y = py - y*q;
                px = tempx;
                py = tempy;
                
                a = b;
                b = r;
            }
            
            System.out.println(x + " " + y + " " + b);
        }
    }
    
}
