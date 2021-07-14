package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_14501 {
	
	public static int N;
	public static int[] dp;
	public static int[] Time;
	public static int[] Pay;
	
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		Time = new int[N + 2];
		Pay = new int[N + 2];
		dp = new int[N + 2];
		
		StringTokenizer st;
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			Time[i] = Integer.parseInt(st.nextToken());
			Pay[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = N; i >= 1; i--)  {
			int next = i + Time[i];
			
			// ���� �� �ִ� ��¥�� �Ѿ�� ���, ����� �ʿ� �����Ƿ� �ٷ� ���� dp �� ���
			if(next > N + 1) { 
				dp[i] = dp[i + 1];
			} 
			// �ݾ��� �ִ��� ���
			else {
				dp[i] = Math.max(dp[i + 1], dp[next] + Pay[i]);
			}
		}
		
		System.out.println(dp[1]);
	}
}
