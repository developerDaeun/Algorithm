import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1152_단어의개수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int sum = 0;
        for(int i = 0; i < s.length; i++){
            if(!s[i].equals("")) sum++;
        }

        System.out.print(sum);
    }
}