import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ2961_도영이가만든맛있는음식 {

	static ArrayList<Item> list = new ArrayList<>();
	static long min = Long.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine(), " ");	
			list.add(new Item(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken())));	// 신맛, 쓴맛 입력
		}
		
		calc(0,1,0,0);	// 처음 재료의 신맛은 곱해야하므로 1 지정
		
		bw.write(String.valueOf(min));
		bw.close();
	}
	static void calc(int start, long mulS, long mulB, int flag) {
		for(int i = start; i < list.size(); i++) {
			if((flag & 1<<i)!=0) continue;	// 현재 재료를 선택했으면 continue 
			calc(i+1, mulS*list.get(i).s, mulB+list.get(i).b, flag|1<<i);	// 신맛*현재신맛, 쓴맛*현재쓴맛, 방문 체크 flag
			min = Math.min(min, Math.abs(mulS*list.get(i).s-(mulB+list.get(i).b)));	// 현재 재료와 비교해 최소값 찾기
		}
	}
}
class Item{		// 재료 클래스
	long s;
	long b;
	public Item(long s, long b) {
		this.s = s;
		this.b = b;
	}
}