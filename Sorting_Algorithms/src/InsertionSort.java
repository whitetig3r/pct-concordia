package sorting;

class InsertionSort {
	int[] insertionSortIterative(int[] arr){
		int n = arr.length;
		for(int i=1;i<n;i++){ 
            int j = i-1; 
            int toInsert = arr[i];
            while(j>=0 && arr[j]>toInsert){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1]=toInsert; // to undo the last auto-decrement and insert at correct position
		}
		return arr;
	}
	
	int[] insertionSortRecursive(int[] arr, int n){
        if(n<=1) return arr;
        insertionSortRecursive(arr, n-1);
        int toInsert = arr[n-1];
        int j = n-2;
        while(j>=0 && arr[j]>toInsert){
            arr[j+1] = arr[j];
            j--;
        }
        arr[j+1] = toInsert; // to undo the last auto-decrement and insert at correct position
        return arr;
    }
}
