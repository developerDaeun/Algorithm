import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_14433_한조대기중 {

    static int N, M;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 한 팀에 속한 플레이어 수
        M = Integer.parseInt(st.nextToken());   // 총 트롤픽 수
        int K1 = Integer.parseInt(st.nextToken());  // 첫번째 팀이 원하는 트롤픽 수
        int K2 = Integer.parseInt(st.nextToken());  // 두번째 팀이 원하는 트롤픽 수
        List[] T1 = new ArrayList[N+1];    // 첫번째 팀의 트롤픽 정보
        List[] T2 = new ArrayList[N+1];    // 두번째 팀의 트롤픽 정보
        int[] Goal1 = new int[M+1]; // 목표 노드에 연결된 첫번째 팀의 플레이어 번호 저장
        int[] Goal2 = new int[M+1]; // 목표 노드에 연결된 두번째 팀의 플레이어 번호 저장
        boolean[] isPick1 = new boolean[M+1];   // 목표 노드가 사용중인지 체크
        boolean[] isPick2 = new boolean[M+1];   // 목표 노드가 사용중인지 체크

        for (int i = 1; i < N+1; i++){
            T1[i] = new ArrayList<>();
            T2[i] = new ArrayList<>();
        }

        // 첫번째 팀(욱제 팀)의 트롤픽 정보
        for (int i = 0; i < K1; i++){
          st = new StringTokenizer(br.readLine());
          int start = Integer.parseInt(st.nextToken());
          int end = Integer.parseInt(st.nextToken());
          T1[start].add(end);
        }

        // 두번째 팀(상대 팀)의 트롤픽 정보
        for (int i = 0; i < K2; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            T2[start].add(end);
        }

        // 이분 매칭
        int cnt1 = 0;
        for (int i = 1; i <= N; i++){
            Arrays.fill(isPick1, false);
            if(dfs(i, T1, Goal1, isPick1)) cnt1++;
        }

        int cnt2 = 0;
        for (int i = 1; i <= N; i++){
            Arrays.fill(isPick2, false);
            if(dfs(i, T2, Goal2, isPick2)) cnt2++;
        }

        System.out.print(cnt1 < cnt2 ? "네 다음 힐딱이" : "그만 알아보자");
    }

    static boolean dfs(int num, List[] T, int[] Goal, boolean[] isPick){
        for (int i = 0; i < T[num].size(); i++){
            int here = (int) T[num].get(i);
            if(isPick[here]) continue;
            isPick[here] = true;

            if(Goal[here] == 0 || dfs(Goal[here], T, Goal, isPick)){
                Goal[here] = num;
                return true;
            }
        }

        return false;
    }
}