package Contest;
import java.util.*;

class Solution {
    public int specialTriplets(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> mp1 = new HashMap<>();
        Map<Integer, Integer> mp2 = new HashMap<>();

        for(int num : nums){
            if(num % 2 == 0){
                if(!mp2.containsKey(num)){
                    mp2.put(num, 1);
                }
                else{
                    mp2.replace(num, mp2.get(num)+1);
                }
            }
        }

        int j=0;
        int cnt = 0;
        int modulo = 1000000007;
        while(j < n){
            if(mp2.containsKey(nums[j])){
                if(mp2.get(nums[j]) > 1){
                    mp2.replace(nums[j], mp2.get(nums[j])-1);
                }
                else{
                    mp2.remove(nums[j]);
                }
            }

            if(mp1.containsKey(nums[j]*2) && mp2.containsKey(nums[j]*2)){
                cnt = (cnt + (mp1.get(nums[j]*2) * mp2.get(nums[j]*2)) % modulo) % modulo;
            }

            if(nums[j] % 2== 0){
                if(!mp1.containsKey(nums[j])){
                    mp1.put(nums[j], 1);
                }
                else{
                    mp1.replace(nums[j], mp1.get(nums[j])+1);
                }
            }

            j++;
        }
        return cnt;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution obj = new Solution();

        int[] arr = {0, 0, 0, 0};
        System.out.println(obj.specialTriplets(arr));
    }
}
