package searching;
import java.util.Scanner;
import java.util.Arrays;

public class Search {
    public static void main(String[] args){
        Scanner s1 = new Scanner(System.in);
        LinearSearch linearSearch = new LinearSearch();
        BinarySearch binarySearch = new BinarySearch();

		System.out.println("How many numbers?");

		int n = s1.nextInt();
		int[] arr = new int[n];

		for(int i=0; i<n; i++){
			arr[i] = s1.nextInt();
		}
        System.out.println("What number to search?");
        int search = s1.nextInt();
        
		// int index = linearSearch.linearSearchRecursive(arr,search,n); 
        // int index = linearSearch.linearSearchIterative(arr,search); 
        Arrays.sort(arr);
        System.out.println("Your array is sorted: ");
        for(int x:arr) System.out.printf("%d ",x);
        int index = binarySearch.binarySearchIterative(arr,search);
        //int index = binarySearch.binarySearchRecursive(arr,search,0,n);
        System.out.println("\nFound at index: " + index);
    }
}