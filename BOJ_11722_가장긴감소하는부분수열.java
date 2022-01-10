import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11722_가장긴감소하는부분수열 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] a = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] arr = new int[N];

		for(int i = 0; i < N; i++) {
			arr[i] = 1;
			for(int j = 0; j < i; j++) {	// 앞의 수 : j, 뒤 : i 비교
				if(a[j] > a[i]) {
					arr[i] = Math.max(arr[i], arr[j] + 1);
				}
			}
		}
		
		Arrays.sort(arr);
		
		System.out.println(arr[arr.length-1]);
	}
}