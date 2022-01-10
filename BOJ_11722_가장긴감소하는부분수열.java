import java.io.*;
import java.util.*;

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
			for(int j = 0; j < i; j++) {	// 앞의 수 : j, 뒤 : i 비교
				if(a[j] > a[i]) {	// 앞의 수가 더 클때
					arr[i] = Math.max(arr[i], arr[j] + 1);
				}
			}
		}
		
		Arrays.sort(arr);
		
		System.out.println(arr[N-1] + 1);
	}
}