
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
**Solved**
Pesky Mosquitos
https://open.kattis.com/problems/mosquitoes
Geometry problem
Finding the most amount of mosquitos that can be covered with a circle of certain diameter
*/

public class Mosquito {
    double x, y;
    
    Mosquito(double x, double y){
        this.x = x;
        this.y = y;
    }
    
    double calcDist(Mosquito o){
        return Math.sqrt( Math.pow(this.x - o.x, 2) + Math.pow(this.y - o.y, 2));
    }
    
    double calcPerpSlope(Mosquito o){
        return -(this.x - o.x)/(this.y - o.y);
    }
    
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            String str = br.readLine();
            String[] strs = str.split(" ");
            int n = n = Integer.parseInt(strs[0]);
            
            for (int i = 0; i < n; i++) {
                br.readLine();
                String[] line = br.readLine().split(" ");
                int m = Integer.parseInt(line[0]);
                double d = Double.parseDouble(line[1]);
                
                Mosquito[] mqts = new Mosquito[m];
                for (int j = 0; j < m; j++) {
                    line = br.readLine().split(" ");
                    double x = Double.parseDouble(line[0]);
                    double y = Double.parseDouble(line[1]);
                    mqts[j] = new Mosquito(x, y);
                }
                if(mqts.length == 1){
                    System.out.println(1);
                }
                else{
                    System.out.println(maxMosquitos(mqts, d));
                }
                
            }
            
        } catch(IOException er){
            System.out.println("IOException");
        }
        
    }
    
    static int maxMosquitos(Mosquito[] mqts, double d){
        int maxCount = 1;
        for (int i = 0; i < mqts.length-1; i++) {
            for (int j = i+1; j < mqts.length; j++) {
                Mosquito m1 = mqts[i];
                Mosquito m2 = mqts[j];
                double dist = m1.calcDist(m2);
                if (dist <= d + Math.pow(10,-5)) {
                    double slope = 0;
                    if(m1.y != m2.y)
                         slope = m1.calcPerpSlope(m2);
                    double midptX = (m1.x + m2.x)/2;
                    double midptY = (m1.y + m2.y)/2;
                    double z = Math.sqrt(Math.pow(d/2, 2) - Math.pow(dist/2, 2));
                    double angle = Math.atan(slope);
                    double offSetX = Math.cos(angle)*z;
                    double offSetY = Math.sin(angle)*z;

                    //Check first circle
                    double cenX = midptX + offSetX;
                    double cenY = midptY+ offSetY;
                    if(m1.y == m2.y){
                        cenX = (m1.x +  m2.x)/2;
                        cenY = m2.y + Math.sqrt(Math.pow(d/2,2) - Math.pow(dist/2, 2));
                    }
                    Mosquito center = new Mosquito(cenX, cenY);

                    int count = 2;
                    for (int k = 0; k < mqts.length; k++) {
                        double distance = center.calcDist(mqts[k]);
                        if(distance <= d/2 + Math.pow(10,-5) &&  k != i && k != j){
                            count++;
                        }
                    }
                    if(count > maxCount)
                        maxCount = count;

                    //Check second circle
                    cenX = midptX - offSetX;
                    cenY = midptY - offSetY;
                    if(m1.y == m2.y){
                        cenX = (m1.x +  m2.x)/2;
                        cenY = m2.y - Math.sqrt(Math.pow(d/2,2) - Math.pow(dist/2, 2));
                    }
                    center = new Mosquito(cenX, cenY);
                    count = 2;
                    for (int k = 0; k < mqts.length; k++) {
                        double distance = center.calcDist(mqts[k]);
                        if(distance <= d/2 + Math.pow(10,-5) && k != i && k != j){
                            count++;
                        }
                    }
                    if(count > maxCount)
                        maxCount = count;
                }
                
            }
        }
        return maxCount;
    }

}
