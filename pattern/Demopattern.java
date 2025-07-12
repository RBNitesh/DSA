import java.util.Scanner;

class pattern1{
     public void print(int n){
        for(int i=0; i<n ; i++){
            for (int j=0; j<n; j++){
                if(j==i || j==n-i-1 ){
                   System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
     }
}

class pattern2{
    public void print(int n){
        for(int i=0; i<n ; i++){
            for (int j=0; j<n; j++){
               if(i+j>=n-1){
                System.out.print("*");
               }else{
                System.out.print(" ");
               }
            }
            System.out.println();
        }
    }
}

public class Demopattern {
    public static void main(String[] args) {
        pattern1 obj1=new pattern1();
        pattern2 obj2=new pattern2();
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter any number: ");
        int num=sc.nextInt();
        obj1.print(num);
        obj2.print(num);
    }
    
}
