package Sorting.Searching;

import java.util.Scanner;

public class RacingTrack {

    static boolean isPossible(int[] arr, int maxDist, int n){
        int noOfChild=1;
        int lastChild=arr[0];

        for(int i=0; i<arr.length; i++){
            if(arr[i]-lastChild >= maxDist){
                noOfChild++;
                lastChild=arr[i];
            }
        }
        
        return (noOfChild >= n);
    }
    static int findLargeMinDistanceBtwTwoChildOnRaceTrack(int[] arr, int n){
        if(n > arr.length){ return -1;}
        int first=0; int last=(int) 1e9;
        int ans=0;
        while(first <= last){
            int mid = first + (last - first)/2;
            if(isPossible(arr,mid,n)){//can k childs placed on track such that no two child have distance lesser than this.
                ans = mid;
                first = mid + 1;
            }else{
                last=mid-1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {0, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        System.out.print("Enter the no. of children:");
        int n = sc.nextInt();
        System.out.println(findLargeMinDistanceBtwTwoChildOnRaceTrack(arr,n));
    }
}
