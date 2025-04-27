package Sorting.Searching;

import java.util.Scanner;

public class chocolateBoxDistribution{
    static boolean isDivisionPossible(int[] boxes,int m,int maxallowed){
        int noOfStudents=1;
        int choc=0;//number of chocolate current student has

        for(int i=0; i<boxes.length; i++){
            if(boxes[i] > maxallowed){return false;}
            if((choc+boxes[i]) <= maxallowed){
                choc+=boxes[i];
            }else{
                noOfStudents++;
                choc=boxes[i];
            }
        }
        return (noOfStudents<=m);
    }
    static int findMin(int[] boxes, int numBoxes, int numStud){
        
        if(numBoxes<numStud){return -1;}
        int ans=0; int st=0; int end=(int) 1e9;

        while(st<=end){
            int mid=st+(end-st)/2;
            if(isDivisionPossible(boxes,numStud,mid)){
                ans=mid;
                end=mid-1;
            }else{
                st=mid+1;
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter no. of boxes:");
        int n=sc.nextInt();
        int[] boxes=new int[5];
        System.out.println("Enter the chocolates in boxes:");
        for(int i=0; i<n; i++){
            boxes[i]=sc.nextInt();
        }
        System.out.print("Number of students:");
        int numStud=sc.nextInt();
        
        int min=findMin(boxes,n,numStud);
        System.out.println(min);
    }
}