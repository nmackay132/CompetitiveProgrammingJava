
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;



public class ProblematicPublicKeys {
    
    static int[] keys;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int caseNo = 0;
        while(caseNo++ < N){
            sc.nextInt();
            int M = sc.nextInt();
            keys = new int[M];
            for (int i = 0; i < keys.length; i++) {
                keys[i] = sc.nextInt();
            }
            
            Arrays.sort(keys);
            ArrayList<Integer> primes = new ArrayList<>();
            
            boolean ok2 = true;
            for (int i = 0; i < keys.length; i++) {
                if(keys[i]%2 != 0){
                    ok2 = false;
                    break;
                }
            }
            
            if(ok2) primes.add(2);
            
//            for (int i = 0; i < keys.length; i++) {
//                System.out.print(keys[i] + " ");
//            }
            
            int n = 3;
            while(n < keys[0]/2){
                int a;
                for (a = n; a <= Math.sqrt(keys[0]); a+=2) {
                    if(keys[0]%a==0) {
//                        System.out.println("a" + a);
                        break;
                    }
                }
                System.out.println("test1 " + a);
                boolean isFactor = true;
                for (int i = 1; i < keys.length; i++) {
                    if(keys[i] % a != 0){
                        isFactor = false;
                        System.out.println("test3 " + a + " " + keys[i]);
                        break;
                    }
                }
                if(isFactor){
                    System.out.println("test2");
                    primes.add(a);
                }
                n = a + 2;
            }
            Collections.sort(primes);
            
            System.out.println(caseNo);
            for (int i = 0; i < primes.size(); i++) {
                if(i!=0 && i%5==0)
                    System.out.println();
                System.out.print(primes.get(i) + " ");
            }
            System.out.println();
            
        }
        
        
    }
    
    
    
}

/*
3
1 6
221 391 713 1457 901
299
2 4
13193 18721 31897 18527
3 2
2143650557 2140117121

1
1 6
221 391 713 1457 901
299
*/