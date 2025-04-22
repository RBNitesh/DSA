package Array;

import java.util.Scanner;

public class Transpose {
    static void printMatrix(int[][] A, int r, int c){
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                System.out.print(A[i][j]+" ");
            }
            System.out.println();
        }
    }

    static int[][] TranseposeMatrix(int[][] A, int r1, int c1){
        int[][] C=new int[c1][r1];
        for(int i=0; i<c1; i++){
            for(int j=0; j<r1; j++){
               C[i][j]=A[j][i];
                }
            }
            return C;  
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
    int[][] C=TranseposeMatrix(A, r1, c1);
    System.out.println("Transpose of Matrix:");
    printMatrix(C, c1, r1);
    }
}
