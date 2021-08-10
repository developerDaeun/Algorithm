package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7576 {

	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int M;
	static int N;
	static int[][] arr;
	static int min = -1;
	static Queue<Tomato> queue = new LinkedList<>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		
		int allOne = 0;
		for(int i = 0; i < N; i++) {	// 토마토 상자 입력 받기
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				// 토마토가 모두 익어있는 상태이면 (1, -1)일 때 이므로 allOne+1
				if(arr[i][j]==1) { 
					allOne++;
					queue.offer(new Tomato(i,j,0)); // 토마토가 익어있으면 queue 삽입
				}else if(arr[i][j]==-1) {
					allOne++;
				}
			}
		}
		
		if(allOne == N*M) {	// 모든 토마토가 익어있는 상태면 0 출력
			min = 0;
		}else{		// 모든 토마토가 익을 때 까지 돌기
			bfs();
		}
		bw.write(String.valueOf(min));
		bw.close();
	}

	static void bfs() {
		while(!queue.isEmpty()) {
			Tomato tomato = queue.poll();	// 현재 토마토 dequeue
			for(int k = 0; k < 4; k++) {	// 사방탐색
				int row = tomato.row + dr[k];
				int col = tomato.col + dc[k];
				if(row < 0 || row >= N || col < 0 || col >= M || arr[row][col]==-1) {	// 범위 벗어나거나 토마토가 없는 위치인 -1이 있으면 리턴
					continue;
				}
				if(arr[row][col] == 0) {	// 현재 토마토의 (상or하or좌or우)가 익지 않았을 때 현재 토마토의 day+1
					arr[row][col] = tomato.day+1;
					queue.offer(new Tomato(row, col, tomato.day+1));
				}else {		// 현재 토마토의 (상or하or좌or우)가 익은 상태일 때 원래 day보다 더 작은 day를 저장
					if(arr[row][col] > tomato.day+1) {
						arr[row][col] = tomato.day+1;
					}
				}
			}
		}
		
		end : for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(arr[i][j]==0) {	// 하나라도 0이 있으면 토마토가 익은 것이 없으므로 -1 출력
					min = -1;
					break end;
				}
				if(min < arr[i][j]) {	// 가장 높은 숫자를 최소 일수로 저장
					min = arr[i][j];
				}
			}
		}
	}
}

class Tomato{
	int row;
	int col;
	int day;
	
	Tomato(int row, int col, int day){
		this.row = row;
		this.col = col;
		this.day = day;
	}
}