package level23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_11049 {
	static int N;
	static int[][] map;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        map = new int[N][2];
        dp = new int[N][N];
        
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	map[i][0] = Integer.parseInt(st.nextToken());
        	map[i][1] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = 0; i < N; i++) {
        	for (int j = 0; j < N; j++) {
        		if(i == j) {
        			dp[i][j] = 0;
        		} else {
        			dp[i][j] = Integer.MAX_VALUE;
        		}
        	}
        }
        
        // dp�� �밢�� ���ݸ� Ž�� 
        for (int c = 1; c < N; c++) {
        	for (int i = 0; i + c < N; i++) {
        		solve(i, i + c);
        	}
        }
        System.out.println(dp[0][N - 1]);
	}
	/*
	 * A~i��, i~B������ ���ϴ� ������,
	 * [A~i]������ ������ �� + [i + 1, B]�������� ����� + (A * i * B)
	 * 
	 * ex) N = 4, A(5,3), B(3, 2), C(2, 6), D(6, 3)�� �ִٰ� ����.
	 * 
	 *	dp[1][3]�� �����غ���. dp[1][3]�� B*D�� ������ �ϴ� ���̱� ������
	 *	(B*C)*D or B(C*D) �ΰ��� ��찡 �ְ�, �� ��쿡 + ���ϴµ� ��� ��� �� �ּ� ���� dp[1][3]�� �����̴�.
	 *  (B*C)D => dp[1][2] + dp[3][3] + (map[1][0]*map[2][1]*map[3][1])
	 *  B(C*D) => dp[1][1] + dp[2][3] + (map[1][0]*map[1][1]*map[3][1])
	 *  
	 *  �̸� ��ȭ������ ǥ���ϸ�,
	 *  dp[start][i] + dp[i + 1][end] + (map[start][0]*map[i][1]*map[end][1])
	 *  
	 *  
	 *  map[start][0]*map[i][1]*map[end][1] ��
	 *  ���� ��� (BC)D = (3*6) * D = (3*6) * (6*3) = 3*6*3
	 */
	public static void solve(int start, int end) {
		for (int i = start; i < end; i++) {
			int cost = dp[start][i] + dp[i + 1][end] + (map[start][0] * map[i][1] * map[end][1]);
			dp[start][end] = Math.min(dp[start][end], cost);
		}
	}
	
}	
