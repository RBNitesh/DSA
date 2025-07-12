
package dsacollegeWallah;

import java.util.Scanner;

public class pattern {
    public static void rectangular(int m, int n){
        for(int i=1; i<=m; i++){
           if(i==1 || i==m){
            for( int j=1; j<=n; j++){
                System.out.print("*");
            }
            System.out.println();
           }
           else
           {
            for(int j=1; j<=n; j++){
                if(j==1 || j==n){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
           }
        }
    }

    public static void triangular(int m){
        int i,j;
        for( i=1; i<=m; i++){
           for(j=1; j<=i; j++) 
        //    for(j=n; j>=i; j--)//reverse triangular pattern
           {
              System.out.print("*");
           }
           System.out.println();
        }
    }

    public static void pyramid(int m){
        for(int i=1; i<=m; i++){
            {
            for(int j=1; j<=m-i; j++){
               System.out.print(" ");
            }
            for(int j=1; j<=2*i-1; j++){
                System.out.print("*");
            }
        }
        System.out.println();
      }
    }

    public static void numericalRectangular(int first,int last){
         for(int i=first; i<=last; i++){
            for (int j=i; j<=last; j++){
               System.out.print(j);
            }
            for(int j=first; j<i; j++){
                System.out.print(j);
            }
            System.out.println();
         }
    }

        /*121212
          212121
          121212
          212121*/


    public  static void numPattern(int m, int n){
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if((i+j)%2==0){
                    System.out.print(1);
                }else{
                    System.out.print(2);
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        pattern obj=new pattern();
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number of row: ");
        int m=sc.nextInt();
        System.out.print("Enter the  number column: ");
        int n=sc.nextInt();
        obj.rectangular(m,n);
        obj.triangular(m);
        obj.pyramid(m);
        System.out.print("Enter starting number for numerical pattern: ");
        int a=sc.nextInt();
        System.out.print("Enter ending number for numerical pattern: ");
        int b=sc.nextInt();
        obj.numericalRectangular(a, b);
        System.out.print("Enter the number of row: ");
        int row=sc.nextInt();
        System.out.print("Enter the number column: ");
        int col=sc.nextInt();
        obj.numPattern(row,col);
    }
}
