package Array;
import java.util.Scanner;

public class SecondSmallest {
    public static void main(String[] args) {
        int arr[]={ 1,2,3,4,9,6,5,7};
        Scanner sc=new Scanner(System.in);
        int min=Integer.MAX_VALUE;
        int SecondMin=Integer.MAX_VALUE;
        for(int i=0; i<arr.length; i++){
            if (arr[i]<min){
                min=arr[i];
            }
        }
        for(int j=0; j<arr.length; j++){
            if(arr[j]<SecondMin && arr[j]>min){
                SecondMin=arr[j];
            }
        }
        System.out.print("second smallest element: "+SecondMin);
           
    }
}
