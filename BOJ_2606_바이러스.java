import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2606_바이러스 {

    static int n, edges, res;
    static boolean[][] arr;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());    // 컴퓨터 수
        edges = Integer.parseInt(br.readLine());    // 컴퓨터 쌍의 수 (간선 수)
        arr = new boolean[n+1][n+1];    // 인접행렬 (컴퓨터 수는 100 이하이므로 101 * 101 가능)

        StringTokenizer st;
        int start, end;

        for (int i = 0; i < edges; i++){
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            arr[start][end] = true;
            arr[end][start] = true;
        }

        bfs();

        System.out.print(res);
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        boolean[] v = new boolean[n+1];

        q.offer(1);
        v[1] = true;
        int cur;
        while (!q.isEmpty()){
           cur = q.poll();

           for (int i = 1; i < n+1; i++){
               if(v[i]) continue;

               // 현재 컴퓨터와 인접할 때
               if(arr[cur][i] || arr[i][cur]){
                   q.offer(i);
                   v[i] = true;
                   res++;
               }
           }
        }
    }
}