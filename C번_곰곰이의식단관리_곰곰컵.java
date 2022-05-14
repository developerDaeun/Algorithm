import java.io.BufferedReader;
import java.io.InputStreamReader;

public class C번_곰곰이의식단관리_곰곰컵 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int not_c_cnt = 0;    // C 가 아닌 음식 날짜수
        for (int i = 0; i < N; i++) {
            if (s.charAt(i) != 'C') not_c_cnt++;
        }

        int c_cnt = N - not_c_cnt;  // 치킨 날짜수
        int answer = 0;
        if (not_c_cnt == 0) answer = c_cnt;
        else {
            if (c_cnt % (not_c_cnt + 1) == 0) answer = c_cnt / (not_c_cnt + 1);
            else answer = c_cnt / (not_c_cnt + 1) + 1;
        }

        System.out.print(answer);
    }
}
