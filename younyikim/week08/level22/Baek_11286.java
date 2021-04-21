package level22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Baek_11286 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());	
		
		PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) ->  {
			int abs1 = Math.abs(o1);
			int abs2 = Math.abs(o2);
			
			/*
			 *  o1 > o2 == 1 :���
			 *  o1 < o2 == -1 :����
			 *  
			 *  o1,o2�� ���밪�� ���ٸ� ���� ���ڸ� �������� ������������ �����ϰ�, 
			 *  �׷��� ������ ���밪�� �������� ������������ ����
			 *  
			 *  ��� ����: �������� / ���� ����: �������� / 0 ����: ��������
			 *  
			 *  abs() : ���밪 ��ȯ �Լ� 
			 */
			
			if(abs1 == abs2) {
				return o1 > o2 ? 1 : -1;
			}
			return abs1 - abs2;
		});
		
		while(N --> 0) {
			int X = Integer.parseInt(br.readLine());
			
			if (X == 0 ) {
				if(heap.isEmpty()) {
					sb.append(0).append('\n');
				} else {
					sb.append(heap.poll()).append('\n');
				}
			}
			else {
				heap.offer(X);
			}
		}
		System.out.println(sb);
	}
}
