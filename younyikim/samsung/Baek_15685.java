package samsung;

import java.io.*;
import java.util.*;

public class Baek_15685 {
	
	static boolean map[][] = new boolean[101][101];
	static int dx[] = {1, 0, -1, 0};
	static int dy[] = {0, -1, 0, 1};
	static int answer = 0;
	
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			
			solution(x,y,d,g);
		}
		
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				// ���簢���� �� �������� ��� �巡�� Ŀ���� �Ϻ��� ���
				 if (map[i][j] && map[i][j + 1] && map[i + 1][j] && map[i + 1][j + 1]) {
					answer++;
				}
			}
		}
	
		System.out.println(answer);
	}
	
	public static void solution(int x, int y, int d, int g) {
		List<Integer> list = new ArrayList<>();
		list.add(d);
		
		// ���� ������ ���� ������ �ڿ��� ���� Ž���Ͽ� 1�� ������ ��, �ٽ� list�� �߰��Ѵ�.
		for(int i = 1; i <= g; i++) {
			for(int j = list.size() - 1; j >= 0; j--) {
				list.add((list.get(j) + 1) % 4);
			}
		}
		
		map[x][y] = true;
		
		for(Integer direction : list) {
			x += dx[direction];
			y += dy[direction];
			
			map[x][y] = true;
		}
	}
}
