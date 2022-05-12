import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_8911_거북이 {

    static int[][] map;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());    // 테케수
        for(int t = 0; t < T; t++){
            String s = br.readLine();
            map = new int[1000][1000];
            for(int i = 0; i < s.length(); i++){
                move(s.charAt(i));
            }

            int area = 0;   // 답

            sb.append(area).append("\n");
        }

        System.out.print(sb);
    }

    static void move(char c){

    }
}
