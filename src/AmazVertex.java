import java.util.ArrayList;

/*
Used for MonitoringAmazon class
*/
public class AmazVertex {
    
    int xC, yC;
    boolean visited;
    ArrayList<AmazVertex> neighbors;
    
    public AmazVertex(int x, int y){
        this.xC = x;
        this.yC = y;
        this.visited = false;
        neighbors = new ArrayList<AmazVertex>();
    }
    
    public double calcDistance(AmazVertex o){
        double temp = Math.sqrt(Math.pow((this.xC - o.xC),2) + Math.pow(this.yC - o.yC, 2));
        return (temp*100)/100;
    }
    
    public void addVertex(AmazVertex o){
        if(this == o) return;
        if(neighbors.size() < 2) { neighbors.add(o); return; }
        double dist = calcDistance(o);
        ArrayList<AmazVertex> newNeighbors = new ArrayList<AmazVertex>();
        for(AmazVertex neighbor : neighbors) {
            double distN = calcDistance(neighbor);
            if(distN == dist) {
                if (o.xC < neighbor.xC) newNeighbors.add(o); 
                else if(o.yC < neighbor.yC) { newNeighbors.add(o); break; }
            }
            else if(distN > dist) { newNeighbors.add(o); break; }
        }
        if(newNeighbors.size() == 1) {
            AmazVertex v1 = neighbors.get(0);
            AmazVertex v2 = neighbors.get(1);
            double dist0 = calcDistance(v1);
            double dist1 = calcDistance(v2);
            if(dist0 == dist1) {
                if (v1.xC > v2.xC) {
                    neighbors.remove(v1);
                }
                else if(v1.yC > v2.yC) {
                    neighbors.remove(v1);
                }
                else {
                    neighbors.remove(v1);
                }
                neighbors.add(newNeighbors.get(0));
            }
            else if(dist0 < dist1) {
                neighbors.remove(v2);
                neighbors.add(newNeighbors.get(0));
            }
            else if(dist0 > dist1) {
                neighbors.remove(v1);
                neighbors.add(newNeighbors.get(0));
            }
        }
    }
    
    public String toString(){
        return xC + " " + yC;
    }
}
