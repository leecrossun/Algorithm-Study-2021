package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Baek_exam {
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		long cnt = 0; // ������ ��
		int[] a = new int[n]; // ������ ��
		
		StringTokenizer st = new StringTokenizer(br.readLine(), "");
		for(int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		int b = Integer.parseInt(br.readLine()); // �Ѱ����� ���� �� �ִ� �����
		int c = Integer.parseInt(br.readLine()); // �ΰ����� ���� �� �ִ� �����
		
		for(int i = 0; i < n; i++) {
			a[i] -= b; // �� ������ ������ �� ������ ���� �� �ִ� ������ ��ŭ ���ش�.
			cnt++;
			
			// �� ������ ���� �� �ִ� ���� �ΰ��� �ʿ� �����Ƿ� �Ѿ
			if(a[i] <= 0) {
				continue;
			}
			// �ΰ����� �߰��� �ʿ��� ���
			else {
				cnt += a[i] / c;
				// �������� 0���� ũ�� �ΰ��� �Ѹ� �� �߰�
				if(a[i] % c > 0) {
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}
}
