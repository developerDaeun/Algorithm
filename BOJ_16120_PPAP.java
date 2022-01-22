import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * P[PPAP][PPAP]A[PPAP][PPAP]A[PPAP]A[PPAP][PPAP]A[PPAP]
 */
public class BOJ_16120_PPAP {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int cnt = 0;
        for (int i = 0; i < s.length()-1; i++){
            if(s.charAt(i) == 'P') cnt++;
            else{
                if(s.charAt(i+1) == 'P') {
                    cnt--;
                    i++;
                }
            }
        }

        if(cnt == 1) System.out.print("PPAP");
        else System.out.print("NP");
    }
}