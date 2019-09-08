import java.util.*;
import java.lang.*;

public class PCT_Example_10 {
    static Scanner sc = new Scanner(System.in);

    static int countIntersections(int[][] Ver, int[][] Hor, int V, int H){
        int ctr = 0;
        for(int i=0;i<V;i++){
            for(int j=0;j<H;j++){
                if(Hor[j][0] >= Ver[i][1] && Hor[j][0] <= Ver[i][2]){
                    if(Ver[i][0] >= Hor[j][1] && Ver[i][0] <= Hor[j][2]) ctr++;
                }
            }
        }
        return ctr;
    }

    public static void main(String[] args){
        String[] inp = sc.nextLine().split(" ");
        int V = Integer.parseInt(inp[0]);
        int[][] Vert = new int[V][3];
        int H = Integer.parseInt(inp[1]);
        int[][] Hor = new int[H][3];
        for(int i=0;i<V;i++){
            String[] co = sc.nextLine().split(" ");
            Vert[i][0] = Integer.parseInt(co[0]);
            Vert[i][1] = Integer.parseInt(co[1]);
            Vert[i][2] = Integer.parseInt(co[2]);
        }
        for(int i=0;i<H;i++){
            String[] co = sc.nextLine().split(" ");
            Hor[i][0] = Integer.parseInt(co[0]);
            Hor[i][1] = Integer.parseInt(co[1]);
            Hor[i][2] = Integer.parseInt(co[2]);
        }
        System.out.println(countIntersections(Vert,Hor,V,H));
    }
}

/*
Sample Input: 
2 2
25 25 80
75 25 80
25 25 80
75 25 80
--
1 2
50 0 100
50 0 75
50 25 100
/*