import java.util.Scanner;

public class rectangleSum_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of row: ");
        int r = sc.nextInt();
        System.out.print("Enter the number of col: ");
        int c = sc.nextInt();

        int[][] arr = new int[r][c];
        System.out.println("Enter the elements in array: ");
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter the value of l1, r1, l2, and r2 respectively: ");
        int l1 = sc.nextInt();
        int r1 = sc.nextInt();
        int l2 = sc.nextInt();
        int r2 = sc.nextInt();

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(i > 0)
                    arr[i][j] += arr[i-1][j];
                if(j > 0)
                    arr[i][j] += arr[i][j-1];

                if(i>0 && j>0)
                    arr[i][j] -= arr[i-1][j-1];
            }
        }

        int res=arr[l2][r2];

        if(l1 > 0)
            res -= arr[l1-1][r2];
        
        if(r1 > 0)
            res -= arr[l2][r1-1];

        if(l1>0 && r1>0)
            res += arr[l1-1][r1-1];

        System.out.println("Resultant sum of the given rectangle: " +res);
    }
}