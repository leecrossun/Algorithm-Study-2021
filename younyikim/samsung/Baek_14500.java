package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * DFS(��Ʈ��ŷ) 
 */
public class Baek_14500 {
	private static int n, m, a[][], result;
	private static boolean check[][];
	
	private static int dx[] = {0, 0, 1, -1};
    private static int dy[] = {-1, 1, 0, 0};
    
    private static int ex[][] = {{0, 0, 0, 1}, {0, 1, 2, 1}, {0, 0, 0, -1}, {0, -1, 0, 1}};
    private static int ey[][] = {{0, 1, 2, 1}, {0, 0, 0, 1}, {0, 1, 2, 1}, {0, 1, 1, 1}};
    
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		a = new int[n + 1][m + 1];
		check = new boolean[n + 1][m + 1];
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				check[i][j] = false;
			}
		}
		
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 1; j <= m; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				check[i][j] = true;
				
				dfs(i, j, a[i][j], 1);
				
				/* check�� �����ϴ���, length�� ���� ��͸� �ߴܽ�Ű�� ������ 
				     ����Ƚ���� �� ���� 4 * 3 * 3 = 36ȸ�� �ִ��̴�.*/
				check[i][j] = false;
				
				/*��Ʈ�ι̳��� ����� '��' �� ���*/
				check_shape(i, j);
			}
		}
		System.out.println(result);
	}
	
	public static int max(int a, int b) {
		return a > b ? a : b;
	}
	
	public static void dfs(int x, int y, int sum_value, int length) {
		if(length >= 4) {
			result = max(result, sum_value);
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			// ������ ���� �˻�
			if(nx < 1 || nx > n|| ny < 1 || ny > m) continue;
			
			// �湮���� ���� ���� ���
			if(check[nx][ny] == false) {
				
				check[nx][ny] = true;
				
				dfs(nx, ny, sum_value + a[nx][ny], length + 1);
				
				/*
				 * �ϳ��� ��Ʈ�ι̳븦 Ž���� ��, �̰����� ���ƿ´�.
				 * �ϳ��� ��Ʈ�ι̳븦 ��Ī, ȸ�� ��Ű�� ���ؼ� �湮�� ���� �ٽ� �湮�� dfs�� �����ؾ��Ѵ�.
				 * �׷��� �� ���� Ž�� ��, ���� �� üũ�� ��ü�Ѵ�. 
				 */
				check[nx][ny] = false;
			}
		}
	}
	
	// ��Ʈ�ι̳��� ����� '��' �� ���
	public static void check_shape(int x, int y) {
		for(int i = 0; i < 4; i++) {
			Boolean isOut = false;
			int sum_value = 0;
			
			for(int j = 0; j < 4; j++) {
				int nx = x + ex[i][j];
				int ny = y + ey[i][j];
				
				// ���� ���� �˻�
				if(nx < 1 || nx > n || ny < 1 || ny > m) {
                    isOut = true;
                    break;
                } else {
                	sum_value += a[nx][ny];
                }
			}
			
			if(!isOut) {
				result = max(result, sum_value);
			}
		}
	}
}
