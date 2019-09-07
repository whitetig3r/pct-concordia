import java.util.*;
import java.lang.*;

public class PCT_Example_6 {
    private static Map<String,List<String>> res_graph = new HashMap<>();
    private static ArrayList<String> inp_list = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    private static void makeResourceGraph(){
        Iterator<String> i = inp_list.listIterator();
        while(i.hasNext()){
            String[] splitted = i.next().split(" ");
            // est. the resource owned to process
            if(!splitted[1].equals("-1")){
                if(!res_graph.keySet().contains(splitted[1])){
                    res_graph.put(splitted[1],new LinkedList<String>());
                } 
                res_graph.get(splitted[1]).add(splitted[0]);
            }
            // est. the resource wanted to process
            if(!splitted[2].equals("-1")){
                if(!res_graph.keySet().contains(splitted[0])){
                    res_graph.put(splitted[0],new LinkedList<String>());
                }
                res_graph.get(splitted[0]).add(splitted[2]);
            }
        }
    }
    private static boolean isCyclic(String V,ArrayList<Boolean> visited, Stack<String> rec){
        if(rec.contains(V)) return true;
        if(visited.contains(V)) return false;

        visited.add(true);
        rec.push(V);

        if(res_graph.keySet().contains(V)){
            Iterator<String> i = res_graph.get(V).listIterator();
            while(i.hasNext()){
                if(isCyclic(i.next(),visited,rec)) return true;
            }
        }

        rec.pop();
        return false;
    }
    private static boolean detectDeadlock(){
        ArrayList<Boolean> visited = new ArrayList<>();
        Stack<String> rec = new Stack<>();

        for(String V:res_graph.keySet()){
            if(isCyclic(V,visited,rec)) return true;
        }
        return false;
    }

    public static void main(String[] args){
        int n = Integer.parseInt(sc.nextLine());
        for(int i=0;i<n;i++) {
            inp_list.add(sc.nextLine());
        }
        makeResourceGraph();
        if(detectDeadlock()) System.out.println("YES");
        else System.out.println("NO");
    }
}

/*
SAMPLE INPUT:
5 
101 7 8
101 9 -1
102 -1 7 
102 8 -1 
103 -1 9
*/