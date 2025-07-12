package Array;

import java.util.Scanner;

public class MAtrixMultiplication {
    void printMatrix(int[][] arr, int r1, int c1){
        for(int i=0; i<r1; i++){
            for(int j=0; j<c1; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    void Multi(int[][] A,int r1,int c1, int[][] B, int r2, int c2 ){

        if(c1!=r2){
            System.out.print("Multiplication can't be performed.");
            return;
        }
        int[][] C=new int [r1][c2];
        System.out.println("Matrix A X B =");
        for(int i=0; i<r1; i++){
            for(int j=0; j<c2; j++){
                for(int k=0; k<c1; k++){
                    C[i][j]+=A[i][k]*B[k][j];
                }
            }
        }
        printMatrix(C, r1, c2);
    }
    public static void main(String[] args) {
        MAtrixMultiplication obj=new MAtrixMultiplication();
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
        System.out.print("Enter the no of row in B:");
        int r2=sc.nextInt();
        System.out.print("Enter  the no of column in B:");
        int c2=sc.nextInt();
        int[][] B=new int[r2][c2];
        System.out.println("Enter the element in B:");
        for(int i=0; i<r2; i++){
            for(int j=0; j<c2; j++){
                B[i][j]=sc.nextInt();
            }
        }
        System.out.println("MAtrix A:");
        obj.printMatrix(A, r1, c1);
        System.out.println("Matrix B:");
        obj.printMatrix(B, r2, c2);
        obj.Multi(A, r1, c1, B, r2, c2);
    }
}
