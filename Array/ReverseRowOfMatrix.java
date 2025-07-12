package Array;

import java.util.Scanner;

public class ReverseRowOfMatrix{
    static void printMatrix(int[][] A, int r, int c){
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                System.out.print(A[i][j]+" ");
            }
            System.out.println();
        }
    }
    
    static void ReverseRowOfMatrix(int[][] A, int r1, int c1){
        for(int i=0; i<r1; i++){
            int left=0;
            int right=c1-1;
           while(left < right){
              int temp=A[i][left];
              A[i][left]=A[i][right];
              A[i][right]=temp;
              left++;
              right--;
           } 
        }
    }
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the no of row in A:");
    int r1=sc.nextInt();
    System.out.print("Enter the no of column in A:");
    int c1=sc.nextInt();
    int[][] A=new int[r1][c1];
    System.out.println("Enter the element of A:");

    for(int i=0; i<r1; i++){
        for(int j=0; j<c1; j++){
            A[i][j]=sc.nextInt();
        }
    }
    System.out.println("Original Matrix:");
    printMatrix(A, r1, c1);
    ReverseRowOfMatrix(A, r1, c1);
    System.out.println("Matrix after reversing the row:");
    printMatrix(A, r1, c1);
}
}