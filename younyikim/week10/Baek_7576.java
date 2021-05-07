package level24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
	int row, col, day;
	public Point(int row, int col, int day) {
		this.row = row;
		this.col = col;
		this.day = day;
	}
}
public class Baek_7576 {
	static int[][] tomato;
	static int[] dx = {-1, 0, 1, 0}; 
	static int[] dy = {0, 1, 0, -1};	
	
	static int N;
	static int M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		tomato = new int[M][N]; 
	
		 
		for(int i = 0; i < M; i++) { 
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				tomato[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bfs();
		
	}
	
	private static void bfs() {
		Queue<Point> queue = new LinkedList<>();
		int day = 0;
		
		// �丶�䰡 �ִ� ��ǥ�� Queue�� �ִ´�.
		for(int i = 0; i < M; i++) { 
			for (int j = 0; j < N; j++) {
				if(tomato[i][j] == 1) {
					queue.offer(new Point(i,j,0));
				}
			}
		}
		
		while(!queue.isEmpty()) {
			Point point = queue.poll();
			day = point.day;
			
			//bfs�� ���鼭 �����¿쿡 �ִ� �丶�並 ������.
			for(int i = 0; i < 4; i++) {
                int nx = point.row + dx[i];
                int ny = point.col + dy[i];
 
                if(0 <= nx && nx < M && 0 <= ny && ny < N) {
                	if(tomato[nx][ny] == 0) {
                		tomato[nx][ny] = 1;
                		queue.offer(new Point(nx, ny, day + 1));
                	}
                }
                
             }
		}
		
		if(checkTomato()) {
			System.out.println(day);
		} else {
			System.out.println(-1);
		}
	}
	
	// tomato �迭 �� 0�� ���������� -> false || �ƴϸ� true
	static boolean checkTomato() {
		 for(int i = 0; i < M; i++) {
	         for(int j = 0; j < N; j++) {
	            if(tomato[i][j] == 0)
	            	return false;
	        }
		 }
		 return true;
	}
}
