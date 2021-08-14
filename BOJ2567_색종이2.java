import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ2567_색종이2 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());	// 색종이의 수
		int total = 0;	// 색종이의 총 둘레 합
		int[][] map = new int[102][102];	// 범위 안벗어나게 102로
		
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());

			for(int r = row; r < row+10; r++) {
				for(int c = col; c < col+10; c++) {
					if(map[r][c] == 0) {	// 현재 색종이와 겹치는 부분이 없으면 1
						map[r][c] = 1;
					}
				}
			}
		}
		
		for(int r = 1; r < 101; r++) {
			for(int c = 1; c < 101; c++) {
				if(map[r][c]==1) {	// 현재 색종이
					for(int d = 0; d < 4; d++) {	// 상하좌우 확인
						int nr = r + dr[d];
						int nc = c + dc[d];
						
						if(map[nr][nc]==0) {	// 색종이가 없는 부분을 위주로 ++ -> 둘레
							total++;
						}
					}
				}
			}
		}
		
		bw.write(String.valueOf(total));
		bw.close();
	}
}