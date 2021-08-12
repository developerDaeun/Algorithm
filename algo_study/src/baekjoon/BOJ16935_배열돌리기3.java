import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ16935_배열돌리기3 {

	static int N;
	static int M;
	static String[][] arr;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());	// 연산 횟수
		
		arr = new String[N][M];
		String[] no = new String[R];	// 연산 번호 저장할 배열
		
		// 배열 입력 받기
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				arr[i][j] = st.nextToken();
			}
		}
		
		// 연산 횟수만큼 수행할 연산 번호 저장
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < R; i++) {
			no[i] = st.nextToken();
		}
		 
		for(int r = 0; r < R; r++) {	// 연산 횟수
			switch(no[r]) {
			case "1" :	// 상하반전
				case1();
				break;
			case "2" :	// 좌우반전
				case2();
				break;
			case "3" :	// 오른쪽 90도 회전
				case3();
				break;
			case "4" :	// 왼쪽 90도 회전
				case4();
				break;
			case "5" :	// 4분할, 오른쪽 90도 회전
				case5();
				break;
			case "6" :	// 4분할, 왼쪽 90도 회전
				case6();
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
	
	static void case1() {	// 상하 스왑
		for(int i = 0; i < N/2; i++) {	// 행의 반을 기준으로 상하 스왑
			for(int j = 0; j < M; j++) { 
				String tmp = arr[i][j];
				arr[i][j] = arr[N-1-i][j];
				arr[N-1-i][j] = tmp;
			}
		}
	}
	static void case2() {	// 좌우 스왑
		for(int j = 0; j < M/2; j++) {	// 열의 반을 기준으로 좌우 스왑
			for(int i = 0; i < N; i++) { 
				String tmp = arr[i][j];
				arr[i][j] = arr[i][M-1-j];
				arr[i][M-1-j] = tmp;
			}
		}
	}
	static void case3() {	// 오른쪽 90도 회전
		String[][] tempArr = new String[M][N];	// N*M -> M*N 배열로 저장하기
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				tempArr[j][N-1-i] = arr[i][j];	// arr의 열이 tempArr의 행이 되므로 j값은 그대로, tempArr의 열은 arr의 열 끝 인덱스이므로 N-1 에서 i만큼 뺌
			}
		}
		arr = tempArr;
		int temp = M;
		M = N;
		N = temp;
	}
	static void case4() {	// 왼쪽 90도 회전
		String[][] tempArr = new String[M][N];	// N*M -> M*N 배열로 저장하기
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				tempArr[M-1-j][i] = arr[i][j];	// arr의 행이 tempArr의 열이 되므로 i값은 그대로, tempArr의 행은 arr의 행 끝 인덱스이므로 M-1 에서 j만큼 뺌
			}
		}
		arr = tempArr;
		int temp = M;
		M = N;
		N = temp;
	}
	static void case5() {	// 4개의 부분배열로 나누고 오른쪽 90도 회전
		for(int i = 0; i < N/2; i++) {
			for(int j = 0; j < M/2; j++) {
				String temp = arr[i][j];	// 1번 temp에 저장
				arr[i][j] = arr[i + N/2][j];	// 4번->1번
				arr[i + N/2][j] = arr[i + N/2][j + M/2];	// 3번->4번
				arr[i + N/2][j + M/2] = arr[i][j + M/2];	// 2번->3번
				arr[i][j + M/2] = temp;	// 1번->2번
			}
		}
	}
	static void case6() {	// 4개의 부분배열로 나누고 왼쪽 90도 회전
		for(int i = 0; i < N/2; i++) {
			for(int j = 0; j < M/2; j++) {
				String temp = arr[i][j];	// 1번 temp에 저장
				arr[i][j] = arr[i][j + M/2];	// 2번->1번
				arr[i][j + M/2] = arr[i + N/2][j + M/2];	// 3번->2번
				arr[i + N/2][j + M/2] = arr[i + N/2][j];	// 4번->3번
				arr[i + N/2][j] = temp;	// 1번->4번
			}
		}
	}
}