package JillRidesAgain;

import java.util.ArrayList;
import java.util.Scanner;

/*
**Solved**
Maximum subsequence
*/
public class BikeTrip {
    
    static int[] bStops;

    public static void main(String[] args){
        int[] routeArr;
        Scanner scan = new Scanner(System.in);
        System.out.println("Input number of routes: ");
        int routes = scan.nextInt();
        
        for (int i = 0; i < routes; i++){
            System.out.println("\nInput number of stops for route " + (i+1));
            int stops = scan.nextInt();
            routeArr = new int[stops];
            for (int j = 0; j < stops-1; j++){
                System.out.print("Input stop " + (j+1) + " for route " + 
                        (i+1) + ": ");
                routeArr[j] = scan.nextInt();
            }
            System.out.println("\nList of stops for route " + (i+1) + ":");
            for(int x = 0; x < stops; x++){
                System.out.println(routeArr[x] + " ");
            }
            
            int[] results = findBestRoute(routeArr);
            if (results[0] == -1)
                System.out.println("Route " + (i+1)+ " has no nice parts.");
            else{
                System.out.println("The nicest part of route " + (i+1) + " is "
                        + "between stops " + results[0] + " and " + results[1]);
            }
        }    }
    
    static int[] findBestRoute(int[] r){
        int bestSum = 0, sum = 0, bestEnd = 0;
        int bestLength = 0, currLength = 0;
        for (int i = 0; i < r.length; i++){
            sum += r[i];
            currLength++;
            if(sum > bestSum){
                bestSum = sum;
                bestLength = currLength;
                bestEnd = i;
            }
            else if (sum < 0){
                sum = 0;
                currLength = 0;
            }
            else if (sum == bestSum && currLength > bestLength){
                bestLength = currLength;
                bestEnd = i;
            }
        }
        int[] results = new int[2];
        if (bestEnd == r.length - 1 && bestLength == 1){
            results[0] = -1;
        }
        else{
            results[0] = bestEnd - bestLength + 2;
            results[1] = bestEnd+1;
        }
        return results;
    }
    
}
