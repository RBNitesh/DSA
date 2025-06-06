package DP;

public class countSubSetWithGivenSum{
    public static void main(String[] args) {
        int[] arr = {0, 10, 0};
        int sum = 0;
        
        int n = arr.length;

        int[][] t = new int[n+1][sum+1];

        for(int i=0; i<n+1; i++){
            for(int j=0; j<sum+1; j++){
                if(i==0){
                    if(j==0) t[i][j] = 1;
                    else t[i][j] = 0;
                }

                else if(arr[i-1] > j){
                    t[i][j] = t[i-1][j];
                }

                else{
                    t[i][j] = t[i-1][j-arr[i-1]] + t[i-1][j];
                }
            }
        }
        System.out.println(t[n][sum]);
    }
}