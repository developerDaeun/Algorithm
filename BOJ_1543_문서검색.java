import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1543_문서검색 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String ss = br.readLine();

        int cnt = 0;
        for(int i = 0; i + ss.length() <= s.length(); i++){
            if(s.substring(i, i + ss.length()).equals(ss)){
                i += ss.length() - 1;
                cnt++;
            }
        }

        System.out.print(cnt);

    }
}
