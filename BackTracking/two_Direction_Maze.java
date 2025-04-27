import java.util.Scanner;

public class two_Direction_Maze{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no. of row : ");
        int rowCount = sc.nextInt();
        System.out.println("Enter the no. of col : ");
        int colCount= sc.nextInt();
        maze(1, 1, rowCount, colCount, "");
        sc.close();
    }

    private static void maze(int sr, int sc, int er, int ec, String s){
        if(sr > er || sc > ec){
            return;
        }
        if(sr == er && sc == ec){
            System.out.println(s);
            return;
        } 
        maze(sr+1, sc, er, ec, s+"D");
        maze(sr, sc+1, er, ec, s+"R");
    }
}
