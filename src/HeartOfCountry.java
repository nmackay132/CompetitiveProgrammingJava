import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

class HeartOfCountry {
    static Node[] cities;
    static int k;
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(true){
            int n = in.nextInt();
            k = in.nextInt();
            if(n == 0) break;
            
            cities = new Node[n];
            for (int i = 0; i < n; i++) {
                cities[i] = new Node(i);
            }
            for (int i = 0; i < n; i++) {
                int troops = in.nextInt();
                int numNeighbors = in.nextInt();
                cities[i].troops = troops;
                for (int j = 0; j < numNeighbors; j++) {
                    int neighborIndex = in.nextInt();
                    cities[i].neighbors.add(cities[neighborIndex]);
                }
            }
            
            removeNeighbors();
            int countCities = 0;
            int countTroops = 0;
            for (int i = 0; i < cities.length; i++) {
                if(!cities[i].visited){
                    countCities++;
                    countTroops += cities[i].troops;
                }
            }
            
            System.out.println(countCities + " " + countTroops);
        }
        
    }
    
    static void removeNeighbors(){
        boolean cityWasRemoved = true;
        while(cityWasRemoved){
            cityWasRemoved = false;
            for (int i = 0; i < cities.length; i++) {
                if(!cities[i].visited){
                    cities[i].calcSum();
                    if(cities[i].troopsSum < k){
                        remove(cities[i]);
                        cities[i].visited = true;
                        cityWasRemoved = true;
                    }
                }
            }
        }
    }
    
    static void remove(Node thisN){
        for (int i = 0; i < thisN.neighbors.size(); i++) {
            Node neighbor  = thisN.neighbors.get(i);
            neighbor.neighbors.remove(thisN);
        }
    }

    
    static class Node{
        int troops;
        int num;
        ArrayList<Node> neighbors;
        int troopsSum;
        boolean visited;
        
        Node(int num){
            this.num = num;
            neighbors = new ArrayList<Node>();
        }
        
        void calcSum(){
            int sum = troops;
            for(Node n : neighbors){
                sum += n.troops;
            }
            troopsSum = sum;
        }
    }
}

/*
4 900
100 2 1 2
200 2 0 3
500 2 0 3
1000 2 1 2
4 900
100 3 1 2 3
200 3 0 3 2
500 3 1 3 0
1000 3 2 1 0
0 0

4 900
100 2 1 2
200 1 0
500 1 0
1000 0
4 900
100 3 1 2 3
200 3 0 3 2
500 3 1 3 0
1000 3 2 1 0
0 0
*/