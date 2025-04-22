public class DemolongestConsecutive {
    public static void sort(int[] a){
        int n=a.length;
        for(int i=1; i<n; i++){
            int  j=i;
            while(j>0){
                if(a[j-1] > a[j]){
                    int temp=a[j-1];
                    a[j-1]=a[j];
                    a[j]=temp;
                }
                j--;
            }
        }
    }
    static int findLongestConsecutive(int[] arr){
        sort(arr);
        int n=arr.length;
        int maxlen=1; int count=1;
        for(int i=1; i<n; i++){
            if(arr[i]==arr[i-1]+1) count++;
            else count=1;
            maxlen=Math.max(maxlen,count);
        }
        return maxlen;
    }
    public static void main(String[] args) {
        int[] arr={100,4,200,1,3,2};
        int maxlen=findLongestConsecutive(arr);
        System.out.println("Maxlen:"+maxlen);
    }
}
