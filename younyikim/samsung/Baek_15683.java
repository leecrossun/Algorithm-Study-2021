package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class CCTV {
	int num;
	int x;
	int y;

	CCTV(int num, int x, int y) {
		this.num = num;
		this.x = x;
		this.y = y;
	}
}

public class Baek_15683 {
	
	public static int N, M;
	public static int[][] map;
	public static int[][] copyMap;
	public static int[] output;
	public static ArrayList<CCTV> cctvList;
	
	public static int[] dx = {-1, 0, 1, 0}; // �� �� �� �� �ð���� ���� 
	public static int[] dy = {0, 1, 0, -1};
	
	public static int answer = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		cctvList = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] != 0 && map[i][j] != 6) {
					cctvList.add(new CCTV(map[i][j], i , j));
				}
			}
		}
		
		output = new int[cctvList.size()]; // ������ ���� �迭
		permutation(0, cctvList.size());

		System.out.println(answer);
	}
	
	public static void permutation(int depth, int r) {
		if(depth == r) {
			// 'map'�� �����Ѵ�.
			copyMap = new int[N][M];
			
			for(int i = 0; i < map.length; i++) {
				System.arraycopy(map[i], 0, copyMap[i], 0, map[i].length);
			}
			
			// cctv��ȣ�� ������ ������ ���⿡ �´� �����¿� ���� ���� 
			for(int i = 0; i < cctvList.size(); i++) {
				direction(cctvList.get(i), output[i]);
			}
			
			// �簢 ���� ���ϱ�
			getBlindSpot();
			
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			output[depth] = i;
			permutation(depth + 1, r);
		}
	}
	

	// �� cctv ��ȣ�� ������ ������ ���⿡ �°� ���� 
	public static void direction(CCTV cctv, int d) {
		int cctvNum = cctv.num;
		
		if(cctvNum == 1) {
			if(d == 0) watch(cctv, 0); // ��
			else if(d == 1) watch(cctv, 1); // ��
			else if(d == 2) watch(cctv, 2); // ��
			else if(d == 3) watch(cctv, 3); // ��
		} else if(cctvNum == 2) {
			if(d == 0 || d == 2) {
				watch(cctv, 0); // ��, ��
				watch(cctv, 2);
			} else {
				watch(cctv, 1); // ��, ��
				watch(cctv, 3);
			}
		}else if(cctvNum == 3) {
			if(d == 0) {
				watch(cctv, 0); // ��� 
				watch(cctv, 1);
			} else if(d == 1) { 
				watch(cctv, 1); // ���� 
				watch(cctv, 2);
			} else if(d == 2) { 
				watch(cctv, 2); // ���� 
				watch(cctv, 3);
			} else if(d == 3) { 
				watch(cctv, 0); // �»� 
				watch(cctv, 3);
			}
		} else if(cctvNum == 4) {
			if(d == 0) {
				watch(cctv, 0); // �»�� 
				watch(cctv, 1);
				watch(cctv, 3);
			} else if(d == 1) {
				watch(cctv, 0); // ����� 
				watch(cctv, 1);
				watch(cctv, 2);
			} else if(d == 2) {
				watch(cctv, 1); // ���Ͽ� 
				watch(cctv, 2);
				watch(cctv, 3);
			} else if(d == 3) {
				watch(cctv, 0); // ������ 
				watch(cctv, 2);
				watch(cctv, 3);
			}
		} else if(cctvNum == 5) { // �������
			watch(cctv, 0);
			watch(cctv, 1);
			watch(cctv, 2);
			watch(cctv, 3);
		}
	}
	
	// BFS�� ���⿡ �°� ����
	public static void watch(CCTV cctv, int d) {
		Queue<CCTV> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		
		q.add(cctv);
		visited[cctv.x][cctv.y] = true;

		while(!q.isEmpty()) {
			int nx = q.peek().x + dx[d];
			int ny = q.poll().y + dy[d];

			if(nx < 0 || nx >= N || ny < 0 || ny >= M || copyMap[nx][ny] == 6) { 
				break;
			}

			if(copyMap[nx][ny] == 0) { 
				copyMap[nx][ny] = -1; // ��ĭ�̶�� ������ �� �ִٴ� �ǹ̷� -1 
				q.add(new CCTV(cctv.num, nx, ny));
			} else { // �ٸ� cctv�� �ְų� �̹� ���õ� ĭ�̶�� 
				q.add(new CCTV(cctv.num, nx, ny)); // ��� 
			}
		}
	}
	
	public static void getBlindSpot() {
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(copyMap[i][j] == 0) {
					cnt++;
				}
			}
		}
		answer = Math.min(answer, cnt);
	}
}	

