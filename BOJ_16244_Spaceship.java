import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [입력]
 * 외계인이 가지고있는 f[i]의 power
 * [출력]
 * 파괴되는 적의 순서대로 power 출력
 * [조건]
 * 마지막에 물리친 적의 power == 모든 다른 적들의 power의 합
 */
public class BOJ_16244_Spaceship {

	public static void main(String[] a) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] p = new int[n];
		int sum = 0;	// 모든 외계인의 power 합
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			p[i] = Integer.parseInt(st.nextToken());
			sum += p[i];
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			if(sum - p[i] == p[i]) {
				for(int j = 0; j < n; j++) {
					if(i!=j) {
						sb.append(p[j] + " ");
					}
				}
				sb.append(p[i]);
				break;
			}
		}
		
		System.out.print(sb);
	}
}