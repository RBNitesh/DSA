package Array;

import java.util.Scanner;

class Pascal{
    public Pascal(int n) {
        int[][] arr = new int[n][n];
           for(int i=0; i<n; i++){
              for(int j=0; j<=i; j++){
                if(j==0 || j==i){
                arr[i][j]=1;
                System.out.print(arr[i][j]+" ");
               }else{
                arr[i][j]=arr[i-1][j-1] + arr[i-1][j];
                System.out.print(arr[i][j]+" ");
               }
            }
            System.out.println();
        }
    }
}

    public class PascalTriangle {
        public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            System.out.print("Enter the number of row in pascal triangle:");
            int n=sc.nextInt();
            Pascal pascal=new Pascal(n);
    }
    
}
