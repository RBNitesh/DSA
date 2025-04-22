package JavaCoolections;

import java.util.HashMap;
import java.util.Map;

public class Demo {
    static int longestSubarray(int[] arr, int k){
        // int n=arr.length;
        // int maxlen=0;
        // int preSum=0;
        // for(int i=0; i<n; i++){
        //     arr[i]=preSum+arr[i];
        //     preSum=arr[i];
        //     if(arr[i]==k){
        //         maxlen=Math.max(maxlen, i+1);
        //     }else {
        //         int rem=arr[i]-k;
        //         int j=0;
        //         while(j<i){
        //             if(arr[j]==rem){
        //                 maxlen=Math.max(maxlen, i-j);
        //                 break;//for maxlen j should be minimum
        //             }
        //             j++;
        //         }
        //     }
        // }
        // return maxlen;

        int n=arr.length;
       int maxlen=0;
       int preSum=0;
       Map<Integer, Integer> mp=new HashMap<>();
       for(int i=0; i<n; i++){
            arr[i]+=preSum;
            preSum=arr[i];
            if(arr[i]==k){
               maxlen=Math.max(maxlen, i+1);
            }else{
                int rem=arr[i]-k;
                if(mp.containsKey(rem)){
                    int j=mp.get(rem);
                    maxlen=Math.max(maxlen, i-j);
                }
            }
            mp.put(arr[i], i);
       }
       return maxlen;
    }
    public static void main(String[] args) {
        int[] arr={10,5,2,7,1,-10};
        int res=longestSubarray(arr,15);
        System.out.println(res);
    }
}
