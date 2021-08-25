import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10163_색종이 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());	// 색종이의 수
		
		int[][] map = new int[1001][1001];
		
		int px, py, w, h;
		for(int n = 1; n <= N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			px = Integer.parseInt(st.nextToken());	// 왼쪽아래 좌표 x
			py = Integer.parseInt(st.nextToken());	// 왼쪽아래 좌표 y
			w = Integer.parseInt(st.nextToken());	// 너비
			h = Integer.parseInt(st.nextToken());	// 높이
			for(int x = px; x < px+w; x++) {
				for(int y = py; y < py+h; y++) {
					map[x][y] = n;		// 색종이 칸에 색종이의 번호 넣기
				}
			}
		}
		
		for(int n = 1; n <= N; n++) {	// 색종이마다 보여지는 부분 넓이 구하기
			int sum = 0;
			for(int i = 0; i < 1001; i++) {
				for (int j = 0; j < 1001; j++) {
					if(map[i][j] == n) sum++;
				}
			}
			sb.append(sum + "\n");
		}
		
		System.out.println(sb);
	}
}