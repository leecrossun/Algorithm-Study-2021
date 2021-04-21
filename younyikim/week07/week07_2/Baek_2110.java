package level21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
	������ ��ǥ���� �����Ÿ��� 1�̳�, 2�̳� � ���� ���� �� �ִ� �������� ������ �޶�����.
	
	1 . �켱 �־��� ��ǥ�� �����Ѵ�.
		House = {1,2,4,8,9}�� ���ĵǰ�, ��ǥ�� �ּ� �Ÿ��� 1, �ִ� �Ÿ��� 8�̴�.
		�̸� ���� ��ǥ�� �Ÿ��� 1�϶�, ���� �� �ִ� �������� ������ ã�� �츮�� ���ƾ��� �������� ������ ���Ѵ�.
		�ݺ��Ͽ� ��ǥ�� �Ÿ��� 2�϶�, 3�϶�, . . . 8�϶����� �ݺ��Ѵ�.
	
	2. ó�� ���� start = 1, ���� end = 8�̶�� �Ѵ�.
	      �׸��� �߾Ӱ� mid = (start + end) / 2 = 4�� ���Ѵ�.
	
	3. ���� ��ǥ�� �Ÿ��� 4�� ������ ���캻��.
		start = 1������, ������ ���� �� �ִ� ��ǥ�� start + 4 = 5�̴�. House�� 5�� ���Ұ� ������, 5�̻��� ����
		���� ���� ���� ã�´�. House[3] = 8�� ���� �� �ִ�. start�� �����⸦ ���� ��, ���ο� �����⸦ �ϳ� �� ��������
		count���� �ϳ� ���������ش�. 
		�״��� ��ǥ �Ÿ��� 4�� ������ �ִ� ���� �ֳ� ���캻��. 
	
		���������� ��ǥ �Ÿ��� 4�϶� ���� �� �ִ� ������� 1, 8�� �ϳ���, �� 2���̴�.
		
	4. �츮�� ���ϴ� �������� ������ 3���̱⶧����, ������ �ٿ����Ѵ�.
	  (���� �츮�� ���ϴ� �������� �������� ���� �������� ���� ���� ��쿡�� ������ �÷��ָ� �ȴ�.)
	5. 2~3 �ݺ�  
*/

public class Baek_2110 {
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        
        int[] House = new int[N];
        for(int i = 0; i < N; i++) {
        	House[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(House);
        
        int start = 1;
        int mid;
        int end = House[N - 1] - House[0];
        
        
        while(start <= end) {
        	mid = (start + end) / 2;
        	int cnt = 1;
        	int prev = House[0];
        	 
        	for (int i = 0; i < House.length; i++) {
        		if(House[i] >= prev + mid) {
        			cnt++;
        			prev = House[i];
        		}
        	}
        	
        	// �����⸦ C������ ���� ��ġ�� ��� => ������ ����
        	if (cnt >= C) { 
        		start = mid + 1;
        	}
        	// �����⸦ C������ ���� ��ġ�� ��� => ������ ����
        	else {
        		end = mid - 1;
        	}
        }
        System.out.println(end);
	}
}
