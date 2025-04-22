package Array;
import java.util.Scanner;

public class Unique{
    public static void main(String[] args) {
        int [] arr={ 2,4,2,4,5,7,5};
        Scanner sc=new Scanner(System.in);
        
        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                if(arr[i]==arr[j]){
                   arr[i]=-1;
                   arr[j]=-1;
                }
            }
        }
        for(int i=0; i<arr.length; i++){
            if(arr[i]!=-1){
               System.out.print("unique element in array is: "+arr[i]);
            }
        }
        
    }
}