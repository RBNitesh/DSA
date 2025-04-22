package dsacollegeWallah;

import java.util.Scanner;

class SeriesSum{
    public void Sum(int n){
        int sum=0;
        for(int i=0; i<=n; i++)
        {

           if(i%2==0)
           {
              sum-=i;
           }
           else
           {
              sum+=i;
           } 
       }
       System.out.println("Sum of series upto "+ n + " is: "+sum );
    }
}

public interface sumOfSeries {
    //Series=1-2+3-4+5-6+7......
    public static void main(String[] args) {
        SeriesSum obj=new SeriesSum();
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the end number of series: ");
        int n =sc.nextInt();
        obj.Sum(n);
    }
}
