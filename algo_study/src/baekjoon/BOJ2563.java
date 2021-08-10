import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ2563 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[101][101];
		int total = N*100;	// N개 색종이의 넓이 합
		
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for(int i = x; i < x+10; i++) {	// 색종이의 넓이만큼 map에서 +1
				for(int j = y; j < y+10; j++) {
					if(map[i][j] >= 1) {	// 색종이가 겹치면 부분이 있으면 전체 색종이 넓이인 total에서 -1
						total--;
					}else {		// 겹치는 색종이가 없으므로 현재 색종이 영역 +1
						map[i][j]++;
					}
				}
			}
		}
		bw.write(String.valueOf(total));
		bw.flush();
		bw.close();	
	}
}