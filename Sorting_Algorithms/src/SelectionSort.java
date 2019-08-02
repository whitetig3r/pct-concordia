package sorting;

class SelectionSort {
	int[] selectionSortIterative(int[] arr){
		int n = arr.length;
		for(int i=0;i<n;i++){
			for(int j=i;j<n;j++){
				if(arr[i]>arr[j]){
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		return arr;
	}
	
	int[] selectionSortRecursive(int[] arr, int st){
		if(st == arr.length-1) return arr;
		for(int i=st;i<arr.length;i++){
			if(arr[i]<arr[st]){
				int temp = arr[i];
				arr[i]=arr[st];
				arr[st]=temp;
			}
		}
		return selectionSortRecursive(arr,st+1);
	}
}
