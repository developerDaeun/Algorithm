import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1992_쿼드트리 {

	static int N;
	static int[][] map;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());	// 영상의 크기
		map = new int[N][N];	// N*N 영상 배열 
		
		// 영상 배열 입력
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		cut(0,0,N);
		
		System.out.println(sb);
	}

	static void cut(int r, int c, int size) {
		
		int sum = 0;
		for(int i = r; i < r+size; i++) {	// 현재 사이즈의 합 계산
			for(int j = c; j < c+size; j++) {
				sum += map[i][j];
			}
		}
		
		// 같은 색인지 체크
		if(sum == 0) {	// 현재 사이즈가 모두 0일때
			sb.append("0");
		}else if(sum == size*size) {	// 현재 사이즈가 모두 1일때
			sb.append("1");
		}else {	// 0,1 섞여있을때 4분할
			
			sb.append("(");	// 같은 색이 아닐 때 괄호 열기
			
			int half = size/2;
			cut(r,c,half);	// 왼쪽 위
			cut(r, c+half, half);	// 오른쪽 위
			cut(r+half, c, half);	// 왼쪽 아래
			cut(r+half, c+half, half);	// 오른쪽 아래
			
			sb.append(")");	// 괄호 닫기
		}	
	}
}