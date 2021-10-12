import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_17143_낚시왕 {

	static int R, C, M;
	static Data[][] sharks;
	static int res;
	static int[] dr = {0,-1,1,0,0};	// 상,하,우,좌
	static int[] dc = {0,0,0,1,-1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		R = Integer.parseInt(s[0]);
		C = Integer.parseInt(s[1]);
		M = Integer.parseInt(s[2]);	// 상어 수
		
		// 상어의 속력(s), 이동방향(d), 크기(z) 입력받아 클래스 배열에 넣기
		sharks = new Data[R+2][C+2];
		
		for(int i = 0; i < M; i++) {
			s = br.readLine().split(" ");
			int r = Integer.parseInt(s[0]);
			int c = Integer.parseInt(s[1]);
			int speed = Integer.parseInt(s[2]);
			int d = Integer.parseInt(s[3]);
			
			// 시간초과 ... => 속력 범위 줄이기 (제자리로 돌아오는 속력값으로 나눈 나머지 구하기)
			//상하로 움직이는 경우
			if (d <= 2) speed = speed % ((R-1) * 2);
			//좌우로 움직이는 경우
			else speed = speed % ((C-1) * 2); 
			
			sharks[r][c] = new Data(r, c, speed, d, Integer.parseInt(s[4]));
		}
		
		for(int c = 1; c <= C; c++) {
			// 1. 가장 가까운 상어 찾아서 잡아먹기
			kill(c);
			// 마지막 열까지 오면 stop
			if(c==C) break;	
			// 2. 상어 이동하면서 큰 상어는 작은 상어 잡아먹기
			move();
		}
		
		System.out.print(res);
	}
	
	static void kill(int here) {
		for(int r = 1; r <= R; r++) {
			if(sharks[r][here]==null) continue;	// 잡아먹을 상어가 없으면 next
			
			// 잡아먹을 상어가 있을때
			res += sharks[r][here].z;	// 상어 크기 합하기
			sharks[r][here] = null;	// 잡아먹은 상어 없애기
			break;
		}
	}
	
	static void move() {
		
		ArrayList<Data> list = new ArrayList<>();
		
		Data cur;
		for(int r = 1; r <= R; r++) {
			for(int c = 1; c <= C; c++) {
				if(sharks[r][c]==null) continue;	// 상어가 없으면 next
				
				cur = sharks[r][c];	// 현재 상어
				int nr = r, nc = c;
				
				//상어가 이동할 위치 찾기
				for(int s = 0; s < cur.s; s++) {	// 현재 상어의 속력만큼
					// 행이 0밑(위1->아래2로 변경), 열이 C이상(오른쪽3->왼쪽4으로 변경) => 현재방향 인덱스 + 1
					if(nr+dr[cur.d]<1 || nc+dc[cur.d]>C)	
						cur.d += 1;
					// 아래->위 / 왼쪽->오른쪽 => 현재방향 인덱스 - 1
					else if(nr+dr[cur.d]>R || nc+dc[cur.d]<1)
						cur.d -= 1;	
					nr += dr[cur.d];
					nc += dc[cur.d];
				}
				
				// 상어가 이동할 위치를 리스트에 담기
				list.add(new Data(nr, nc, cur.s, cur.d, cur.z));
				sharks[r][c] = null;	// 원래 위치 상어 없애기
			}
		}
		
		// 상어 이동
		for(int i = 0; i < list.size(); i++) {
			cur = list.get(i);
			if(sharks[cur.r][cur.c]!=null) {	// 이미 상어가 있는 위치이면 크기가 큰 상어로 변경
				if(sharks[cur.r][cur.c].z < cur.z) {
					sharks[cur.r][cur.c].s = cur.s;
					sharks[cur.r][cur.c].d = cur.d;
					sharks[cur.r][cur.c].z = cur.z;
				}
			}else sharks[cur.r][cur.c] = cur;	// 상어가 없는 위치이면 이동
		}
	}

	static class Data{
		int r,c,s,d,z;	// 상어의 위치(행,열), 속력, 이동방향, 크기
		
		public Data(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}
}