import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_3109_빵집 {

	static int R,C;
	static char[][] map;
	static int[] dr = {-1,0,1};	// 오른쪽위, 오른쪽, 오른쪽아래
	static int[] dc = {1,1,1};
	static int max = 0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		
		// R*C 격자 입력
		for(int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for(int i = 0; i < R; i++) {
			if(dfs(i,0)) max++;		// 현재 행에서 파이프라인을 생성할 수 있으면 개수 + 1
		}
		
		bw.write(String.valueOf(max));
		bw.close();
	}

	static boolean dfs(int row, int col) {
		
		if(col == C-1) {	// 마지막 열까지 오면 리턴
			return true;
		}

		for(int d = 0; d < 3; d++) {	// 오른쪽위, 오른쪽, 오른쪽아래 탐색
			int nr = row + dr[d];
			int nc = col + dc[d];
			
			if(nr<0 || nr>=R || nc<0 || nc>=C) {	// 범위 벗어나면 continue
				continue;
			}
			
			if(map[nr][nc]=='x') {	// 건물을 만나면 갈 수 없으므로 continue
				continue;
			}

			map[nr][nc] = 'x';	// 다음 파이프라인을 생성할때 못가도록 현재 위치를 건물 x로 지정 (visited를 사용하지 않는 대신)
			
			if(dfs(nr, nc)) return true;	// 파이프라인을 생성할 수 있으면 true 리턴
		}
		
		return false; // 파이프라인을 생성할 수 없으면 false 리턴
	}
}