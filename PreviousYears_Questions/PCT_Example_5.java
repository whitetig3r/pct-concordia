import java.util.*;
import java.lang.*;

public class PCT_Example_5 {
    static Stack<Character> paren_stack = new Stack<Character>();
    static Scanner sc = new Scanner(System.in);
    static final char[] blackList_open = new char[]{'[','{','('};
    static final char[] blackList_close = new char[]{']','}',')'};
    
    private static boolean open_search(char c){
        for(char ch:blackList_open){
            Character cast_ch = new Character(ch);
            if(cast_ch.equals(c)) return true;
        }
        return false;
    }

    private static boolean close_search(char c){
        for(char ch:blackList_close){
            Character cast_ch = new Character(ch);
            if(cast_ch.equals(c)) return true;
        }
        return false;
    }

    public static void main(String[] args){
        String inp = sc.nextLine();

        for(int i=0;i<inp.length();i++){
            Character curr = new Character(inp.charAt(i));
            Character top = new Character(' ');
            Character top_inv = new Character(' ');
            if(!paren_stack.empty()){
                top = paren_stack.peek();
                switch(top){
                    case '{':{
                        top_inv = new Character('}');
                        break;
                    }
                    case '(':{
                        top_inv = new Character(')');
                        break;
                    }
                    case '[':{
                        top_inv = new Character(']');
                        break;
                    }
                }
            }
            if(open_search(curr)){
                paren_stack.push(curr);
            }
            else if(close_search(curr)){
                if(curr.equals(top_inv)) paren_stack.pop();
            }
            else continue;
        }
        if(paren_stack.empty()) System.out.println("T");
        else System.out.println("F");
    }
}

// Sample Input:
// ([{this is invalid]})
// ([{this is valid}]) 