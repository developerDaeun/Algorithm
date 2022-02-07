import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1049_기타줄 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int m1 = Integer.MAX_VALUE;
        int m2 = Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE;

        // m1과 m2에 각각 기타줄 가격 최소값 구하기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            m1 = Math.min(m1, Integer.parseInt(st.nextToken()));
            m2 = Math.min(m2, Integer.parseInt(st.nextToken()));
        }

        // m1(기타줄 6개) 가격과 m2(낱개)*6 가격 비교
        // m2*6 이 더 작거나 같다면, N개 만큼 가격 구하기
        if (m1 >= m2 * 6) {
            res = m2 * N;
        } else {    // m1 가격이 더 크다면, 6개로 나눈 몫만큼 m1 곱하기
            res = N / 6 * m1;
            if (N % 6 > 0) {    // 6개로 나눈 나머지만큼 m1과 m2중 작은 값 더하기
                res += Math.min(m1, N % 6 * m2);
            }
        }

        System.out.print(res);

    }
}