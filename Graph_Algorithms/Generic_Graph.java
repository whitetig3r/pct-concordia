import java.util.*;
import java.lang.*;
import java.util.LinkedList; 
import java.util.ListIterator; 

public class Generic_Graph<T> {
    private Map<T,List<T>> graph = new HashMap<>();
    public void addVertex(T v){
        graph.put(v,new LinkedList<T>());
    }
    public void addEdge(T s,T d, boolean birectional){
        if(!graph.keySet().contains(s)) graph.put(s,new LinkedList<>());
        if(!graph.keySet().contains(d)) graph.put(d,new LinkedList<>());
        if(birectional){
            graph.get(s).add(d);
            graph.get(d).add(s);
        } else {
            graph.get(s).add(d);
        }
    }
    public void printGraph(Generic_Graph<T> graphInstance){
        System.out.println("Printing the adjacency List:");
        for(T v:graph.keySet()){
            System.out.print(v.toString());
            for(T inner_v:graph.get(v)){
                System.out.print(" => "+inner_v);
            }
            System.out.print("\n");
        }
    }
    public void DFS_utility(Generic_Graph<T> myGraph, boolean[] visited, int v){
        visited[v] = true;
        System.out.print(v+" ");
        ListIterator<T> i = myGraph.graph.get(v).listIterator();
        while(i.hasNext()){
            Integer nextIndex = (Integer)i.next();
            if(!visited[nextIndex]){
                DFS_utility(myGraph,visited,nextIndex);
            }
        }
    }
    public void DFS(Generic_Graph<T> graphInstance, int v){
        System.out.println("A sample DFS:");
        int n = graphInstance.graph.size();
        boolean[] visited = new boolean[n+1];
        DFS_utility(graphInstance,visited,v);
        System.out.println("");
    }

    public void BFS(Generic_Graph<T> myGraph, int v){
        System.out.println("A sample BFS:");
        boolean visited[] = new boolean[myGraph.graph.size()+1];
        LinkedList<Integer> q = new LinkedList<Integer>();
        visited[v] = true;
        q.add(v);
        while(q.size()!=0){
            v = q.poll();
            System.out.print(v+" ");
            ListIterator<T> i = myGraph.graph.get(v).listIterator();
            while(i.hasNext()){
                Integer nextVertex = (Integer)i.next();
                if(!visited[nextVertex]){
                    visited[nextVertex] = true;
                    q.add(nextVertex);
                }
            }
        }
        System.out.println("");
    }
    public static void main(String[] args){
        Generic_Graph<Integer> myGraph = new Generic_Graph<Integer>();
        myGraph.addEdge(1,2,true);
        myGraph.addEdge(1,4,true);
        myGraph.addEdge(2,3,true);
        myGraph.addEdge(3,1,true);
        myGraph.printGraph(myGraph);
        myGraph.DFS(myGraph,2); // second arg - starting vertex for DFS
        myGraph.BFS(myGraph,1); // second arg - starting vertex for BFS
    }
}