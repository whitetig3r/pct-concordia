import java.util.*;
import java.lang.*;

public class PCT_Example_3{
    static Scanner s = new Scanner(System.in);
    private Map<String,List<String>> family = new HashMap<>();
    private ArrayList<String> entireFamily = new ArrayList<String>();
    private ArrayList<String> relships = new ArrayList<String>();

    private void insertInTree(String parent, String child){
        if(!this.family.keySet().contains(parent)){
            this.family.put(parent,new LinkedList<String>());
        }    
        this.family.get(parent).add(child);
    }

    private void DFS(String root){
        System.out.print(root+" ");
        if(this.family.keySet().contains(root)){
            ListIterator<String> i = this.family.get(root).listIterator();
            while(i.hasNext()){
                this.DFS(i.next());
            }
        }
    }
    private boolean checkAncestor(String p1, String p2){
        if(this.family.keySet().contains(p1)){
            if(this.family.get(p1).contains(p2)) return true;
            for(String child:this.family.get(p1)){
                if(checkAncestor(child,p2)){
                    return true;
                }
            }
        }
        return false;
    }
    private void checkRelationship(String p1, String rel, String p2){
        boolean flagged = false;
        switch(rel){
            case "child":{
                if(this.family.keySet().contains(p2)){
                    ListIterator<String> i = this.family.get(p2).listIterator();
                    while(i.hasNext()){
                        if(p1.equals(i.next())) {
                            System.out.print("T" + " ");
                            flagged = true;
                            break;
                        }
                    }
                }
                if(!flagged) System.out.print("F"+" ");
                break;
            }
            case "parent":{
                if(this.family.keySet().contains(p1)){
                    ListIterator<String> i = this.family.get(p1).listIterator();
                    while(i.hasNext()){
                        if(p2.equals(i.next())) {
                            System.out.print("T" + " ");
                            flagged = true;
                            break;
                        }
                    }
                }
                if(!flagged) System.out.print("F"+" ");
                break;
            }
            case "sibling":{
                for(String parent:this.family.keySet()){
                    if(this.family.get(parent).contains(p1) && this.family.get(parent).contains(p2)){
                        System.out.print("T"+" ");
                        flagged = true;
                        break;
                    }
                }
                if(!flagged) System.out.print("F"+" ");
                break;
            }
            case "ancestor":{
                if(this.family.keySet().contains(p1)){
                    if(this.family.get(p1).contains(p2)) System.out.print("T"+" ");
                    else {
                        if(this.checkAncestor(p1,p2)) System.out.print("T" + " ");
                        else System.out.print("F"+" ");
                    }
                } else{
                    System.out.print("F"+" ");
                } 
                break;
            }
            case "descendant":{
                if(this.family.keySet().contains(p2)){
                    if(this.family.get(p2).contains(p1)) System.out.print("T"+" ");
                    else {
                        if(this.checkAncestor(p2,p1)) System.out.print("T" + " ");
                        else System.out.print("F"+" ");
                    }
                } else{
                    System.out.print("F"+" ");
                }
                break;
            }
        }
    }

    public void printGraph(){
        for(String v:this.family.keySet()){
            System.out.print(v);
            for(String inner_v:this.family.get(v)){
                System.out.print(" => "+inner_v);
            }
            System.out.print("\n");
        }
    }
    public static void main(String[] args){
        int n = Integer.parseInt(s.nextLine());
        String root = "";
        PCT_Example_3 FamilyTree = new PCT_Example_3();
        for(int i=0;i<n;i++) {
            String famString = s.nextLine();
            FamilyTree.entireFamily.add(famString);
            if(i == 0) root += famString.split(" ")[0];
        }
        int m = Integer.parseInt(s.nextLine());
        for(int i=0;i<m;i++){
            String relString = s.nextLine();
            FamilyTree.relships.add(relString);
        }
        for(String relship:FamilyTree.entireFamily){
            String[] relArr = relship.split(" ");
            FamilyTree.insertInTree(relArr[0],relArr[1]);
        }
        for(String rel:FamilyTree.relships){
            String[] splitted = rel.split(" ");
            FamilyTree.checkRelationship(splitted[0],splitted[1],splitted[2]);
        }
        System.out.println("");
        // FamilyTree.printGraph(); // TO TEST THE ADJACENCY LIST
        FamilyTree.DFS(root); // DFS ON GRAPH == PRE-ORDER TRAVERSAL 
        System.out.println("");
    }
}

/*
8
Motilal Jawahar
Jawahar Indira
Motilal Kamala
Indira Sanjay
Sanjay Varun
Indira Rajiv
Rajiv Priyanka
Rajiv Rahul
6
Motilal child Jawahar
Varun descendant Indira
Priyanka sibling Varun
Sanjay child Indira
Sanjay ancestor Varun
Kamala ancestor Rahul

------
9 
Prithviraj Raj 
Shashi Sanjana 
Prithviraj Shashi 
Raj Randhir
Rishi Ranveer 
Randhir Bebo 
Randhir Lolo 
Raj Rishi 
Rishi Ridhima 
7 
Bebo descendant Shashi 
Raj sibling Shashi 
Prithviraj ancestor Ridhima 
Lolo sibling Ridhima 
Bebo ancestor Shashi 
Prithviraj ancestor Raj 
Rishi descendant Raj
*/