class FenWickTree{
    public int[] createBIT(int[] a){
        int n = a.length;
        int[] BIT = new int[n+1];

        for(int i=1; i<n+1; ++i){
            updateBIT(BIT, a[i-1], i);
        }
        return BIT;
    }

    public void updateBIT(int[] BIT, int val, int i){
        int len = BIT.length;

        while(i < len){
            BIT[i] += val;
            i = getNext(i);
        }
    }

    public int getSum(int[] BIT, int i){
        i += 1;
        int sum = 0;

        while(i > 0){
            sum += BIT[i];
            i = getParent(i);
        }
        return sum;
    }

    private int getNext(int i){
        return i + (i & -i);
    }

    private int getParent(int i){
        return i - (i & -i);
    }
}


public class Main{
    public static void main(String[] abc){
        int[] arr = {2, 3, 5, -1, 5, 3, 7};

        FenWickTree fenweekTree = new FenWickTree();
        int[] BIT = fenweekTree.createBIT(arr);

        int newVal = -2; // replace arr[1] with newVal
        fenweekTree.updateBIT(BIT, newVal-arr[1], 2);

        int[] preSum = new int[BIT.length-1];
        for(int i=0; i<arr.length; ++i){
            preSum[i] = fenweekTree.getSum(BIT, i);
        }

        for(int sum : preSum){
            System.out.print(sum + " ");
        }
    }
}