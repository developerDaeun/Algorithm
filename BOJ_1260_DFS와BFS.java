import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260_DFS와BFS {

	static int N, M, V;
	static ArrayList<Integer>[] list;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());	// 정점개수
		M = Integer.parseInt(st.nextToken());	// 간선개수
		V = Integer.parseInt(st.nextToken());	// 시작 정점번호
		
		list = new ArrayList[N+1];
		for(int i = 1; i < N+1; i++) {	// 인접 리스트 생성
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {	// 인접 리스트 삽입
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			list[from].add(to);
			list[to].add(from);
		}
		
		for(int i = 1; i < N+1; i++) {
			list[i].sort((o1,o2) -> (o1-o2));	// 오름차순 정렬
		}
		
		// dfs
		visited = new boolean[N+1];
		dfs(V, visited);	
		sb.append("\n");
		
		// bfs
		visited = new boolean[N+1];
		bfs(V, visited);	
		System.out.println(sb);
	}

	static void dfs(int current, boolean[] visited) {
		visited[current] = true;	// 방문체크
		sb.append(current + " ");
		
		for(Integer temp : list[current]) {	// 현재 정점의 자식중 방문되지 않은곳을 깊이 탐색
			if(!visited[temp]) {
				dfs(temp, visited);
			}
		}
	}

	static void bfs(int current, boolean[] visited) {
		Queue<Integer> queue = new LinkedList<>();
		
		queue.offer(current);	// 처음 정점 큐에 삽입, 방문체크
		visited[current] = true;
		
		while(!queue.isEmpty()) {
			current = queue.poll();		// 큐에서 하나씩 빼기
			sb.append(current+" ");
			for(Integer temp : list[current]) {	// 현재 정점의 자식중 방문되지 않은 곳을 하나씩 큐에 삽입, 방문체크
				if(!visited[temp]) {
					queue.offer(temp);
					visited[temp] = true;
				}
			}
		}
	}
}