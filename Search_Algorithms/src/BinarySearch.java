package searching;

class BinarySearch {
    int binarySearchIterative(int[] arr, int search){
        int l = 0, r = arr.length-1;
        while(l <= r){
            int middle = l+(r-l)/2;
            if(arr[middle] == search) return middle;
            else if(arr[middle] < search) {
                l = middle + 1;
            } else{
                r = middle - 1;
            }
        }
        return -1;
    }

    int binarySearchRecursive(int[] arr, int search, int l, int r){
        if(l <= r){
            int middle = l + (r-l)/2;
            if(arr[middle]==search) return middle;
            else if(arr[middle]<search) return binarySearchRecursive(arr,search,middle+1,r);
            else return binarySearchRecursive(arr,search,l,middle-1);
        }
        return -1;
    }
}