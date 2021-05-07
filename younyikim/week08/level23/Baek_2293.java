package level23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_2293 {
	static int N;
	static int K;
	static int[] dp;
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        dp = new int[K + 1];
        dp[0] = 1;

        /*	
         *  �־��� ������ ��ġ�� ����Ͽ� ����(K)�� ��Ÿ���� �����  dp�� �����Ѵ�.
         *  j = i���� �����Ѵ�.
         *  dp[j] += dp[j - i]�� �ϰ�, dp[K]�� ���� �츮�� ���ϰ����ϴ�
         *  ���� K���� �Ǵ� ����� ����.
         *  
         *    0 1 2 3 4 5 6 7 8 9 10
         *  1��  1 1 1 1 1 1 1 1 1 1 1 
		    2��         2 2 3 3 4 4 5 5 6 
       	    5��                   4 5 6 7 8 10
         */
        for (int x = 0; x < N; x++) {
        	int i = Integer.parseInt(br.readLine());
        	System.out.println();
        	for (int j = i; j <= K; j++) {
        			dp[j] += dp[j - i];
        	}
        }
        System.out.println(dp[K]);
	}
}
