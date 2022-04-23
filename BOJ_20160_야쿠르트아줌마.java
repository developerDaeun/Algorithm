import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_20160_야쿠르트아줌마 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        ArrayList<Data>[] list = new ArrayList[V + 1];
        for(int i = 1; i <= V; i++){
            list[i] = new ArrayList<>();
        }

        int start, end, w;
        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            list[start].add(new Data(end, w));
            list[end].add(new Data(start, w));
        }
        
        int startNum = Integer.parseInt(br.readLine()); // 내가 출발하는 정점 번호
    }

    static class Data{
        int end, w;

        public Data(int end, int w) {
            this.end = end;
            this.w = w;
        }
    }
}
