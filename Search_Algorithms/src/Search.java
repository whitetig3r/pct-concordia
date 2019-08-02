package searching;
import java.util.Scanner;

public class Search {
    public static void main(String[] args){
        Scanner s1 = new Scanner(System.in);
        LinearSearch linearSearch = new LinearSearch();

		System.out.println("How many numbers?");

		int n = s1.nextInt();
		int[] arr = new int[n];

		for(int i=0; i<n; i++){
			arr[i] = s1.nextInt();
		}
        System.out.println("What number to search?");
        int search = s1.nextInt();
		int index = linearSearch.linearSearchRecursive(arr,search,n); 
        // int index = linearSearch.linearSearchIterative(arr,search); 
        System.out.println("Found at index: " + index);
    }
}