package Array;

import java.util.Scanner;

public class countOccurence {
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        int N=sc.nextInt();
        int [] arr=new int[N];
        System.out.println("Enter the element of the array: ");
        for(int i=0; i<N; i++)
        {
             arr[i]=sc.nextInt();
        }
        System.out.print("Enter the number to find their occurence: ");
        int num=sc.nextInt();
        int count = 0;
        int lastIndex=-1;  
        for(int j=0; j<N; j++)
        {
           if(arr[j]==num)
           {
            count+=1;
            lastIndex=j;
           }
        } 
        System.out.println("last occurence of "+num+ " is: "+lastIndex); 
        System.out.println("number of "+num+" present in array is: "+count);
    }
   
}
