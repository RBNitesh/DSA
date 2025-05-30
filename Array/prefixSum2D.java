import java.util.Scanner;

public class prefixSum2D{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows in the matrix: ");
        int rows = sc.nextInt();
        System.out.print("Enter the number of columns in the matrix: ");
        int cols = sc.nextInt();

        int[][] matrix = new int[rows][cols];
        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        // Compute the prefix sum matrix
        int[][] prefixSum = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                prefixSum[i][j] = matrix[i][j];
                if(i > 0)
                prefixSum[i][j] += prefixSum[i-1][j];
                if(j > 0)
                prefixSum[i][j] += prefixSum[i][j-1];
                if(i > 0 && j > 0)
                prefixSum[i][j] -= prefixSum[i-1][j-1];    
            }
        }

        // Display the prefix sum matrix
        System.out.println("Prefix Sum Matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(prefixSum[i][j] + " ");
            }
            System.out.println();
        }
    }
}