import java.util.StringTokenizer;
import java.io.*;

public class BOJ_1546 {
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     	int N = Integer.parseInt(br.readLine());
        int[] score = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;
        for(int i = 0; i < N; i++){
            score[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, score[i]);
        }  
        
        double total = 0;
        for(int i = 0; i < N; i++){
            total += (double)score[i] / max * 100;
        }
        
        System.out.print((double)total / N);
	}
}