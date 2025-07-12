package Array;

import java.util.Scanner;

class Spiral{
    public void printElememnt(int[][] Matrix, int r, int c){
        int totalElement=0;
        int topRow=0; int bottomRow=r-1; int leftCOl=0; int rightCol=c-1;
        while(totalElement < r*c){
            //print->top row
            for(int j=leftCOl; j<=rightCol && totalElement < r*c; j++){
                System.out.print(Matrix[topRow][j]+" ");
                totalElement++;
            }
            topRow++;
            //print->right col
            for(int i=topRow; i<=bottomRow && totalElement < r*c; i++){
                System.out.print(Matrix[i][rightCol]+" ");
                totalElement++;
            }
            rightCol--;
            //print->bottom row
            for(int j=rightCol; j>=leftCOl && totalElement < r*c; j--){
                System.out.print(Matrix[bottomRow][j]+" ");
                totalElement++;
            }
            bottomRow--;
            //print->left col
            for(int i=bottomRow; i>=topRow && totalElement < r*c; i--){
                System.out.print(Matrix[i][leftCOl]+" ");
                totalElement++;
            }
            leftCOl++;
        }
    }
}
public class SpiralMatrix {
    public static void main(String[] args) {
        Spiral obj=new Spiral();
            Scanner sc=new Scanner(System.in);
            System.out.print("Enter the number of row:");
            int r=sc.nextInt();
            System.out.print("Enter the number of column:");
            int c=sc.nextInt();
            int [][] Matrix = new int[r][c];
            System.out.println("Enter the element of Matrix:");
            for(int i=0; i<r; i++){
                for(int j=0; j<c; j++){
                    Matrix[i][j]=sc.nextInt();
                }
            }
            obj.printElememnt(Matrix, r, c);
        }
    }
