package Array;

import java.util.Scanner;

public class SumOfBlockInAMatrix {
    static void printMatrix(int matrix[][]){
        int r=matrix.length;
        int c=matrix[0].length;
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    static int[][] prifixSumOfRowAndCol(int[][] matrix, int r, int c){
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(j>0){
                    matrix[i][j]+=matrix[i][j-1];
                }else{
                    matrix[i][j]=matrix[i][j];
                }   
            }
        }
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(i>0){
                    matrix[i][j]+=matrix[i-1][j];
                }else{
                    matrix[i][j]=matrix[i][j];
                }
            }
        }
        return matrix;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the no of row:");
        int r=sc.nextInt();
        System.out.print("Enter the no of column:");
        int c=sc.nextInt();
        int matrix[][]=new int[r][c];
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                matrix[i][j]=sc.nextInt();
            }
        }
        System.out.println("Orignal Matrix:");
        printMatrix(matrix);
        int[][] prefixSum=prifixSumOfRowAndCol(matrix, r, c);
        System.out.println("PrefixSum matrix:");
        printMatrix(prefixSum);
        System.out.println("Enter the r1, c1, r2 and c2 :");
        int r1=sc.nextInt();
        int c1=sc.nextInt();
        int r2=sc.nextInt();
        int c2=sc.nextInt();
        int ans;
        if(r1==0 && c1==0){
            ans=prefixSum[r2][c2];
        }
        else if(c1 == 0 ){
            ans=prefixSum[r2][c2]-prefixSum[r1-1][c2];
        }
        else if(r1==0){
            ans=prefixSum[r2][c2]-prefixSum[r2][c1-1];
        }
        else{
            ans=prefixSum[r2][c2]-(prefixSum[r1-1][c2]+prefixSum[r2][c1-1])+prefixSum[r1-1][c1-1];
        }
        System.out.print("Sum of elements in the rectangle block:");
        System.out.println(ans);
    }
}
