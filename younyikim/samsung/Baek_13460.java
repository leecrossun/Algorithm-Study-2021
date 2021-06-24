package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_13460 {
	static class Ball {
		int ri;
		int rj;
		int bi;
		int bj;
		int cnt;
		
		Ball(int ri, int rj, int bi, int bj, int cnt) {
			this.ri = ri;
			this.rj = rj;
			this.bi = bi;
			this.bj = bj;
			this.cnt = cnt;
		}
	}
	
	static int N, M;
	static int rx, ry, bx, by; // ���� ���� �Ķ� ���� ��ġ ��ǥ
	static char[][] board;
	
	static int dx[] = {0, 1, 0 ,-1};
	static int dy[] = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken()); // ����
		M = Integer.parseInt(st.nextToken()); // ����
		
		board = new char[N][M];
		for(int i = 0; i < N; i++) {
			board[i] = br.readLine().trim().toCharArray();
			for(int j = 0; j < M; j++) {
				if(board[i][j] == 'R') {
					rx = i;
					ry = j;
				} else if(board[i][j] == 'B') {
					bx = i;
					by = j;
				}
			}
		}
		bfs();
	}
	private static void bfs() {
		Queue<Ball> q = new LinkedList<Ball>();
		int [][][][] check = new int[N][M][N][M];
		
		check[rx][ry][bx][by] = 1;
		q.offer(new Ball(rx, ry, bx, by, 0));
		
		while(!q.isEmpty()) {
			Ball b = q.poll();
			
			// 10�� ���Ϸ� ������ �� ���� ��� 
			if(b.cnt > 10) {
				System.out.println(-1);
				System.exit(0);
			}
			
			// �Ķ� ���� ���ۿ� ������ ��� ���� 
			if(board[b.bi][b.bj] == 'O') {
				continue;
			}
			
			// ���� : ���� ���� ���ۿ� ������, �Ķ� ���� ������ �ʴ� ���
			if(board[b.ri][b.rj] == 'O' && board[b.bi][b.bj] != 'O') {
				System.out.println(b.cnt);
				System.exit(0);
			}
			
			for(int i = 0; i < 4; i++) {
				//���� �� ������
				int rni = b.ri;
				int rnj = b.rj;
				
				while(true) {
					rni += dx[i];
					rnj += dy[i];
					
					if(board[rni][rnj] == 'O' || board[rni][rnj] == '#') {
						break;
					}
				}
				if(board[rni][rnj] == '#') {
					rni -= dx[i];
					rnj -= dy[i];
				}
				
				//�Ķ� �� ������
				int bni = b.bi;
				int bnj = b.bj;
				
				while(true) {
					bni += dx[i];
					bnj += dy[i];
					
					if(board[bni][bnj] == 'O' || board[bni][bnj] == '#') {
						break;
					}
				}
				if(board[bni][bnj] == '#') {
					bni -= dx[i];
					bnj -= dy[i];
				}
				
				// ���� : ���� ���� �Ķ� ���� ���� ĭ�� ��ġ�� ���
				if(rni == bni && rnj == bnj && board[rni][rnj] != 'O') {
					int redball_dis = Math.abs(rni - b.ri) + Math.abs(rnj - b.rj);
					int blueball_dis = Math.abs(bni - b.bi) + Math.abs(bnj - b.bj);
					
					if(redball_dis > blueball_dis) {
						rni -= dx[i];
						rnj -= dy[i];
					} else {
						bni -= dx[i];
						bnj -= dy[i];
					}
				}
				
				//���� �湮���� ���� ���
				if(check[rni][rnj][bni][bnj] == 0) {
					check[rni][rnj][bni][bnj] = 1;
					q.offer(new Ball(rni, rnj, bni, bnj, b.cnt + 1));
				}
			}
		}
		System.out.println(-1);
	}
	
}	
