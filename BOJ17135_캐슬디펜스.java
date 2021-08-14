import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17135_캐슬디펜스 {

	static int N, M, D;
	static int[][] map;
	static int[][] copyMap; // 맵을 복사해서 사용할 변수
	static int[] bow; // 궁수의 위치 조합
	static int[] dr = {0,-1,0};	// 좌,상,우
	static int[] dc = {-1,0,1};
	static int max = Integer.MIN_VALUE; // 최종 최대 적 수
	static int total; // 현재 궁수의 조합으로 공격할수있는 적 수
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());	// 행의 수
		M = Integer.parseInt(st.nextToken());	// 열의 수
		D = Integer.parseInt(st.nextToken());	// 공격 거리 제한
		map = new int[N+1][M];
		copyMap = new int[N+1][M];
		bow = new int[3];
		
		// 격자판 입력, 1: 적이 있는 칸
		for(int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 격자판 복사
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				copyMap[i][j] = map[i][j];
			}
		}
		
		comb(0,0);
		
		bw.write(String.valueOf(max));
		bw.close();
		
	}

	static void comb(int start, int cnt) {
		if(cnt == 3) {
			total = 0;
			for(int i = 0; i < N; i++) {	// 현재 궁수 조합을 돌리기위해 원래맵을 복사 (이전 조합에서 맵은 바꼈으므로)
				for(int j = 0; j < M; j++) {
					copyMap[i][j] = map[i][j];
				}
			}
			dfs();	// 현재 조합에서 dfs
			max = Math.max(max, total); // 최대 적 수 구하기
			return;
		}
		
		for(int i = start; i < M; i++) {	// 궁수 조합
			bow[cnt] = i;	// 궁수 위치는 N행은 공통, col 위치 넣기
			comb(i+1, cnt+1);
		}
	}
	
	static void dfs() {
		Queue<Location> que = new LinkedList<>();
		boolean[][] visited;
		int[][] copyCopyMap = new int[N+1][M];
		
		Location curBow; // 현재 궁수의 위치
		Location cur;	// 적이 아닌곳의 위치
		int dist;	// 궁수위치와 적의 위치 거리 차이
		
		for(int n = 0; n < N; n++) {	// 현재 궁수 조합에서 궁수마다 공격할 적을 찾기 위한 맵 생성
			for(int m = 0; m < M; m++) {
				copyCopyMap[n][m] = copyMap[n][m];
			}
		}
		
		for(int k = 0; k < N; k++) {	//적은 총 N번만큼 아래로 이동할 수 있음
			// 모든 궁수위치 큐에 넣기
			for(int i = 0; i < 3; i++) {
				visited = new boolean[N+1][M];	// 궁수가 바꼈으므로 다시 공격 준비, 방문 초기화
				que.clear(); // 궁수가 바꼈으므로 큐 초기화
				que.offer(new Location(N,bow[i])); // 현재 궁수 큐에 추가
				curBow =que.peek(); // 공격할 위치와 궁수의 거리 D의 차이를 구하기위해 궁수의 위치 미리 저장
				while(!que.isEmpty()) {
					cur = que.poll();	// 한명의 궁수씩 공격, 적이 없는 위치도 큐에 추가해서 적을 탐색
					for(int d = 0; d < 3; d++) {	// 좌,상,우 탐색(가장 왼쪽 적부터)
						int nr = cur.r + dr[d];
						int nc = cur.c + dc[d];
						
						if(nr<0 || nr>=N || nc<0 || nc>=M || visited[nr][nc]) {	// 범위 벗어나거나 이미 방문했으면 continue;
							continue;
						}
						
						// 궁수위치와 다음 공격할 위치와의 거리가 D보다 크면 더이상 공격할 수 없음
						dist = Math.abs(N-nr)+Math.abs(curBow.c-nc);	
						if(dist > D) {
							break;
						}
						
						if(copyCopyMap[nr][nc]==1) {	// 적을 만나면
							if(copyMap[nr][nc] != 0) {	// 다른 궁수가 먼저 죽인 적이면 실행안함
								copyMap[nr][nc] = 0;
								total++;
							}
							que.clear(); // 다음 궁수의 공격할 적을 찾기위해 que 초기화
							break;
						}
						
						// 적을 못만나면 큐에 추가후 탐색
						que.offer(new Location(nr,nc));
						visited[nr][nc] = true;
					}
				}
			}
			
			// 궁수의 공격이 다 끝나면 적을 아래로 이동
			for(int i = N-1; i > 0; i--) {
				for(int j = 0; j < M; j++) {
					copyMap[i][j] = copyMap[i-1][j];
				}
			}
			// 적이 한칸씩 아래로 이동했으므로 맨 윗줄은 0으로
			for(int j = 0; j < M; j++) {
				copyMap[0][j] = 0;
			}
			for(int n = 0; n < N; n++) {	// 맵 원래대로
				for(int m = 0; m < M; m++) {
					copyCopyMap[n][m] = copyMap[n][m];
				}
			}
		}
	}
	
	static class Location{
		int r, c;
		Location(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
}