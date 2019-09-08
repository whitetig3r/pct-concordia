import java.util.*;
import java.lang.*;

public class PCT_Example_9 {
    static Scanner sc = new Scanner(System.in);
    static HashMap<Integer,Integer> snake_ladder = new HashMap<>();

    static void printWinner(int A,int B){
        if(A > B) System.out.print("A" + " " + A + "\n");
        else System.out.print("B" + " " + B + "\n");
    }

    static int recCheck(int pos){
        if(snake_ladder.containsKey(pos)){
            return recCheck(snake_ladder.get(pos));
        }
        return pos;
    }

    public static void main(String[] args){
        int n = Integer.parseInt(sc.nextLine());

        for(int i=0;i<n;i++){
            String pair_str = sc.nextLine();
            String[] pair = pair_str.split(" ");
            int x = Integer.parseInt(pair[0]);
            int y = Integer.parseInt(pair[1]);
            snake_ladder.put(x,y);
        }

        int d = Integer.parseInt(sc.nextLine());
        int A = 1;
        int B = 1;

        boolean flag = false;
        String inp = sc.nextLine();
        String[] inp_list = inp.split(" ");

        for(int i=0;i<d;i++){
            int val = Integer.parseInt(inp_list[i]);
            if(i%2 == 0) {
                A += val;
                if(snake_ladder.containsKey(A)){
                   A = recCheck(A);
                }
            }
            else {
                B += val;
                if(snake_ladder.containsKey(B)){
                   B = recCheck(B);
                }
            }
        }
        printWinner(A,B);
    }
}

/*
Sample Input:
2
27 88
97 14
18
4 1 3 2 6 3 6 3 2 4 4 2 1 1 5 2 4 6
-------
3
14 99
99 1
7 14
10
5 1 3 3 1 1 4 1 6 1
*/