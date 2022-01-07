import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_10451_순열사이클 {

	static int N, arr[];
	static int[] parents;
	static Edge[] edges;

	static class Edge{
		int start, end;

		public Edge(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
	
	static int find(int a, int goal) {
		if(a==parents[a]) return a;
		if(parents[a]==goal) return parents[a];
		
		return parents[a] = find(parents[a], goal);
	}
	
	static boolean union(int a, int b) {
		a = find(a, a);
		b = find(b, b);
		if(a==b) return false;
		
		parents[b] = a;
		return true;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			
			// make
			parents = new int[N+1];
			
			edges = new Edge[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= N; i++) {
				int end = Integer.parseInt(st.nextToken());
				parents[end] = i;
				edges[i-1] = new Edge(i, end);
			}
			
			for(Edge edge : edges) {
				union(edge.start, edge.end);
			}
			
			Set<Integer> set = new HashSet<>();
			
			for(int i = 1; i <= N; i++) {
				set.add(parents[i]);
			}
			
			System.out.println(set.size());
		}
	}

}