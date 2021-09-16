import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11403_경로찾기 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());	// 정점 개수
		int[][] map = new int[N][N];
		
		// 인접행렬 입력 받기
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int k = 0; k < N; k++) {
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					// 출발지 -> 경유지, 경유지 -> 도착지 둘다 1이면 갈수있다는 의미이므로 1 저장
					if(map[i][k]==1 && map[k][j]==1)	
						map[i][j] = 1;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				sb.append(map[i][j] + " ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}