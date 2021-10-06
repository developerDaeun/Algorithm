import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2239_스도쿠 {

	static int[][] sudoku;
	static boolean[][] rCheck, cCheck, Check;	// 행, 열, 3*3 숫자 체크 배열
	static boolean end;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		sudoku = new int[9][9];
		rCheck = new boolean[9][9];
		cCheck = new boolean[9][9];
		Check = new boolean[9][9];
		
		// 스도쿠 입력받기
		String s;
		char c[];
		for(int i = 0; i < 9; i++) {
			s = br.readLine();
			c = s.toCharArray();
			for(int j = 0; j < 9; j++) {
				sudoku[i][j] = Integer.parseInt(Character.toString(c[j]));
				if(sudoku[i][j]!=0) {	// 행, 열, 3*3 숫자 체크
					rCheck[i][sudoku[i][j]-1] = true;
					cCheck[j][sudoku[i][j]-1] = true;
					Check[(i/3)*3 + j/3][sudoku[i][j]-1] = true;	// 0~8개 사각형마다 체크
				}
			}
		}
		
		dfs(0);
		
		// 스도쿠 출력
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				sb.append(sudoku[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
	}

	static void dfs(int cnt) {
		if(cnt == 81) {	// 스도쿠를 모두 다 채웠으면 리턴
			end = true;
			return;
		}
		
		int r = cnt/9;
		int c = cnt%9;
		
		if(sudoku[r][c]==0) {	// 숫자가 채워지지 않았을때 없는 숫자로 채우기
			for(int i = 0; i < 9; i++) {
				// 행, 열, 사각형에 없는 숫자이면 채우기
				if(!rCheck[r][i] && !cCheck[c][i] && !Check[(r/3)*3 + c/3][i]) {
					rCheck[r][i] = true;
					cCheck[c][i] = true;
					Check[(r/3)*3 + c/3][i] = true;
					sudoku[r][c] = i+1;
					
					dfs(cnt+1);
					
					if(end) return;
					
					rCheck[r][i] = false;
					cCheck[c][i] = false;
					Check[(r/3)*3 + c/3][i] = false;
					sudoku[r][c] = 0;
				}
			}
		}
		else dfs(cnt+1);	// 숫자가 채워져 있을때는 개수만 + 1
	}
}