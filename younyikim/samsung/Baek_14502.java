package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_14502 {
	
	static class virus {
		int x, y;
		
		virus(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private static int result = Integer.MIN_VALUE; // ���������� ��
	private static int N, M;
	
	private static int dx[] = {0, 0, 1, -1};
    private static int dy[] = {-1, 1, 0, 0};
    
    private static int lab[][];
    private static int lab_copy[][];
    
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		lab = new int[N][M];
		lab_copy = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			 st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				lab[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		lab_copy = lab;
		
		dfs(0);
		
		System.out.println(result);
	}
	
	public static void dfs(int depth) {
		// 3���� ���� ��� ���� ���
		if(depth == 3) {
			bfs();
			return;
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				
				// ���� ���� ���
				if(lab[i][j] == 0) {
					lab[i][j] = 1; 
					
					dfs(depth + 1);
					
					// ���� �ٽ� �����Ѵ�.
					lab[i][j] = 0;
				}
			}
		}
	}
	
	public static void bfs() {
		int[][] virus_check = new int[N][M];
		Queue<virus> q = new LinkedList<virus>();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				virus_check[i][j] = lab[i][j];
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				
				// ���̷����� ��� queue�� �ִ´�
				if(virus_check[i][j] == 2) {
					q.add(new virus(i, j));
				}
			}
		}
		
		while(!q.isEmpty()) {
			virus v = q.remove();
			
			for(int i = 0; i < 4; i++) {
				int nx = v.x + dx[i];
				int ny = v.y + dy[i];
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
					
					// ���̷����� ���� ���� ��ĭ�� ���, ���̷����� ��Ʈ����.
					if(virus_check[nx][ny] == 0) {
						virus_check[nx][ny] = 2;
						q.add(new virus(nx, ny));
					}
				}
			}
		}
		
		calc(virus_check);
	}
	
//	���� ������ �ִ� ������ ���Ѵ�.
	public static void calc(int[][] virus_check) {
		
		int cnt = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				
				if(virus_check[i][j] == 0) {
					cnt ++;
				}
			}
		}
		
		result = Math.max(result, cnt);
	}
}
