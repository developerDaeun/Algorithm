import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1941_소문난칠공주 {
	
	static char[][] map;
	static int total;	// 7공주 경우의 수
	static ArrayList<Data> list;	// 25개 모든 학생 위치
	static Data[] datas;	// 7공주 저장 배열
	static int[] dr = {-1,1,0,0};	// 상하좌우
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new char[5][5];
		
		// 5*5 자리 배치 입력 받기
		for(int i = 0; i < 5; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		// 조합을 위한 리스트 생성
		list = new ArrayList<>();
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				list.add(new Data(i,j));
			}
		}
		
		// 7개 조합 배열 생성
		datas = new Data[7];
		
		// 조합
		comb(0,0);
		
		System.out.println(total);
	}

	private static void comb(int idx, int cnt) {
		if(cnt == 7) {
			
			// S 개수 세기
			int Ssum = 0;
			
			// 인접한 공주의 수
			int sum = 1;
			
			// 7공주의 위치에만 방문 체크
			boolean[][] v_seven = new boolean[5][5];
			for(int i = 0; i < 7; i++) {
				// S 개수 세기
				if(map[datas[i].r][datas[i].c] == 'S')
					Ssum++;
				v_seven[datas[i].r][datas[i].c] = true;
			}
			
			// 7공주 하나씩 돌면서, 7공주 중 한명의 위치이면서(v_seven == true) 방문하지 않은(visited == false) 좌표 4방탐색해 방문체크
			// 큐로 bfs
			Queue<Data> q = new LinkedList<>();
			boolean[][] visited = new boolean[5][5];
			
			q.offer(datas[0]);
			visited[datas[0].r][datas[0].c] = true;
			
			int nr, nc;
			Data cur;
			while(!q.isEmpty()) {
				cur = q.poll();
				for(int d = 0; d < 4; d++) {
					nr = cur.r + dr[d];
					nc = cur.c + dc[d];
					
					if(nr<0 || nr>=5 || nc<0 || nc>=5)	// 범위 벗어나면 continue
						continue;
					
					if(!v_seven[nr][nc] || visited[nr][nc]) // 7공주중 한명의 위치가 아니거나, 방문한 좌표이면 continue
						continue;
					
					// 7공주중 한명의 위치이면 큐에 삽입, 방문체크, 공주의 수 세기
					q.offer(new Data(nr,nc));
					visited[nr][nc] = true;
					sum++;
				}
				
			}

			// 모든 7공주가 인접해있고 S 개수가 4 이상일때 total +1
			if(sum==7 && Ssum >= 4) {
				total++;
			}
			
			return;
		}
		
		// 조합
		for(int i = idx; i < list.size(); i++) {
			datas[cnt] = list.get(i);
			comb(i+1, cnt+1);
			
		}
	}
	
	static class Data{
		int r, c;
		
		public Data(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}