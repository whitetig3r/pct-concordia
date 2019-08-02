package searching;

class LinearSearch {
    int linearSearchIterative(int[] arr, int search){
        for(int i=0;i<arr.length;i++){
            if(arr[i] == search) return i;
        }
        return -1;
    }

    int linearSearchRecursive(int[] arr, int search, int n){
        if(n<0) return -1;
        if(arr[n-1] == search) return n-1;
        return linearSearchRecursive(arr,search,n-1);
    }
}