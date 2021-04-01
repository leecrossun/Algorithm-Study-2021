package level_15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Baek_1931 {
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] value = new int[N][2];
		
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			value[i][0] = Integer.parseInt(st.nextToken());
			value[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(value, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				return o1[1] - o2[1];
			}
		});
		
		int last = 0;
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (last <= value[i][0]) {
				cnt++;
				last = value[i][1];
			}
		}
		System.out.println(cnt);
	}
}
