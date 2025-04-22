package Array;

import java.util.Scanner;

public class printSpiralMatrix {
    static void printMatrix(int [][]Matrix, int n){
        for(int i=0; i<n; i++){
            for (int j=0; j<n; j++){
               System.out.print(Matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    static int[][] printSpiralMatrix(int n){
        int[][] Matrix=new int[n][n];
        int topRow=0; int bottomRow=n-1; int leftCOl=0; int rightCol=n-1;
        int num=1;
        while(num<=n*n){
            for(int j=leftCOl; j<=rightCol; j++){
                Matrix[topRow][j]=num;
                num++;               
            }
            topRow++;
            //print->right col
            for(int i=topRow; i<=bottomRow ; i++){
                Matrix[i][rightCol]=num;
                num++;
            }
            rightCol--;
            //print->bottom row
            for(int j=rightCol; j>=leftCOl; j--){
                Matrix[bottomRow][j]=num;
                num++;
            }
            bottomRow--;
            //print->left col
            for(int i=bottomRow; i>=topRow; i--){
                Matrix[i][leftCOl]=num;
                num++;
            }
            leftCOl++;
        }
        return Matrix;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //for a given number n generate a matrix filled with number from 1 to n*n in spiral order
        System.out.println("Enter the value of n:");
        int n=sc.nextInt();

        int [][] Matrix=printSpiralMatrix(n);
        printMatrix(Matrix, n);
    }
}
