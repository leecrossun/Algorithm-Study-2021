package level14_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_2156 {
	static int N;
	static int[] dp;
	static int arr[];
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		dp = new int[N + 1];
		arr = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		dp[1] = arr[1];
		if(N > 1) dp[2] = arr[1] + arr[2];
		
		for (int i = 3; i <= N; i++) {
//			n-1��° ���� ���� -> n-3 ���� ���� / n-1��° ������ ���� -> n-2 ���� ����
			dp[i] = Math.max(dp[i - 3] + arr[i] + arr[i - 1] , dp[i - 2] + arr[i]);
			
//			�׻� �������� ���ž��ϴ� ��X + �������� 2���̻� ������ ���� �� ����.
			dp[i] = Math.max(dp[i - 1], dp[i]);
		}
		System.out.println(dp[N]);
	}
}
