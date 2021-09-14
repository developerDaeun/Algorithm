import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * input
3
26 40 83
49 60 57
13 89 99

[dp 결과]
26 40 83
89 86 83
96 172 185
 */
public class BOJ_1149_RGB거리 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		// 집 개수
		int N = Integer.parseInt(br.readLine());
		
		// 집마다 RGB 비용
		int[][] dp = new int[N+1][3];
		
		// 각 집 비용으로 dp 초기화
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				dp[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// dp
		int min = 0;
		for(int i = 2; i <= N; i++) {	// 2번째 집부터 시작
			for(int j = 0; j < 3; j++) {	// 현재집 i
				min = Integer.MAX_VALUE;
				for(int k = 0; k < 3; k++) {	// 앞집 i-1
					if(j!=k) {	// 이전 집과 같은색이 아닐때만
						min = Math.min(min, dp[i][j]+dp[i-1][k]);
					}
				}
				dp[i][j] = min;	// 찾은 min 값으로 변경
			}
		}
		
		// 마지막 집에서 최소값 구하기
		min = dp[N][0];
		for(int i = 1; i < 3; i++) {	
			min = Math.min(min, dp[N][i]);
		}
		
		System.out.println(min);
	}

}