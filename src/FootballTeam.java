import java.util.*;

/*
**Solved**
http://codeforces.com/problemset/problem/432/B
Codeforces Round #246 (Div. 2)
B. Football Kit
Storing ints in arrays at indexes of the same value as the int
*/
public class FootballTeam {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number of teams: ");
        int numTeams = scan.nextInt();
        System.out.println("Enter team colors: ");
        int[] homeJ = new int[numTeams];
        int[] homeCol = new int[numTeams+1];
        int[] awayJ = new int[numTeams];
        for (int i = 0; i < numTeams; i++) {
            int hColor = scan.nextInt();
            homeCol[hColor]++;
            homeJ[i] = hColor;
            awayJ[i] = scan.nextInt();
        }
        int[] hCount = new int[numTeams];
        int[] aCount = new int[numTeams];
        for (int i = 0; i < numTeams; i++) {
            int color = awayJ[i];
            aCount[i] = (numTeams-1) - homeCol[color];
            hCount[i] = (numTeams-1) + homeCol[color];
        }
        System.out.println();
        for (int i = 0; i < numTeams; i++) {
            System.out.print(hCount[i] + " ");
            System.out.println(aCount[i]);
        }
    }
}
