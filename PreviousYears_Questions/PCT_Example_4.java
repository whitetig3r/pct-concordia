import java.util.*;
import java.lang.*;

public class PCT_Example_4 {
    static Scanner sc = new Scanner(System.in);
    static Set<String> unique_list = new HashSet<String>();
    public static void main(String[] args){
        String str = sc.nextLine();
        String[] split_list = str.split("\\W+");
        for(String s:split_list){
            s = s.toLowerCase();
            unique_list.add(s);
        }
        System.out.println(Integer.toString(unique_list.size()));
    }
}

// Sample Inputs
// Prithviraj Dajisaheb Chavan
// ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789
// Prithviraj D Chavan Output chavan PrithviraJ d Input  Barack Obama InputOutput Output