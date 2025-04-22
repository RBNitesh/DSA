import java.util.Scanner;
import java.util.*;
public class DemoFourSum {
    public static List<List<Integer>> fourSum(int[] arr, int target){
        int n=arr.length;
        List<List<Integer>> list=new ArrayList<>();

        //brute-force approach
        // Set<List<Integer>> set=new HashSet<>();
        // for(int i=0; i<n-3; i++){
        //     for(int j=i+1; j<n-2; j++){
        //         for(int k=j+1; k<n-1; k++){
        //             for(int l=k+1; l<n; l++){
        //                 if(arr[i]+arr[j]+arr[k]+arr[l]==target){
        //                     Integer[] a={arr[i],arr[j],arr[k],arr[l]};
        //                     Arrays.sort(a);
        //                     List<Integer> li=Arrays.asList(a);
        //                     set.add(li);
        //                 }
        //             }
        //         }
        //     }
        // }

        //better approach
        Arrays.sort(arr);
        for(int i=0; i<n-3; i++){
            if(i>0 && arr[i]==arr[i-1]) continue;
            for(int j=i+1; j<n-2; j++){
                if(j>0 && arr[j]==arr[j-1]) continue;
                int k=j+1; int l=n-1;
                while(k<l){
                    int sum=arr[i]+arr[j]+arr[k]+arr[l];
                    if(sum<0) k++;
                    else if(sum > 0) l--;
                    else{
                        List<Integer> li=Arrays.asList(arr[i],arr[j],arr[k],arr[l]);
                        list.add(li);
                        k++; l--;
                        while(k<l && arr[k]==arr[k-1]) k++;
                        while(k<l && arr[l]==arr[l+1]) l--;
                    }
                }
            }
        }
        return list;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] arr={1,0,-1,0,-2,2};
        int target=0;
        System.out.println(fourSum(arr, target));
    }
}
