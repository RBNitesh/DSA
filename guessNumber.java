import java.util.Scanner;

public class guessNumber{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] grid = new int[4][4];
        int num = 1;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                grid[i][j] = num++;
            }
        }
        
        int inp1;
        while(true){
            inp1 = sc.nextInt();
            if(inp1 >= 1 && inp1 <= 4) break;
            else{
                System.out.println("Enter valid input ");
            }
        }
        
        //change the row given by user as a hint into column
        for(int j=0; j<grid[0].length; j++){
            int temp = grid[inp1][j];
            grid[inp1][j] = grid[j][inp1];
            grid[j][inp1] = temp;
        }

        int inp2;
        while(true){
            inp2 = sc.nextInt();
            if(inp2 >= 1 && inp2 <= 4) break;
            else{
                System.out.println("Enter valid input ");
            }
        }

        System.out.println(grid[inp2-1][inp1-1]);
    }
}