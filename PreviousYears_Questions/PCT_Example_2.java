import java.util.*;
import java.lang.*;

public class PCT_Example_2 {
    static Scanner s = new Scanner(System.in);

    public static boolean checkContains(char lastChar){
        final char[] whiteList = new char[]{'a','e','i','o','u','A','E','I','O','U'};
        for(char c:whiteList){
            if(c == lastChar){
                return true;
            }
        }
        return false;
    }

    public static void reorderName(String name){
        String[] nameArray = name.split(" ");
        int lengthOfName = nameArray.length;
        String finalName = "";
        switch(lengthOfName){
            case 1:{
                finalName += nameArray[0];
                break;
            }
            case 2:{
                char lastChar = nameArray[1].charAt(nameArray[1].length()-1);
                if(checkContains(lastChar)){
                    finalName += nameArray[1] + " " + nameArray[0];
                } 
                else {
                    finalName += nameArray[0] + " " + nameArray[1];
                }
                break;
            }
            case 3: {
                finalName += nameArray[2] + " " + nameArray[0] + " " + nameArray[1];
                break;
            }
        }
        System.out.println(finalName);
    }

    public static void main(String[] args){
        while(s.hasNext()){
            String name = s.nextLine();
            reorderName(name);
        }
    }
    
}