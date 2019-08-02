package sorting;
import java.util.Scanner;

public class Sort {
    public static void main(String[] args){
        Scanner s1 = new Scanner(System.in);
		// BubbleSort bubbleSort = new BubbleSort();
		SelectionSort selectionSort = new SelectionSort();

		System.out.println("How many numbers?");

		int n = s1.nextInt();
		int[] arr = new int[n];

		for(int i=0; i<n; i++){
			arr[i] = s1.nextInt();
		}

		int[] arr_cpy;

	 	// arr_cpy = bubbleSort.bubbleSortIterative(arr);
		// arr_cpy = selectionSort.selectionSortIterative(arr);
		// arr_cpy = bubbleSort.bubbleSortRecursive(arr,n);
		arr_cpy = selectionSort.selectionSortRecursive(arr,0);

		for(int x:arr_cpy) System.out.println(x);
    }
}