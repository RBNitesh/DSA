package Sorting;

import java.util.Arrays;

public class RadixSort {
    static int[] radixSort(int n, int arr[]) {
        int maxi = 0;
        for(int it : arr) maxi = Math.max(maxi, it);

        int[] freq = new int[10];

        // compare digit by digit each time
        for (int k = 1; k <= maxi; k *= 10) {
            // initially frequency for each element is
            Arrays.fill(freq, 0); 

            for(int it : arr){
                it /= k;
                freq[it%10]++;
            }

            for(int i = 1; i < 10; i++){
                freq[i] += freq[i-1];
            }

            int[] newArr = new int[n];
            for(int i = n-1; i >= 0; i--){
                int digit = (arr[i]/k)%10;
                int index = freq[digit]-1;
                newArr[index] = arr[i];
                freq[digit]--;
            }
            System.arraycopy(newArr, 0, arr, 0, n);
        }

        return arr;
    }
    public static void main(String[] args) {
        int[] arr={2,524,46,7,2,145,3,47};
        
        int[] sortedArr = radixSort(arr.length, arr);
        Arrays.stream(sortedArr).forEach(ele -> System.out.print(ele +" "));
    }
}
