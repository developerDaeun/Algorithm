import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2527_직사각형 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		for(int t = 0; t < 4; t++) {	// 4번 테스트
			st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());	// 첫번째 사각형
			int y1 = Integer.parseInt(st.nextToken());
			int p1 = Integer.parseInt(st.nextToken());
			int q1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());	// 두번째 사각형
			int y2 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());
			int q2 = Integer.parseInt(st.nextToken());

			// 점이 겹칠 때 => c
			if((p1==x2&&q1==y2) || (p2==x1&&q2==y1) || (p1==x2&&y1==q2) || (p2==x1&&y2==q1)) {
				sb.append("c\n");
			}else if(p1<x2 || p2<x1 || q1<y2 || q2<y1) {	// 겹치지 않을 때 => d
				sb.append("d\n");
			}else if(y1==q2 || q1==y2 || p1==x2 || p2==x1) {	// 선이 겹칠 때 => b
				sb.append("b\n");
			}else {	// 겹치는 부분이 직사각형일 때 => a
				sb.append("a\n");
			}
		}
		
		System.out.println(sb);
	}
}