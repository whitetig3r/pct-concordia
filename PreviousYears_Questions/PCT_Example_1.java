import java.util.Scanner;
public class PCT_Example_1 {
    public static void main(String args[]) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i]=sc.nextInt();
        }
        //iterate over hashTable
        boolean[] hasher = new boolean[n];
        for(int k=0;k<n;k++){
            hasher[k] = false;
        }
        System.out.println("------------------");
        for(int i=0;i<n;i++){
            // CASE 1: No hash made at that index
            if(!hasher[arr[i]%n]){
                System.out.printf("%d \n",arr[i]%n);
                hasher[arr[i]%n] = true;   
            } else {
                // CASE 2: Hash already exists so follow alt. algorithm
                int val = arr[i];
                boolean direction = true;
                boolean breaker = false;
                boolean first_time = true;
                int last_index = -1;
                int probable_last_loc = -1;
                System.out.printf("%d",val%n);
                while(val>0){
                    int extractedDigit = val%10;
                    int modulus = (val/10)%n;
                    int ref_of_index = first_time ? val%n : last_index;
                    first_time = first_time ? !first_time:first_time;
                    // if extracted digit is ODD
                    if(extractedDigit%2 != 0) {
                        int index_to_place = (ref_of_index + modulus)%n;
                        probable_last_loc = index_to_place;
                        direction = true;
                        if(!hasher[index_to_place]){
                            System.out.printf(" %d\n",index_to_place);
                            hasher[index_to_place] = true;
                            breaker = true;
                            break;
                        } else{
                            System.out.printf(" %d",index_to_place);
                        }
                    }
                    else{
                        // if extracted digit is EVEN
                        int index_to_place = (ref_of_index - modulus) >= 0 ? (ref_of_index - modulus) 
                            : (ref_of_index + (modulus - ref_of_index));
                        probable_last_loc = index_to_place;
                        direction = false;
                        if(!hasher[index_to_place]){
                            System.out.printf(" %d\n",index_to_place);
                            hasher[index_to_place] = true;
                            breaker = true;
                            break;
                        } else{
                            System.out.printf(" %d",index_to_place);
                        }
                    }
                    last_index = extractedDigit%n; // to prevent ArrayIndex OutOfBounds
                    val = val/10;
                }
                // Continuing once it hits zero in last moved direction, sequentially
                if(!breaker){
                    int ctr = 0;
                    while(ctr <= n){
                        if(direction){
                            if(!hasher[(probable_last_loc + 1)%n]){
                                hasher[(probable_last_loc + 1)%n] = true;
                                System.out.printf(" %d\n",(probable_last_loc+1)%n);
                                break;
                            } else {
                                if(ctr>0) System.out.printf(" %d",probable_last_loc);
                                probable_last_loc = (probable_last_loc + 1)%n;
                            }
                        } else {
                            if(probable_last_loc-1 < 0){
                                probable_last_loc = n-1;
                            } else {
                                if(ctr>0) System.out.printf(" %d",probable_last_loc);
                                probable_last_loc--;
                            }
                            if(!hasher[probable_last_loc]){
                                hasher[probable_last_loc] = true;
                                System.out.printf(" %d\n",probable_last_loc);
                                break;
                            }
                        }
                        ctr++;
                    }
                }
            }
        }
    }
}