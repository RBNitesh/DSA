package Array;
import java.util.Scanner;

public class FindSecondlargest {
    public static void main(String[] args) {
        int arr[]={ 1,2,3,4,9,6,5,7};
        Scanner sc=new Scanner(System.in);
        int max=Integer.MIN_VALUE;
        int SecondMax=Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            if (arr[i]>max){
                max=arr[i];
            }
        }
        for(int j=0; j<arr.length; j++){
            if(arr[j]>SecondMax && arr[j]<max){
                SecondMax=arr[j];
            }
        }
        System.out.println(SecondMax);
           
    }
}
