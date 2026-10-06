import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.Reader;

class FastIO {
    BufferedReader br;
    StringTokenizer st;

    public FastIO() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public String next(){
        while (st == null || !st.hasMoreTokens()) {
            try{
                st = new StringTokenizer(br.readLine());
            }
            catch (IOException ex) {
                System.out.println("Error while reading input\n" +ex.getMessage());
            }
        }
        return st.nextToken();
    }
    
    public int nextInt() {
        return Integer.parseInt(this.next());
    }

    public double nextDouble() {
        return Double.parseDouble(this.next());
    }

    public double nextLong() {
        return Long.parseLong(this.next());
    }

    public String nextLine() throws IOException{
        String str = "";
        try {
            // read last line if something has left there otherwise read new line
            str = st.hasMoreTokens()? st.nextToken("\n") : br.readLine();
        }
        catch (IOException ex) {
            System.out.println("Error while reading input\n" + ex.getMessage());
        }
        return str;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {

        // token: A token is a maximal substring that doesn't include delimeter.

    /* 
        // take the input from the system
        Reader input = new InputStreamReader(System.in);

        // create the BufferedReader to read the input in large chunks
        BufferedReader br = new BufferedReader(input);

        // read the first line of the input
        String firstLine = br.readLine();

        // split the input into tokens
        StringTokenizer st = new StringTokenizer(firstLine); 

        // read the only token from first line and parse it 
        int tc = Integer.valueOf(st.nextToken());

        while (tc-- > 0) {
            // read the curr line
            String line = br.readLine();

            // split the input into tokens
            st = new StringTokenizer(line);

            int count = st.countTokens();

            // read all the tokens until it has nothing left
            while (count-- > 0) { // can use st.hasMoreTokens()
                int ele = Integer.parseInt(st.nextToken());
                IO.println(ele);
            }
        }
        br.close();
    */
        
    /* 
    FastIO in = new FastIO();
    
    String name = in.next();
    String description = in.nextLine();
    
    System.out.println(name + "\n" + description);
    */
   
        
        
    }
}
