import java.util.*;

public class ZAlgoDemo{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        String pat = sc.next();

        String s = pat + "$" + str;
        ArrayList<Integer> z = zfunction(s);

        for(int it : z){
            System.out.print(it + " ");
        }
        System.out.println();
    }

    public static ArrayList<Integer> zfunction(String s){
        int n = s.length();

        ArrayList<Integer> z = new ArrayList<>(Collections.nCopies(n, 0));

        int l = 0, r = 0;

        for(int i = 1; i < n; i++){
            if(i <= r){
                int k = i-l;

                // reuse the previously computed value 0 1 2 3 4 (l....r) r+1 ....n
                z.set(i, Math.min(z.get(k), r-i+1));
            }

            // try to extend the z-box beyond r
            while(i+z.get(i) < n && s.charAt(i + z.get(i)) == s.charAt(z.get(i))){
                z.set(i, z.get(i) + 1);
            }

            // update the [l, r] window if extended
            if(i + z.get(i) - 1 > r){
                l = i;
                r = i + z.get(i) - 1;
            }
        }

        return z;
    }
}