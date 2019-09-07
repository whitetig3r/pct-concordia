import java.util.*;
import java.lang.*;

// GAME OF LIFE QUESTION
public class PCT_Example_7 {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<String> rowList = new ArrayList<>();

    static int[][] constructCounterMatrix(int r, int c){
        Iterator<String> i = rowList.iterator();
        int ctr_r = 0;
        int ctr_c = 0;
        int[][] matrix= new int[r][c];
        while(i.hasNext()){
            String rowStr = i.next();
            while(ctr_c < c){
                matrix[ctr_r][ctr_c] = rowStr.charAt(ctr_c) == '#' ? 0:1;
                ctr_c++;
            }
            ctr_c = 0;
            ctr_r++;
        }    
        return matrix;
    }

    private static String calcLiving(int gen, int[][] matrix,int r, int c) {
        int[][][] gen_matrix = new int[gen+1][r][c];
        gen_matrix[0] = matrix;
        int i = 0;
        int gen_ctr = 0;
        while(gen_ctr<gen){
            for(int m=0;m<r;m++){
                for(int n=0;n<c;n++){
                    int ctr = 0;
                    for(int a=-1;a<=1;a++){
                        if(m+a<0 || m+a>r-1) continue;
                        for(int b=-1;b<=1;b++){
                            if(n+b<0 || n+b>c-1) continue;
                            if(a==0 && b==0) continue;
                            ctr += gen_matrix[gen_ctr][m+a][n+b];
                        }
                    }
                    //System.out.println("Value of ctr: --- "+ctr+" - "+Integer.toString(m)+" "+Integer.toString(n));
                    if(gen_matrix[gen_ctr][m][n] == 1){
                        switch(ctr){
                            case 0:
                            case 1:{
                                gen_matrix[gen_ctr+1][m][n] = 0;
                                break;
                            }
                            case 2:
                            case 3: {
                                gen_matrix[gen_ctr+1][m][n] = 1;
                                break;
                            }
                            default: {
                                gen_matrix[gen_ctr+1][m][n] = 0;
                            }
                        }
                    } else {
                        if(ctr == 3){
                            gen_matrix[gen_ctr+1][m][n] = 1;
                        }
                    }
                }
            }
            gen_ctr++;
        }

        int tot = 0;
        for(int w=0;w<r;w++){
            for(int x=0;x<c;x++){
                tot += gen_matrix[gen][w][x];
            }
        }
        return Integer.toString(tot);
    }

    public static void main(String[] args){
        String unsplit_str;
        unsplit_str = sc.nextLine();
        String[] unsplit_list = unsplit_str.split(" ");
        int r = Integer.parseInt(unsplit_list[0]);
        int c = Integer.parseInt(unsplit_list[1]);
        for(int i=0;i<r;i++){
            rowList.add(sc.nextLine());
        }
        int[][] matrix = constructCounterMatrix(r,c);
        int gen = Integer.parseInt(sc.nextLine());
        System.out.println(calcLiving(gen,matrix,r,c));
    }
}