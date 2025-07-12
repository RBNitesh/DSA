package Array;

import java.util.Scanner;

public class RectangleSum {

    static void printMatrix(int [][]A, int r, int c){
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                System.out.print(A[i][j]+" ");
            }
            System.out.println();
        }
    }
     
    //Brute Force Approach

    // static void RectangleSum1(int[][] A, int r1, int c1, int r2, int c2){
    //     int Sum=0;
    //     for(int i=r1; i<=r2; i++){
    //         for(int j=c1; j<=c2; j++){
    //             Sum+=A[i][j];
    //         }
    //     }
    //     System.out.print("Sum is = "+Sum);
    // }

    //Prefix Sum Approach

    static void RectangleSum2(int[] RowSum, int r1, int c1, int r2, int c2){
            int Sum=0;
            for(int i=r1; i<=r2; i++){
                Sum+=RowSum[i];
            }
            System.out.print("Sum is = "+Sum);
        }
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the no of row in A:");
    int r=sc.nextInt();
    System.out.print("Enter the no of column in A:");
    int c=sc.nextInt();
    int[][] A=new int[r][c];
    System.out.println("Enter the element of A:");

    for(int i=0; i<r; i++){
        for(int j=0; j<c; j++){
            A[i][j]=sc.nextInt();
        }
    }

    System.out.println("Original Matrix:");
    printMatrix(A, r, c);


    System.out.print("Enter r1 , c1, r2, c2: ");
    int r1=sc.nextInt();
    int c1=sc.nextInt();
    int r2=sc.nextInt();
    int c2=sc.nextInt();
    // RectangleSum1(A, r1, c1, r2, c2);//Brute force approach

    int[] RowSum=new int[r];
    for(int i=r1; i<=r2; i++) {
        int Sum=0;
        for(int j=c1; j<=c2; j++){
            Sum+=A[i][j];
        }
        RowSum[i]=Sum;
      }

    RectangleSum2(RowSum, r1, c1, r2, c2);//prefixSum approach
    }
}
