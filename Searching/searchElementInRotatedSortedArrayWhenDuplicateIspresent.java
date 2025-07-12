package Sorting.Searching;

import java.util.Scanner;

public class searchElementInRotatedSortedArrayWhenDuplicateIspresent {

    static int binarySearch(int[] arr,int key, int st, int end){       
        while(st<=end){
        int mid=st+(end-st)/2;
        if(arr[mid]==key) return mid;
        else if(key<arr[mid]) end=mid-1;
        else if(key>arr[mid]) st=mid+1;
    }
    return -1;
    }
    
    static int findMinIdx(int[]arr, int n, int st, int end){
        int idx=-1;

        while(st<=end){
        int mid=st+(end-st)/2;
        if(arr[mid]>arr[n-1]){
            st=mid+1;
        }else if(arr[mid]<=arr[n-1]){
            idx=mid;
            end=mid-1;
        }
    }
    return idx;
    }

    //method-->1
    static int findElement1(int[] arr, int key){
        int n=arr.length;
        int st=0; int end=n-1;

        int minIdx=findMinIdx(arr,n,st,end);//finding minimum element 
        
        if(key==arr[minIdx]) {return minIdx;}
        else if(key>arr[minIdx] && key<=arr[n-1]){
            st=minIdx+1;
            return binarySearch(arr, key, st, end);
        }else{
            end=minIdx-1;
            return binarySearch(arr, key, st, end);
        }
    }   

    //method-->2
    static int findElement2(int[] arr,int key){
        int st=0;int end=arr.length-1;
        
        while(st<=end){
        int mid=st+(end-st)/2;
        if(arr[mid]==key){return mid;}

        else if(arr[st]==arr[mid] && arr[mid]==arr[end]){
            st++;
            end--;
        }
        
        else if(arr[mid] <= arr[end]){//second part of the array is sorted
            if(key>arr[mid] && key<=arr[end]){
                st = mid+1;
            }else{
                end=mid-1;
            }
        }
        else{//first part of the array is sorted
            if(key<arr[mid] && key>=arr[st]){
                end=mid-1;
            }else{
                st=mid+1;
            }
        }
    }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr={0,0,0,1,1,1,2,3,0,0};
        System.out.print("Enter the key to be searched:");
        int target=sc.nextInt();

        int idx1=findElement1(arr,target);//work even when duplicate is present
        System.out.println(idx1);
        int idx2=findElement2(arr, target);//work even when duplicate is present
        System.out.println(idx2);

    }
}
