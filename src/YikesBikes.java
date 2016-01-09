
import java.util.Scanner;



public class YikesBikes {
    
    static double M,B,D,T;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        while(N-- > 0){
            M = sc.nextDouble();
            B = sc.nextDouble();
            D = sc.nextDouble();
            T = sc.nextDouble();
            
            if(D/B > 6/M + T)
                System.out.println("Max beats the first bicycle");
            else if(D/B + 19*(2/B) < 5/M + T){
                System.out.println("Max crosses safely after bicycle 10");
            }
            else{
                for (int k = 0; k <= 19; k++) {
                    if(D/B + k*(2/B) <= 5/M + T && D/B+(k+1)*(2/B) > 6/M + T){
                        if(k%2 == 1){
                            System.out.println("Max crosses safely after bicycle " + (k/2 + 1) );
                            break;
                        }
                        else{
                            System.out.println("Collision with bicycle " + (k/2 + 1) );
                            break;
                        }
                    }
                    else if(D/B + k*(2/B) > 5/M + T && D/B + k*(2/B) <= 6/M + T){
                        System.out.println("Collision with bicycle " + (k/2 + 1));
                        break;
                    }
                }
            }
        }
    }

}

/*
4
5.0
5.0
5.0
0.0
5.0
5.0
6.3
0.0
5.0
5.0
0.0
5.9
3.0
5.0
5.0
6.9
*/