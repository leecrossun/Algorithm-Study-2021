package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_14891 {
	
	static int[][] wheel = new int[4][8];
	
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int i = 0; i < 4; i++) {
			String str = br.readLine();
			
			for(int j = 0; j < 8; j++) {
				//  N�� : 0, S�� : 1
				wheel[i][j] = str.charAt(j) - '0'; 
			}
		}
		
		int k = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			
			int idx = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken()); //���� 1 : �ð����, ���� -1 : �ݽð� ����
			
			solution(idx - 1, dir);
		}
		
		// ����
		int score = 0;
		for(int i = 0; i < 4; i++) {
			score += wheel[i][0] * (1 << i);
		}
		
		System.out.println(score);
	}
	
	static void solution(int idx, int dir) {
		left(idx - 1, -dir);
		right(idx + 1, -dir);
		rotate(idx, dir);
	}
	
	// ȸ���ϴ� ��Ϲ����� ���ʿ� �ִ� ��� ������ ȸ������ ����
	static void left(int idx, int dir) {
		if(idx < 0) return;
		
		// �´��� ����� ���� �ٸ� ���
		if(wheel[idx][2] != wheel[idx + 1][6]) {
			left(idx - 1, -dir);
			rotate(idx, dir);
		}
	}
	
	// ȸ���ϴ� ��Ϲ����� �����ʿ� �ִ� ��� ������ ȸ������ ����
	static void right(int idx, int dir) {
		if(idx > 3) return;
		
		//�´��� ����� ���� �ٸ� ���
		if(wheel[idx][6] != wheel[idx - 1][2]) {
			right(idx + 1, -dir);
			rotate(idx, dir);
		}
	}
	
	static void rotate(int idx, int dir) {
		
		// �ð� ���� ȸ��
		if(dir == 1) {
			int tmp = wheel[idx][7];
			
			for(int i = 7; i > 0; i--) {
				wheel[idx][i] = wheel[idx][i - 1];
			}
			
			wheel[idx][0] = tmp;
		} 
		// �ݽð� ���� ȸ��
		else {
			int tmp = wheel[idx][0];
			
			for(int i = 0; i < 7; i++) {
				wheel[idx][i] = wheel[idx][i + 1];
			}
			
			wheel[idx][7] = tmp;
		}
	}
}
