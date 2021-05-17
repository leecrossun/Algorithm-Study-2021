package level14_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_10844 {
	static int N;
	
	static Long[][] dp;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		dp = new Long[N + 1][10];
		
		// ù��° �ڸ����� 1�� �ʱ�ȭ 
		for(int i = 0; i < 10; i++) {
			dp[1][i] = 1L;
		}
		
		long total = 0;
		for (int i = 1; i <= 9; i++) {
			total += stairNum(N, i);
		}
		System.out.println(total % 1000000000);
	}
	
	public static long stairNum(int depth, int idx) {
		if (depth == 1 ) return dp[depth][idx];
		
		if (dp[depth][idx] == null) {
			if (idx == 0) { // idx�� 0�϶��� idx + 1�� ����(������ �� �� ����)
				dp[depth][idx] = stairNum(depth - 1, idx + 1);
			}
			else if(idx == 9) { // idx�� 9�϶��� idx - 1�� ����(idx�� ���� 0-9)
				dp[depth][idx] = stairNum(depth - 1, idx - 1);
			}
			else {
				dp[depth][idx] = (stairNum(depth - 1, idx + 1) + stairNum(depth - 1, idx - 1));
			}
	}

		return dp[depth][idx] % 1000000000;
		
	}

}
