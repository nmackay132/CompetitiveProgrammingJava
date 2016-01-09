
/*
UVa 725 - Division
Iterative Complete Search - Two Nested Loops

Problem: Find and display all pairs of 5-digit numbers that collectively use
the digits 0 through 9 once each, such that the first number divided by the
second is equal to an integer N, where 2<=N<=79. That is abcde / fghij = N,
where each letter represents a different digit. The first digit on one of the 
numbers is allowed to be zero.
*/

public class Division {

    public static void main(String[] args) {
//        int max = 98765 / 1234;
        int N = 2;
        for (int fghij = 1234; fghij < 98765 / N; fghij++) {
            int abcde = fghij * N; // abcde and fghij are at most 5 digits
            int temp;
            int used = (abcde < 10000 ? 1 : 0);
            temp = abcde;
            while(temp > 0) {used |= 1<<(temp % 10); temp /= 10;}
            temp = fghij;
            while(temp > 0) {used |= 1<<(temp % 10); temp /= 10;}
            if(used == (1<<10) - 1)
                System.out.println(abcde + " " + fghij);
        }
    }
}
