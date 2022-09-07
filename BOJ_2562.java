import java.util.*;

public class BOJ_2562 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int idx = 0;
        int max = 0;
    	for(int i = 0; i < 9; i++){
            int num = sc.nextInt();
            if(max < num){
                idx = i + 1;
                max = num;
            } 
        }
        
        System.out.print(max + "\n" + idx);
	}
}