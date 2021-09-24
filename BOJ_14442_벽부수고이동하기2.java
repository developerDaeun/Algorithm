import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14442_벽부수고이동하기2 {
   
   public static void main(String[] args) throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());   // 행 개수
      int M = Integer.parseInt(st.nextToken());   // 열 개수
      int K = Integer.parseInt(st.nextToken());   // 부술 벽 최대 개수
      char[][] map = new char[N][M];
      int[][][] dp = new int[K+1][N][M];   // 0~K-1까지 부순 벽 개수마다 최단거리 저장 배열
      boolean[][][] v = new boolean[K+1][N][M];   // 방문체크 배열
      int[] dr = {-1,1,0,0};   // 상하좌우
      int[] dc = {0,0,-1,1};
      
      // 맵 입력
      for(int i = 0; i < N; i++) {
         map[i] = br.readLine().toCharArray();
      }
      
      // 무한대 저장
      final int INF = 2_000_000;
      for(int i = 0; i <= K; i++) {
         for(int j = 0; j < N; j++) {
            Arrays.fill(dp[i][j], INF);
         }
         dp[i][0][0] = 1;   // 첫번째 칸은 최단거리 1
      }
      
      
      // bfs
      Queue<Data> q = new LinkedList<>();
      
      q.offer(new Data(0,0,0,1));
      v[0][0][0] = true;
      
      Data cur;
      int nr, nc;
      while(!q.isEmpty()) {
         cur = q.poll();
         
         for(int d = 0; d < 4; d++) {
            nr = cur.r + dr[d];
            nc = cur.c + dc[d];
            
            if(nr<0 || nr>=N || nc<0 || nc>=M || v[cur.cnt][nr][nc])
            	continue;
            
            if(map[nr][nc]=='1' && cur.cnt+1>K)   // 인접칸이 벽이고 벽을 부술수 없으면 continue
            	continue;
            
            // 인접칸이 벽이고 벽을 부술수 있으면 dp에 최단거리 저장
            if(map[nr][nc]=='1') {   
               dp[cur.cnt+1][nr][nc] = cur.dis+1;
               if(!v[cur.cnt+1][nr][nc]) {   // 방문하지 않았으면 queue에 삽입
                  q.offer(new Data(nr, nc, cur.cnt+1, cur.dis+1));
                  v[cur.cnt+1][nr][nc] = true;
               }
            }
            
            // 인접칸이 빈칸일때 dp에 최단거리 저장
            if(map[nr][nc]=='0') {
               dp[cur.cnt][nr][nc] = Math.min(dp[cur.cnt][nr][nc], dp[cur.cnt][cur.r][cur.c]+1);
               q.offer(new Data(nr, nc, cur.cnt, cur.dis+1));
               v[cur.cnt][nr][nc] = true;
            }
         }
      }

      // 마지막 칸에서 K만큼 반복문 -> 최단거리 최소값 구하기
      int min = INF;
      for(int i = 0; i <= K; i++) {
    	 min = Math.min(min, dp[i][N-1][M-1]);
      }
      
      // 최단거리가 없으면 (그대로 무한대 값이면) -1 출력
      if(min == INF) System.out.print("-1");
      else System.out.print(min);
   }

   static class Data{
      int r, c, cnt, dis;   // 행,열,부순벽개수,최단거리

      public Data(int r, int c, int cnt, int dis) {
         this.r = r;
         this.c = c;
         this.cnt = cnt;
         this.dis = dis;
      }
   }
}