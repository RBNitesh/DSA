package Sorting.Searching;

import java.util.Scanner;

public class searchElelmentIn2DArray {
    //method-->1
    static boolean findElement1(int[][] arr, int key){//O(nlogm) where n is no of row and m is no of col
        for(int i=0; i<arr.length; i++){
                if(key<=arr[i][arr[i].length-1] && key>=arr[i][0]){
                   int l=0;int h=arr[i].length-1;

                   while(l<=h){
                   int mid=l+(h-l)/2;
                   if(arr[i][mid]==key){return true;}
                   else if(key<arr[i][mid]){h=mid-1;}
                   else{l=mid+1;}

                }
            }
        }
        return false;
    }

    //method-->2
    static boolean findElement2(int[][] arr, int key){//O(log(n*m))
        int row=arr.length; int col=arr[0].length;
        int st=0; int end=(row*col)-1;
        
        while(st<=end){
        int mid=st+(end-st)/2;
        int i=mid/col;int j=mid%col;
        if(key==arr[i][j]){return true;}
        else if(key<arr[i][j]){end=mid-1;}
        else{st=mid+1;}
    }
    return  false;
}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*
           1.each row are sorted in matrix.
           2.Each element of a row is greater than every element of previous row.
         */
        int[][] arr={{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.print("Enter the key to be searched:");
        int key=sc.nextInt();

        System.out.println(findElement1(arr,key));
        System.out.println(findElement1(arr,key));
    }   
}
