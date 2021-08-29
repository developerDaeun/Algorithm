import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10158_개미 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 격자판
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		// 개미의 초기 좌표 ( 0<p<w, 0<q<h )
		st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());

		int t = Integer.parseInt(br.readLine());	// 개미가 움직일 시간

		// (p+t)%(w*2) => 개미가 이동한 p 좌표 (0,1,2,3,4,5,6,5,4,3,2,1) 을 반복적으로 움직임 => % 사용
		// (q+t)%(h*2) => 개미가 이동한 q 좌표 (0,1,2,3,4,3,2,1) 을 반복적으로 움직임 => % 사용 
		// 그 결과가 w보다 작으면 그대로, w보다 크면 w로 mod (w이상의 위치에 있으므로)
		// 그 결과가 h보다 작으면 그대로, h보다 크면 h로 mod (h이상의 위치에 있으므로)
		
		p = (p+t)%(w*2);
		q = (q+t)%(h*2);
		if(p > w) p = w - Math.abs(w-p);
		if(q > h) q = h - Math.abs(h-q);
		
		sb.append(p).append(" ").append(q);
		System.out.println(sb);		// sysout p + " " + q 로 하니 시간 초과 뜸...
	}
}