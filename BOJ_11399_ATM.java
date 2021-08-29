import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11399_ATM {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);	// 시간이 적게 걸리는 사람 순서대로 정렬
		
		int before = 0;
		int total = 0;
		for(int i = 0; i < N; i++) {
			total = total + before + arr[i];	// 이전 사람시간 + 현재 사람 시간
			before += arr[i];	// 이전사람시간을 현재사람시간까지로 변경
		}
		
		System.out.println(total);
	}
}