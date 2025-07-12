package Sorting;

public class lexicographicalOrder{
    static String[] SSort(String[] arr, int n){
        for(int i=0;i<n-1;i++){
            int min_index=i;

            for(int j=i+1;j<n;j++){
                if(arr[j].compareTo(arr[min_index]) < 0){
                   min_index=j;
                }
            }

            if(min_index!=i){
                String temp=arr[i];
                arr[i]=arr[min_index];
                arr[min_index]=temp;
            }
        }
        return arr;
    }
public static void main(String[] args) {
    String[] arr={"papaya","lime","watermelon","kiwi","apple","mango"};
    String[] ans=SSort(arr ,arr.length);

    for(int i=0; i<ans.length;i++){
        System.out.print(ans[i]+" ");
    }
 }
}

