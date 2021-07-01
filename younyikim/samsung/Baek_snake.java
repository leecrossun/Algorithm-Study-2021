package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// ��
// NxN ���簢�� ����
// ���� �� ���� ��ġ(1,1), ó�� ������ ������ ����
// ���� ��� �Ӹ����� �þ
// ��� ������ ��� �������� �Ӹ� �÷��� ���� �״��
// ��� ������ �Ӹ� �÷��� ������ ��ġ�� ĭ �����
public class Baek_snake {

	static int n; // ������ ũ�� (2~100)
	static int k; // ����� ���� (0~100)
	static int l; // ���� ���� ��ȯ Ƚ�� (1~100)
	static int time; // ���� �ð�
	static int[][] board;
	
	static List<int[]> snake; //���� ���� ��ġ (x,y)
	
	// ó�� ������ ������ ������ ���� ����
	// 0:������   1:�Ʒ���   2:����   3:��
	// D(������)�� �ٿ��� index++
	// L(����)�� ������ index--
	static int index = 0;
	static int[] dx = {0, 1, 0, -1}; //����
	static int[] dy = {1, 0, -1, 0}; //����
	
	static Map<Integer, String> dir; 
	
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		
		board = new int[n+1][n+1];
		
		// ��� ��ġ 
		String str;
		int row; // ��
		int col; // ��
		for(int i=0; i<k; i++) {
			str = br.readLine();
			
			row = Integer.parseInt(str.split(" ")[0]);
			col = Integer.parseInt(str.split(" ")[1]);
			
			board[row][col] = 1;
		}
		
		// �� ���� ���� �Է�
		dir = new HashMap<>();
		l = Integer.parseInt(br.readLine());
		for(int i=0; i<l; i++) {
			str = br.readLine();
			int timeInfo = Integer.parseInt(str.split(" ")[0]);
			String directionInfo = str.split(" ")[1];
			
			dir.put(timeInfo, directionInfo);
		}
		
		// �� ���� ���� (1,1) (x,y)
		snake = new LinkedList<>();
		snake.add(new int[]{1,1});
		
		time = 0;
		int nx, ny; // ���� ������
		int cx, cy; // ���� ������(1,1)
		cx = 1;
		cy = 1;
		
		// �� ������ ����
		while(true) {
			time++;
			
			// ���� ������(�Ӹ� ������)
			nx = cx + dx[index];
			ny = cy + dy[index];
			
			if(isFinish(nx,ny)) {
				break;
			}
			
			// ��� �ִ��� Ȯ�� => ��� ������ ��� �������� �Ӹ� �÷��� ���� �״��
			if(board[nx][ny] == 1) {
				board[nx][ny] = 0;
				snake.add(new int[] {nx,ny}); 
			}
			
			// ��� ������ �Ӹ� �÷��� ������ ��ġ�� ĭ �����
			else {
				snake.add(new int[] {nx,ny});
				snake.remove(0); 
			}
			 
			cx = nx;
			cy = ny;
			
			if(dir.containsKey(time)) {
				// D(������)�� �ٿ��� index++
				if(dir.get(time).equals("D")) {
					index++;
					if(index == 4)
						index = 0;
				}
				// L(����)�� ������ index--				
				if(dir.get(time).equals("L")) {
					index--;
					if(index == -1)
						index = 3;
				}
				
			}
		}
		System.out.println(time);
	}
	
	// ������ �������� Ȯ��
	static boolean isFinish(int nx, int ny){
		
		// ���� �ε����� ���
		if(nx<1 || ny<1 || nx>=n+1 || ny>=n+1) 
			return true;
		
		// �ڱ� ���뿡 ��� ���
		for(int i=0; i<snake.size(); i++) {
			if(nx == snake.get(i)[0] && ny == snake.get(i)[1]) 
				return true;
		}
		
		return false;
	}

}