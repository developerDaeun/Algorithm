import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ11723_집합 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		int M = Integer.parseInt(br.readLine());
		int S = 0;
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String s = st.nextToken();
			
			switch(s){
			
			case "all" :	// "all" 일때 S를 {1,2,...,20} 으로 바꾼다.
				S = -1;
				break;	
			case "empty" :	// "empty" 일때 S를 공집합으로 바꾼다.
				S = 0;
				break;
			default :	// add, remove, check, toggle일때 x를 읽는다.(1 <= x <= 20)
				int num = Integer.parseInt(st.nextToken());
				switch(s) {
				case "add":
					S = S | 1<<num-1;	// 현재 num이 없으면 S에 추가	
					break;
				case "remove":
					S = (S & 1<<num-1) != 0 ? S-(1<<num-1) : S; // 현재 num이 있으면 S에서 제거
					break;	
				case "check":
					bw.write((S & 1<<num-1)!=0 ? "1\n" : "0\n");	// 현재 num이 있으면 1, 없으면 0 출력
					break;
				case "toggle":
					S = (S & 1<<num-1)!=0 ? S-(1<<num-1) : S|1<<num-1;	// 현재 S에 num이 있으면 제거, 없으면 추가
					break;
				}
			}
		}
		bw.close();
	}
}