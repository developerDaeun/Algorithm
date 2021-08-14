import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ16926_배열돌리기1 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][M];
		
		// 배열 입력 받기
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int minNM = Math.min(N, M) / 2;		// (N, M 중에서 최소값)/2-1 만큼의 사이클이 생김
		int temp;	// 이전 값 저장
		int cur;	// 현재 값 저장
		
		for(int r = 0; r < R; r++) {	// 회전 수
			for(int k = 0; k < minNM; k++) {		// 배열의 반 - 1 만큼의 사이클 돌기, 시작 위치 : (k,k)
				
				// 시작 위치 값을 temp에 저장
				temp = arr[k][k];
				
				// 아래방향
				for(int i = k+1; i < N-k; i++) {	// 이전값과 현재값 swap
					cur = arr[i][k];
					arr[i][k] = temp;
					temp = cur;
				}
				
				// 오른쪽방향
				for(int j = k+1; j < M-k; j++) {	// 이전값과 현재값 swap
					cur = arr[N-k-1][j];
					arr[N-k-1][j] = temp;
					temp = cur;
				}
				
				// 위쪽방향
				for(int i = N-k-2; i >= k; i--) {	// 이전값과 현재값 swap
					cur = arr[i][M-k-1];
					arr[i][M-k-1] = temp;
					temp = cur;
				}
				
				// 왼쪽방향
				for(int j = M-k-2; j >= k; j--) {	// 이전값과 현재값 swap
					cur = arr[k][j];
					arr[k][j] = temp;
					temp = cur;
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				bw.write(arr[i][j] + " ");
			}
			bw.write("\n");
		}
		bw.close();
	}
}