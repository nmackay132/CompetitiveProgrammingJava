

import java.util.Scanner;

public class StackingCylinders {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nProb = in.nextInt();
        for (int q = 1; q <= nProb; q++) {
            int numCylin = in.nextInt();
            double[] cylindersX = new double[numCylin];
            double[] cylindersY = new double[numCylin];
            for (int i = 0; i < numCylin; i++) {
                cylindersX[i] = in.nextDouble();
                cylindersY[i] = 1;
            }
            
            for (int i = 0; i < numCylin - 1; i++) {
                double[] cylindersXTemp = new double[cylindersX.length - 1];
                double[] cylindersYTemp = new double[cylindersY.length - 1];
                
                for (int j = 0; j < cylindersX.length - 1; j++) {
                    double x1 = cylindersX[j];
                    double x2 = cylindersX[j + 1];
                    double y1 = cylindersY[j];
                    double y2 = cylindersY[j + 1];
                    double xd = (x1 + x2) / 2;
                    double yd = (y1 + y2) / 2;
                    double d = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
                    double h = Math.sqrt(4 - Math.pow(d / 2, 2));
                    double theta = Math.atan((yd - y1) / (xd - x1));
                    double xt = h * Math.sin(theta);
                    double yt = h * Math.cos(theta);
                    double xf;
                    if (y1 < y2) {
                        xf = xd - xt;
                    } else {
                        xf = xd + xt;
                    }
                    double yf = yd + yt;
                    cylindersXTemp[j] = xf;
                    cylindersYTemp[j] = yf;
                    //System.out.println(xf + " " + yf);
                    //cylindersY = new double[cylindersY.length-1];
                    //cylindersX[numCylin*(i+1)+j] = xf;
                    //cylindersY[numCylin*(i+1)+j] = yf;
                }

                cylindersX = cylindersXTemp;
                cylindersY = cylindersYTemp;
            }
            for (int x = 0; x < cylindersX.length; x++) {
                //  System.out.println(cylindersX[x] + " " + cylindersY[x]);
            }
            System.out.printf("%d: %.4f %.4f", q, cylindersX[0], cylindersY[0]);
            System.out.println();

        }
    }

}

/*
 5 
 4 1.0 4.4 7.8 11.2
 1 1.0 
 6 1.0 3.0 5.0 7.0 9.0 11.0 
 10 1.0 3.0 5.0 7.0 9.0 11.0 13.0 15.0 17.0 20.4 
 5 1.0 4.4 7.8 11.2 14.6
 */
