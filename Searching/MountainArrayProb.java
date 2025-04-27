package Sorting.Searching;

import java.util.ArrayList;
import java.util.List;

public class MountainArrayProb {
    //method-->1
    static int findPeak1(int[] arr){
        int l=1; int h=arr.length-2;
    
        while(l<=h){
            int idx=l+(h-l)/2;
            if(arr[idx-1] < arr[idx] && arr[idx] > arr[idx+1]) { 
                return idx; 
            }
            else if(arr[idx-1] < arr[idx] && arr[idx] < arr[idx+1]) { l=idx+1; }
            else if(arr[idx-1] > arr[idx] && arr[idx] > arr[idx+1]) { h=idx-1; }
        }
        return -1;
    }
    
    //method-->2
    static int findPeak2(int[] arr){
        int i=0; int j=arr.length-1;
        int ans=-1;
        while(i<=j){
            int mid=i+(j-i)/2;
            if(arr[mid]<arr[mid+1]){
                ans=mid+1;
                i=mid+1;
            }else{
                j=mid-1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr={0,2,5,7,9,8,6,4,1};
        System.out.println(findPeak1(arr));
        System.out.println(findPeak2(arr));
    }
}
