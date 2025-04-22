import java.util.Scanner;

public class K_patterns {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the no. column:");
        int n=sc.nextInt();
        for(int i=0; i<n-1; i++){
            for(int j=0; j<n; j++){
                if(j==0 || j==(n-1)-i){
                    System.out.print("*"+" ");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        for(int i=n-1; i<=(n*2)-3; i++){
            for(int j=0; j<n; j++){
                if(j==0 || j==(i-n)+2){
                    System.out.print("*"+" ");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
