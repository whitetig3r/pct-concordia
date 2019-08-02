package sorting;

class BubbleSort {
	int[] bubbleSortIterative(int[] arr){
		int n = arr.length;
		for(int i=0; i<n;i++){
			for(int j=0; j<n-i-1;j++){
				if(arr[j]>arr[j+1]){
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				} 
			}
		}	
		return arr;		
	}

	int[] bubbleSortRecursive(int[] arr,int n){
		if(n==1) return arr;
		for(int i=0;i<n-1;i++){
			if(arr[i]>arr[i+1]){
				int temp = arr[i];
				arr[i] = arr[i+1];
				arr[i+1] = temp;	
			}
		}
		return bubbleSortRecursive(arr,n-1);	
	}

} 
