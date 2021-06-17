package level31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Baek_2533 {
	public static LinkedList<Integer>[] adjList;
	public static boolean[] visited;
	public static int[][] dp;
	public static int N;
	public static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		adjList = new LinkedList[N+1];
		visited = new boolean[N+1];
		dp = new int[N+1][2];

		// ���� N���� ���� ����Ʈ ���� 
		for (int i = 1; i <= N; i++) {
			adjList[i] = new LinkedList<Integer>();
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N-1; i++) {
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			adjList[a].add(b);
			adjList[b].add(a);
		}

		//dfs(1); // 1�� ��Ʈ�� ������ 1���� ���� 
		dp(1, -1); // 1���� �����̶� parent�� -1 ���� ���� 

		System.out.println(Math.min(dp[1][0], dp[1][1]));

	}

	public static void dfs(int cur) {
		//���� ������ �󸮾���Ͱ� �ƴ� ��� 0 
		// -> ���� ���� �󸮾���Ϳ����� ���̵� ������ �� ���� 
		dp[cur][0] = 0; 
		
		// �󸮾������ ��� 1 
		// -> ���� ���� �󸮾�����̰ų� �ƴ� ���� ����, �� ���� dfs�� �ľ� �� �� ���� ������ �ʱ�ȭ 
		dp[cur][1] = 1; 
		visited[cur] = true;
		
		LinkedList<Integer> list = adjList[cur];
		
		for(int i = 0; i < list.size(); i++) {
        	// DFS ���� ������ ������ �� �� �ٽ� ���� �ʱ� ����, ���� �湮���� ���� ���� ������ ��츸 DFS 
			if(!visited[list.get(i)]) { 
				dfs(list.get(i)); // ���� ������ �������� �ٽ� dfs 
				dp[cur][0] += dp[list.get(i)][1];
				// ���� ��尡 �󸮾�������� �ƴ��� �Ǵ� �� �� ���� ������ �ʱ�ȭ 
				dp[cur][1] += Math.min(dp[list.get(i)][0], dp[list.get(i)][1]); 
			}
		}
	}

	public static void dp(int cur, int parent) {
		dp[cur][0] = 0; 
		dp[cur][1] = 1;
		
		for(int next : adjList[cur]) {
			// ���� ��� next�� �θ� ��� parent�� �ٸ� ��츸 Ȯ��
			// (���ٴ� �� �̹� ������ Ȯ���ߴٴ� ��) -> ����Ŭ X, �θ�� �����ϱ� ���� 
			if(next != parent) { 
				// parent�� ���� ��� ���� �־�, ���� �б⿡�� �Ǵ��� �� �ֵ��� �� 
				dp(next, cur); 
				dp[cur][0] += dp[next][1];
				dp[cur][1] += Math.min(dp[next][0], dp[next][1]);
			}
		}
	}
}
