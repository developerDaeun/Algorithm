import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1987_알파벳 {

	static int R, C;
	static char[][] map;
	static boolean[] visited = new boolean[26];
	static int[] dr = {-1,1,0,0};	// 상,하,좌,우
	static int[] dc = {0,0,-1,1};
	static int max = 1; // 최대 이동 칸 수 저장 변수 생성
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];		// 보드판
		
		// 보드 배열에 알파벳 입력
		for(int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}

		dfs(0,0,0);
		
		bw.write(String.valueOf(max));	// 최대 이동 칸 수 출력
		bw.close();
	}

	static void dfs(int r, int c, int cnt) {
		if(visited[map[r][c]-65]) {	// 현재 알파벳을 방문했으면 최대값 구하고 리턴
			max = Math.max(max, cnt);
			return;
		}
		
		int nr, nc;
		for(int d = 0; d < 4; d++) {	// 현재 말 위치에서 사방탐색
			nr = r + dr[d];
			nc = c + dc[d];
			
			if(nr<0 || nr>=R || nc<0 || nc>=C) {	// 범위 벗어나면 continue
				continue;
			}
			
			visited[map[r][c]-65] = true;	// 다음 말 위치를 선택했을때
			dfs(nr, nc, cnt+1);				// 다음 말 위치부터 사방탐색하기 위해 dfs 재귀
			visited[map[r][c]-65] = false;	// 다음 말 위치를 선택하지 않았을 때
		}
	}
}