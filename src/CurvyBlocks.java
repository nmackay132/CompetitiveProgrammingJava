import java.util.Scanner;

/*
*****Solved*****
Stacking Curvy Blocks Problem C
ACM-ICPC North American Qualifier 2012
https://open.kattis.com/problems/curvyblocks

Problem Type: Math, Calculus
*/
public class CurvyBlocks {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            double b0 = sc.nextDouble();
            double b1 = sc.nextDouble();
            double b2 = sc.nextDouble();
            double b3 = sc.nextDouble();
            
            double t0 = sc.nextDouble();
            double t1 = sc.nextDouble();
            double t2 = sc.nextDouble();
            double t3 = sc.nextDouble();
            
            double a = 3*(t3-b3);
            double b = 2*(t2-b2);
            double c = t1-b1;
            
            double x1 = 0;
            double x2 = 0;
            if(b*b - 4*a*c >= 0){
                x1 = (-b + Math.sqrt(b*b - 4*a*c) )/(2*a);
                x2 = (-b - Math.sqrt(b*b - 4*a*c) )/(2*a);
            }
            if(x1 > 1 || x1 < 0) x1 = 0;
            if(x2 > 1 || x2 < 0) x2 = 0;
            
            double y1 = (t0-b0)+(t1-b1)*x1+(t2-b2)*x1*x1+(t3-b3)*x1*x1*x1;
            double y2 = (t0-b0)+(t1-b1)*x2+(t2-b2)*x2*x2+(t3-b3)*x2*x2*x2;
            double y3 = t0-b0;  //when x=0
            double y4 = (t0-b0)+(t1-b1)+(t2-b2)+(t3-b3);    //when x=1
            
            double ans1 = Math.max(y1,y2);
            double ans2 = Math.max(y3,y4);
            double max = Math.max(ans1, ans2);
            
            ans1 = Math.min(y1,y2);
            ans2 = Math.min(y3,y4);
            double min = Math.min(ans1,ans2);
            System.out.println(max-min);
        }
    }
}

/*
1.000000 -12.904762 40.476190 -28.571429
3.000000 11.607143 -34.424603 22.817460
2.000000 -10.845238 16.964286 -10.119048
3.000000 4.190476 -3.571429 2.380952
*/