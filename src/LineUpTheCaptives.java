
import java.math.BigInteger;

/*
Google FooBar contest
Level 4

Stirling numbers
*/


public class LineUpTheCaptives {

  static final int MAXN = 41;
  static final BigInteger[][] c = new BigInteger[MAXN][MAXN];
  static final BigInteger[][] s = new BigInteger[MAXN][MAXN];

  public static void main(String[] args) {
      System.out.println(answer(7,8,40));
  }
  
  public static String answer(int x, int y, int n) { 


    // Combinations: Pascal triangle
    c[0][0] = BigInteger.ONE;
    for (int i = 1; i < n+1; i++)
      for (int j = 0; j <= i; j++)
        c[i][j] = ((j > 0 ? c[i - 1][j - 1] : BigInteger.ZERO).add(c[i - 1][j]));

        // Unsigned Stirling numbers of the first kind
        // s[i][j] == # of permutations of length i, with j buildings visible from left (or right)
        s[0][0] = BigInteger.ONE;
        for (int i = 1; i <= n; i++)
          for (int j = 1; j <= i; j++)
            /*
             * For [i][j] consider the placement of the shortest building: 1. At the leftmost position -- it is always visible,
             * thus compute for [i-1][j-1] 2. Anywhere else, except the leftmost position -- it is never visible, thus compute for
             * [i-1][j]
             */
            s[i][j] = s[i - 1][j - 1].add(s[i - 1][j].multiply(new BigInteger((i-1)+"") ) );

        BigInteger result = BigInteger.ZERO;
        for (int k = 0; k < n; k++)
          /*
           * All valid permutations are counted: 1. Place the tallest building at position k. 2. Choose k buildings that form a
           * configuration with A visible buildings from the left. 3. Rest of the buildings form B visible buildings from the
           * right.
           */
          result = result.add(c[n - 1][k].multiply(s[k][x - 1]).multiply(s[n - k - 1][y - 1]));
        return result + "";
    } 
}


