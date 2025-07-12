import java.util.Scanner;

public class FindtLastRepeatingElement {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        int size=sc.nextInt();
        int arr[]=new int[size];
        if(size>0){
            System.out.print("Enter the element: ");
            for(int i=0; i<size; i++){
                arr[i]=sc.nextInt();
            }
        }else if(size==0){
            System.out.println("empty array.");
        }else{
            System.out.println("Invalid array size!");
        }
        int ans=-1;
        for(int j=0; j<size; j++){
            for(int k=j+1; k<size; k++){
                if(arr[j]==arr[k]){
                ans=arr[j]; 
            }
        }
    } System.out.print("Last repeating element: "+ans);
  }
}
