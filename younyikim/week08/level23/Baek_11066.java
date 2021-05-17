package level23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_11066 {
	static int N;
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        while(T --> 0) {
        	N = Integer.parseInt(br.readLine());
        	int[] arr = new int[N];
        	
        	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < N; i++) {
            	arr[i] = Integer.parseInt(st.nextToken());
            }
            sb.append(solve(arr)).append('\n');
        }
        System.out.println(sb);
	} 	

	public static int sum(int[] sum, int i, int j) {
		if (i == 0) 
			return sum[j];
		else 
			return sum[j] - sum[i - 1];
	}
	
	/*
	 * dp[i][j]�� i�� ���������� j�� ���������� �������� ���� �ּҰ�
	 * 
	 * dp[i][i]�϶�, i���� i�� ���������� ���� i��° ������ ���� arr[i],
	 * 1) dp[i][i] = arr[i];
	 * 
	 * dp[i][i + 1]�϶�, i���� i + 1�� ������������ ���� (��, ���ӵ� �������� �� ex. 1-2p, 2-3p,,)
	 * 2 ) dp[i][i + 1] = arr[i] + arr[i + 1]
	 * 
	 * dp[i][i + 2]�϶�, 
	 * dp[i][i] + dp[i + 1][i + 2] + (arr[i] + arr[i + 1] + arr[i + 2]) ��
	 * dp[i][i + 1] + dp[i + 2][i + 2] + (arr[i] + arr[i + 1] + arr[i + 2]) �� ���� ���̴�.
	 * 
	 * ���� ��� dp[1][3]�� 1~3�������� ���� �ּҰ��̴�. (1,2) + 3 or 1,(2,3) �ΰ��� ������� ���� �����ϴ�.
	 * dp[1][1] + dp[2][3] + (1~3�������� ���� ��) vs dp[1][2] + dp[3][3] + (1~3�������� ���� ��) �� ���� ���� �����ϸ� �ȴ�.
	 * 
	 * �̸� ��ȭ������ �����ϸ�,
	 * 3) dp[i][j] = MIN(dp[i][k] + dp[k + 1][j] + (i~j�������� ��), dp[i][j]);
	 * 
	 */
	private static int solve(int[] a){
		int size = a.length;
		int DP[][] = new int[size][size];	
		int s[] = new int[size];	

		s[0] = a[0];
		for(int i = 1; i < size; i++) {
			s[i] += s[i-1] + a[i];
		}
	
		for(int i = 0; i < size-1; i++) {
			DP[i][i+1] = a[i] + a[i+1];
		}

		for(int gap = 2; gap < size; gap++){	//i�� j�� gap 3ĭ���� ex) arr = {1, 2, 3} => (1, 2), 3�̷��� ���� �� i = 0(arr[0]), j = 2 (arr[2])
			for(int i = 0; i+gap < size; i++){	//i�ε���
				int j = i + gap;	//j�ε���
				DP[i][j] = Integer.MAX_VALUE;	//MIN�� ���ϱ� ����

				for(int k = i; k < j; k++)	//i < k < j
					DP[i][j] = Math.min(DP[i][k] + DP[k+1][j] + sum(s, i, j), DP[i][j]);
			}
		}
		return DP[0][size - 1];
	}
}
