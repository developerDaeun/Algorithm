import java.io.BufferedReader;
import java.io.InputStreamReader;

// 1~N번 방까지 갈 때 최소 몇개의 방을 지나는지 출력
public class BOJ_2292_벌집 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long N = Integer.parseInt(br.readLine());
		
		int start = 1, end = 1, res = 1;
		while(true) {
			if(N >= start && N <= end) {
				break;
			}
			start = end + 1;	// 이전 end값의 +1이 현재 start
			end += 6*res;			// 6,12,18..  -> 6의 배수만큼 더하는 수가 커짐
			res++;
		}
		
		System.out.println(res);
	}
}