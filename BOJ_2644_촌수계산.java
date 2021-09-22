import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2644_촌수계산 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());	// 전체 사람의 수
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n1 = Integer.parseInt(st.nextToken());	// 촌수 계산할 사람1
		int n2 = Integer.parseInt(st.nextToken());	// 촌수 계산할 사람2
		int m = Integer.parseInt(br.readLine());	// 촌수 관계 수
		ArrayList<Integer>[] parents = new ArrayList[n+1];	// 부모 번호 저장 배열
		
		for (int i = 1; i <= n; i++) {
			parents[i] = new ArrayList<>();
		}
		
		// 부모 번호 저장
		int x, y;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());	// 부모
			y = Integer.parseInt(st.nextToken());	// 자식
			parents[y].add(x);
		}
		
		// i 의 조상 찾아서 parents[i] 에 더하기
		int temp;
		for(int i = 1; i <= n; i++) {
			// i 의 부모가 있으면 반복
			if(!parents[i].isEmpty()) {
				while(true) {
					temp = parents[i].get(parents[i].size()-1);	// i 의 조상(부모포함)
					if(parents[temp].isEmpty()) break;	// 더이상 조상이 없으면 break
					if(parents[temp].get(0) == temp) // 마지막 조상까지 왔으면 break	
						break;	
					else parents[i].add(parents[temp].get(0));	// // temp의 부모가 있으면 더하기
				}
			}else parents[i].add(i);	// 비어있으면 부모가 없는 루트이므로 자기자신을 저장
		}
		
		// n1의 조상 중 n2와 같은 조상 찾기
		for(int i = 0; i < parents[n1].size(); i++) {
			// n1의 조상이 n2라면, 인덱스+1이 결과
			if(parents[n1].get(i) == n2) {
				System.out.print(i+1);
				return;
			}
			// n1의 조상과 n2의 조상 비교
			for (int j = 0; j < parents[n2].size(); j++) {
				// n2의 조상이 n1이라면, 인덱스+1이 결과
				if(parents[n2].get(j) == n1) {
					System.out.println(j+1);
					return;
				}
				// 같은 조상을 찾으면 (n1의 조상까지의 인덱스 + n2의 조상까지의 인덱스) => 결과
				if(parents[n1].get(i) == parents[n2].get(j)) {
					System.out.print(i+1 + j+1);
					return;
				}
			}
		}

		// 같은 조상이 없으면 -1 출력
		System.out.print("-1");
	}
}