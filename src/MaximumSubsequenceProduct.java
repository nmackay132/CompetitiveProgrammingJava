
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;



public class MaximumSubsequenceProduct {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            ArrayList<Integer> list = new ArrayList<Integer>();
            while(true){
                int n = sc.nextInt();
                if(n == -999999) break;
                list.add(n);
            }
            
            BigInteger prod;
            BigInteger maxProd = BigInteger.valueOf(Long.MIN_VALUE);
            for (int i = 0; i < list.size(); i++) {
                prod = BigInteger.valueOf(1);
                for (int j = i; j < list.size(); j++) {
                    prod = prod.multiply(BigInteger.valueOf(list.get(j)));
                    if(prod.compareTo(maxProd) > 0)
                        maxProd = prod;
                }
            }
            
            System.out.println(maxProd.toString());
        }
    }

}

/*
1 2 3 -999999
-5 -2 2 -30 -999999
-8 -999999
-1 0 -2 -999999
*/

/*
99900 99901 99902 99903 99904 99905 99906
99907 99908 99909 99910 99911 99912 99913
99914 99915 99916 99917 99918 99919 99920
99921 99922 99923 99924 99925 99926 99927
99928 99929 99930 99931 99932 99933 99934
99935 99936 99937 99938 99939 99940 99941
99942 99943 99944 99945 99946 99947 99948
99949 99950 99951 99952 99953 99954 99955
99956 99957 99958 99959 99960 99961 99962
99963 99964 99965 99966 99967 99968 99969
99970 99971 99972 99973 99974 99975 99976
99977 99978 99979 99980 99981 99982 99983
99984 99985 99986 99987 99988 99989 99990
99991 99992 99993 99994 99995 99996 99997
99998 99999 -999999
*/