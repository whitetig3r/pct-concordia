import java.util.*;
import java.lang.*;

public class PCT_Example_8{
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Long> list = new ArrayList<>();

    static boolean checkPrime(long num){
        if(num == 2) return true;
        if(num%2 == 0) return false;

        for(long i=3;i*i<=num;i++){
            if(num%i == 0) return false;
        }
        return true;
    }

    static long countBiPrimes(long low, long high){
        int ctr = 0;
        ArrayList<Long> counted = new ArrayList<>();
        for(long i=2;i<=high/2;i++){
            if(!checkPrime(i)) continue;
            for(long j=2;j<=i;j++){
                if(!checkPrime(j)) continue;
                if((i*j <= high) && (i*j >= low)){
                    if(!(counted.contains(i*j))){
                        counted.add(i*j);
                        ctr++;
                    }
                }
                else if(i*j > high) break;
            }
        }
        return ctr;
    }

    public static void main(String[] args){
        int n = Integer.parseInt(sc.nextLine());
        for(int i=0;i<n;i++){
            long low = Long.parseLong(sc.nextLine());
            long high = Long.parseLong(sc.nextLine());
            list.add(countBiPrimes(low,high));
        }
        for(Long x:list){
            System.out.print(x+" ");
        }
        System.out.print("\n");
    }
}

/*
Sample Input:
5
5
5
13908
16789
800
899
797888
802888
99001
100000
*/