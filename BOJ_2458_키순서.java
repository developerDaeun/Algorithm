import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2458_키순서 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());	// 학생 노드 수
		int M = Integer.parseInt(st.nextToken());	// 비교 간선 수
		int[][] map = new int[N+1][N+1];
		
		int start, end;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			map[start][end] = 1;
		}
		
		for(int k = 1; k <= N; k++) {
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					if(map[i][k]==1 && map[k][j]==1)
						map[i][j] = 1;
				}
			}
		}
		
		boolean check;
		int sum = 0;
		for(int i = 1; i <= N; i++) {
			check = false;
			for(int j = 1; j <= N; j++) {
				// i->j 이거나 j->i로 가는 경로가 있을때 등수를 알수있다
				// 둘다 가는 경로가 없으면 등수를 알수없다
				if(i != j && map[i][j]==0 && map[j][i]==0) {	
					check = true;
					break;
				}
			}
			if(!check) sum++;
		}
		
		System.out.println(sum);
	}

}