import java.util.Scanner;
public class Demo{
    public static void main(String[] args){
        int[] arr={10,20,1,3,-40,80,10};
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        int i=0, j=n-1, sum=0;
        int maxSum=Integer.MIN_VALUE;

        for(int a=0; a<=j; a++){
            sum+=arr[a];
            maxSum=Math.max(maxSum,sum);
        }
        i++; j++;
        while(j < arr.length){
            sum=sum+arr[j]-arr[i-1];
            maxSum=Math.max(maxSum,sum);
            i++; j++;
        }

        System.out.println(maxSum);
    }
}