import java.util.*;
import java.lang.*;

public class Topological_Sort {
    static Map<Integer,List<Integer>> graph = new HashMap<>();
    static Stack<Integer> st = new Stack<>();

    static void addVertex(Integer vertex){
        if(!graph.containsKey(vertex)) graph.put(vertex, new LinkedList<>());
    }

    static void addEdge(Integer s, Integer d){
        if(!graph.containsKey(s)){
            graph.put(s,new LinkedList<>());
        }
        graph.get(s).add(d);
    }
    
    static void printAdjacencyList() {
        for(Integer v:graph.keySet()){
            System.out.print(v+" -> ");
            ListIterator<Integer> i = graph.get(v).listIterator();
            while(i.hasNext()){
                System.out.print(i.next() + " ");
            }
            System.out.print("\n");
        }
    }

    static void topologicalSortUtil(Integer start, boolean[] visited){
        if(graph.containsKey(start) && !visited[start]){
            visited[start] = true;
            ListIterator<Integer> i = graph.get(start).listIterator();
            while(i.hasNext()){
                topologicalSortUtil(i.next(),visited);
            }
            st.push(start);
        } else {
            if(!st.contains(start)) st.push(start);
        }
    }

    static void topologicalSort(Integer start, boolean[] visited){
        Set<Integer> s = new HashSet<>();

        for(Integer v:graph.keySet()){
            for(Integer j:graph.get(v)) {
                s.add(j);
            }
            s.add(v);
        }

        topologicalSortUtil(start,visited);
        for(Integer v:s){
            topologicalSortUtil(v,visited);
        }
    }

    public static void main(String[] args){
        addEdge(5,2);
        addEdge(5,0);
        addEdge(4,0);
        addEdge(4,1);
        addEdge(2,3);
        addEdge(3,1);
        boolean[] visited = new boolean[6];
        Arrays.fill(visited, false);
        printAdjacencyList();
        topologicalSort(0, visited);
        System.out.println("Sample Topological sort:-");
        while(!st.empty()){
            System.out.print(st.pop()+" ");
        }
        System.out.print("\n");
    }
}