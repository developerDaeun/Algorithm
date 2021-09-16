import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
1
2
0 0
1000 5
2000 10
3000 15
answer : sad

3
0
1000 1000
1000 1001
1
0 0
1000 0
0 2000
2
0 0
10000 0
0 1000
0 2000
정답:
happy
sad
happy
 */
public class BOJ_9205_맥주마시면서걸어가기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		int n; // 편의점 개수
		int[][] point;// 상근이집, 편의점, 페스티벌 좌표
		int[][] dp;
		
		for (int t = 0; t < T; t++) {
			n = Integer.parseInt(br.readLine());
			point = new int[n+2][2];
			dp = new int[n+2][n+2];
			
			// 집, 편의점, 페스티벌 좌표 입력 (0: 집좌표, n개: 편의점좌표, n+1: 페스티벌 좌표)
			for (int i = 0; i < n + 2; i++) {
				st = new StringTokenizer(br.readLine());
				point[i][0] = Integer.parseInt(st.nextToken());
				point[i][1] = Integer.parseInt(st.nextToken());
			}
			
			// dp 배열 초기화 (집->편의점, 편의점->편의점, 편의점->페스티벌까지 직접거리 저장)
			for(int i = 0; i < n+1; i++) {	// 출발
				for(int j = 1; j < n+2; j++) {	// 도착
					if(i!=j) {
						// 집 -> 편의점 / 편의점->편의점 / 편의점->페스티벌 거리 저장
						dp[i][j] = Math.abs(point[i][0] - point[j][0]) + Math.abs(point[i][1] - point[j][1]);
					}
				}
			}
			
			// 모든 최단거리 구하기
			for(int k = 0; k < n+2; k++) {
				for(int i = 0; i < n+2; i++) {
					for(int j = 0; j < n+2; j++) {
						// 출발점->경유지, 경유지->도착점 거리가 둘다 0이상 1000 이하이면 맥주를 마실수 있음
						if(dp[i][k] <= 1000 && dp[k][j] <= 1000 && dp[i][k] > 0 && dp[k][j] > 0)	
							dp[i][j] = dp[k][j];	// 출발점->경유지는 맥주를 마실수 있다는 보장이 되어있으므로 경유지->도착점 거리를 저장
					}
				}
			}
			
			// 집->페스티벌 까지 1000이하이면 happy
			sb.append((dp[0][n+1] <= 1000?"happy":"sad") + "\n");
		}
		System.out.println(sb);
	}

}