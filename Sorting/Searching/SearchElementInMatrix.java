package Sorting.Searching;

import java.util.Scanner;

public class SearchElementInMatrix {
    static boolean isPresent(int[][] matrix, int key){
        int i=0; int j=matrix[0].length-1;

        while(i<=matrix.length-1 && j>=0){
            int num=matrix[i][j];
            if(key == num){return true;}
            else if(key < num){j--;}
            else{i++;}
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        /*
           1.Every row and column of matrix is sorted.
        */
        int[][] matrix={{1,5,9,13},{2,6,10,14},{3,7,11,15},{4,8,12,16}};
        System.out.print("Enter the key:");
        int key=sc.nextInt();
        System.out.println(isPresent(matrix,key));
    }
}
