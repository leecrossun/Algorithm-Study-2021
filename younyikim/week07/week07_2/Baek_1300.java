package level21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_1300 {
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
				
		int start = 1;
		int mid;
		int end = K;
		
		int ans = 0;
		
		while(start <= end) {
			mid = (start + end) / 2;
			int tmp = 0;
			
			for (int i = 1; i <= N; i++) {
				tmp += Math.min(mid / i, N);
			}
			// mid ���� �۰ų� ���� ���� ������ K���� ������ => mid�� ����.
			if (tmp >= K) {
				end = mid - 1;
				ans = mid;
			}
			// mid ���� �۰ų� ���� ���� ������ K���� ������ => mid�� Ű��.
			else {
				start = mid + 1;
			}
		}
		System.out.println(ans);
	}	
}
