package Sorting;

public class RadixSort {
    static void display(int[] arr){
        for(int val:arr){
            System.out.print(val+" ");
        }
        System.out.println();
    }
    
    static int findMax(int[] arr){
        int max=arr[0];
        for(int i=0; i<arr.length; i++){
            if(arr[i]>max) max=arr[i];
        }
        return max;
    }

    static void CSort(int[] arr, int palace){

        int[] freq=new int[10];
        for(int i=0; i<arr.length; i++){
            freq[(arr[i]/palace)%10]++;
        }

        for(int i=1; i<freq.length; i++){
            freq[i]+=freq[i-1];
        }
        
        int[] res=new int[arr.length];
        for(int i=arr.length-1; i>=0; i--){
        int idx=freq[(arr[i]/palace)%10]-1;
        res[idx]=arr[i];
        freq[(arr[i]/palace)%10]--;
        }
        for(int i=0; i<arr.length; i++){
            arr[i]=res[i];
        }
    }
    
    static void RSort(int[] arr, int n){
        int max=findMax(arr);
        for(int palace=1; max/palace>0; palace*=10){
            CSort(arr, palace);
        }
    }
    public static void main(String[] args) {
        int[] arr={2,524,46,7,2,145,3,47};
        
        RSort(arr,arr.length);
        display(arr);
    }
}
