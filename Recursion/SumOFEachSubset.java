package Recursion;

import java.util.Scanner;

public class SumOFEachSubset {
    static void SumOfSubset(int[] arr , int curridx , int currSum){
        if(curridx==arr.length){
            System.out.println(currSum);
            return;
        }

        int currElement = arr[curridx];

        //current element --> present in subset
        SumOfSubset(arr, curridx+1, currSum+currElement);
        //current element --> not present in subset
        SumOfSubset(arr, curridx+1, currSum);
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr={3,4,5};
        SumOfSubset(arr, 0 , 0);
    }
}
