import java.util.*;

public class a {
    public static void main(String[] args) {
        int[][] arr={{1,2,3},{1,5,3},{6,3}};
        List<int[]> l=new ArrayList<>();
        l.addAll(new ArrayList<int[]>(Arrays.asList(arr[0])));
        int[][] a=l.toArray(new int[0][]);
        for(int i=0; i<a.length; i++){
            for(int j=0; j<a[0].length; j++){
                System.out.print(a[i][j]+" ");
            }
        }
    }
}
