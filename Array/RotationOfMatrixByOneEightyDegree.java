package Array;

import java.util.Scanner;

public class RotationOfMatrixByOneEightyDegree {
    static void printMatrix(int[][] A, int r, int c){
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                System.out.print(A[i][j]+" ");
            }
            System.out.println();
        }
    }

    static void reverse(int[] arr){
        int left=0;
        int right=arr.length-1;

        while(left < right){
            int temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
            left++;
            right--;
        }
    }

    static void reverseRowOfMatrix(int[][] A, int r, int c){
          for(int i=0; i<r; i++){
            reverse(A[i]);
          }
    }

    static void TransposeMatrix(int[][] A, int r1, int c1){
        for(int i=0; i<c1; i++){
            for(int j=0; j<r1; j++){
              if(i < j){
                int temp=A[i][j];
                A[i][j]=A[j][i];
                A[j][i]=temp;
              }
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
    TransposeMatrix(A, r1, c1);
    reverseRowOfMatrix(A, r1, c1);
    System.out.println("Matrix after ninety degree rotation:");
    printMatrix(A, r1, c1);
    TransposeMatrix(A, r1, c1);
    reverseRowOfMatrix(A, r1, c1);
    System.out.println("Matrix after one eighty degree rotation:");
    printMatrix(A, r1, c1);
}
}
