import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1158 {
	
	static int N;
	static int K;
	static List<Integer> list;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		list = new ArrayList<Integer>(); // 처음 사람 저장하는 리스트
		for(int i = 0; i < N; i++) {	// 사람 번호 적는 배열 생성
			list.add(i+1);
		}
		
//		사람 제거하기
		int idx = 0;	// 현재 제거할 인덱스
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		for(int i = 0; i < N; i++) {
			idx = (idx+K-1)%list.size();	// 다음 제거할 사람의 인덱스
			sb.append(list.get(idx)).append(", ");	// 현재 사람을 요세푸스 순열에 추가	
			list.remove(idx);	// 현재 사람을 리스트에서 제거
		}
		sb.setLength(sb.length()-2);
		sb.append(">");
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}